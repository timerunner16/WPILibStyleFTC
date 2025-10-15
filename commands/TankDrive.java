package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.FTCRobot;
import org.firstinspires.ftc.teamcode.Command;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.subsystems.Drive;


public class TankDrive extends Command {
    private Drive m_drive;
    
    public TankDrive() {
        m_drive = Drive.getInstance();
        addRequirements(m_drive);
    }
    
    @Override
    public void execute() {
        Gamepad driverGamepad = FTCRobot.getInstance().getDriverGamepad();

        m_drive.setPowers(
            -driverGamepad.left_stick_y,
            driverGamepad.right_stick_y);
    }
}
