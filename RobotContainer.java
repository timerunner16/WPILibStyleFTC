package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.util.Trigger;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.commands.TankDrive;


public class RobotContainer {
    private final OI m_OI;

    public RobotContainer() {
        m_OI = OI.getInstance();

        Intake.getInstance();
        Drive drive = Drive.getInstance();
        drive.setDefaultCommand(new TankDrive());

        configureBindings();
    }

    private void configureBindings() {
        m_OI.bindControls();
    }
}

