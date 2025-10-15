package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.util.Trigger;
import java.util.ArrayList;


public class CommandScheduler {
    private static CommandScheduler instance = null;

    private ArrayList<Command> scheduledCommands = null;
    private ArrayList<SubsystemBase> registeredSubsystems = null;
    private ArrayList<Trigger> registeredTriggers = null;

    private CommandScheduler() {
        scheduledCommands = new ArrayList<Command>();
        registeredSubsystems = new ArrayList<SubsystemBase>();
        registeredTriggers = new ArrayList<Trigger>();
    }

    public static CommandScheduler getInstance() {
        if (instance == null) instance = new CommandScheduler();
        return instance;
    }

    public void process() {
        for (SubsystemBase subsystem : registeredSubsystems) {
            subsystem.periodic();
            Command command = subsystem.getDefaultCommand();
            if (command != null && !isBlockedByRequirements(command)) {
                scheduledCommands.add(0, command);
                command.initialize();
            }
        }
        for (Trigger trigger : registeredTriggers)
            trigger.process();

        int i = 0;
        while (i < scheduledCommands.size()) {
            Command scheduledCommand = scheduledCommands.get(i);
            scheduledCommand.execute();
            if (scheduledCommand.isFinished()) {
                scheduledCommand.end();
                removeScheduledCommand(scheduledCommand);
            } else i++;
        }
    }

    public boolean isCommandScheduled(Command command) {
        return scheduledCommands.contains(command);
    }

    public void addScheduledCommand(Command command) {
        if (isCommandScheduled(command)) return;
        removeWithMatchedRequirements(command);
        scheduledCommands.add(0, command);
        command.initialize();
    }

    private boolean isBlockedByRequirements(Command command) {
        for (int i = 0; i < scheduledCommands.size(); i++) {
            Command scheduledCommand = scheduledCommands.get(i);

            for (SubsystemBase requiredSubsystem : command.requirements) {
                if (scheduledCommand.requirements.contains(requiredSubsystem))
                    return true;
            }
        }
        return false;
    }

    private void removeWithMatchedRequirements(Command command) {
        int i = 0;
        while (i < scheduledCommands.size()) {
            Command scheduledCommand = scheduledCommands.get(i);
            boolean blocked = false;

            for (SubsystemBase requiredSubsystem : command.requirements) {
                if (scheduledCommand.requirements.contains(requiredSubsystem)) {
                    blocked = true;
                    break;
                }
            }

            if (blocked) {
                scheduledCommand.end();
                removeScheduledCommand(scheduledCommand);
            } else i++;
        }
    }

    public void removeScheduledCommand(Command command) {
        if (isCommandScheduled(command)) scheduledCommands.remove(command);
    }

    public void registerSubsystem(SubsystemBase subsystem) {
        registeredSubsystems.add(0, subsystem);
    }

    public void registerTrigger(Trigger trigger) {
        registeredTriggers.add(0, trigger);
    }
}
