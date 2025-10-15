package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.Command;
import org.firstinspires.ftc.teamcode.subsystems.Intake;


public class IntakeSpinIn extends Command {
    private Intake m_intake;
    
    public IntakeSpinIn() {
        m_intake = Intake.getInstance();
        addRequirements(m_intake);
    }
    
    @Override
    public void execute() {
        m_intake.intake();
    }
}
