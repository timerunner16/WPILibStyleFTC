package org.firstinspires.ftc.teamcode.util;

import org.firstinspires.ftc.teamcode.CommandScheduler;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Command;
import org.firstinspires.ftc.teamcode.FTCRobot;
import java.util.function.BooleanSupplier;
import java.util.ArrayList;


public class Trigger {
    private BooleanSupplier m_trigger = null;
    private ArrayList<Command> onTrueCommands;
    private ArrayList<Command> whileTrueCommands;
    private boolean lastCycleVal = false;

    public Trigger(BooleanSupplier trigger) {
        m_trigger = trigger;
        onTrueCommands = new ArrayList<Command>();
        whileTrueCommands = new ArrayList<Command>();
        CommandScheduler.getInstance().registerTrigger(this);
    }

    public void process() {
        boolean currentCycleVal = m_trigger.getAsBoolean();
        Telemetry telemetry = FTCRobot.getInstance().getTelemetry();
        telemetry.addData("current", currentCycleVal);

        if (currentCycleVal) {
            for (Command command : whileTrueCommands)
                command.schedule();

            if (currentCycleVal != lastCycleVal) {
                for (Command command : onTrueCommands) {
                    command.schedule();
                }
            }
        } else {
            if (lastCycleVal) for (Command command : whileTrueCommands)
                command.cancel();
        }

        lastCycleVal = currentCycleVal;
    }

    public Trigger onTrue(Command command) {
        onTrueCommands.add(0, command);
        return this;
    }

    public Trigger whileTrue(Command command) {
        whileTrueCommands.add(0, command);
        return this;
    }
}
