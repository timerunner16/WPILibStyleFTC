package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.Command;
import org.firstinspires.ftc.teamcode.subsystems.Intake;


public class IntakeSpinOut extends Command {
    private Intake m_intake;
    
    public IntakeSpinOut() {
        m_intake = Intake.getInstance();
        addRequirements(m_intake);
    }
    
    @Override
    public void execute() {
        m_intake.outtake();
    }
}
