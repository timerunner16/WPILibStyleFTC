package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;


public class Command {
    public ArrayList<SubsystemBase> requirements;

    public void initialize() {}
    public void execute() {}
    public void end() {}
    public boolean isFinished() {return false;}
    
    public void schedule() {
        CommandScheduler scheduler = CommandScheduler.getInstance();
        if (!scheduler.isCommandScheduled(this)) {
            scheduler.addScheduledCommand(this);
        }
    }
    
    public void cancel() {
        CommandScheduler scheduler = CommandScheduler.getInstance();
        if (scheduler.isCommandScheduled(this)) {
            scheduler.removeScheduledCommand(this);
        }
    }
    
    public void addRequirements(SubsystemBase... subsystems) {
        if (requirements == null) requirements = new ArrayList<SubsystemBase>();
        for (SubsystemBase subsystem : subsystems)
            requirements.add(0, subsystem);
    }
}
