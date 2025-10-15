package org.firstinspires.ftc.teamcode;


public class SubsystemBase {
    private Command m_defaultCommand = null;
    
    public SubsystemBase() {
        CommandScheduler.getInstance().registerSubsystem(this);
    }
    
    public void setDefaultCommand(Command defaultCommand) {
        m_defaultCommand = defaultCommand;
    }
    
    public Command getDefaultCommand() {
        return m_defaultCommand;
    }
    
    public void periodic() {}
}
