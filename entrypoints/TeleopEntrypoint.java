package org.firstinspires.ftc.teamcode.entrypoints;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.FTCRobot;


@TeleOp(name = "Teleop Entrypoint", group = "Linear OpModes")
public class TeleopEntrypoint extends LinearOpMode{
    @Override
    public void runOpMode() {
        FTCRobot robot = FTCRobot.createFTCRobot(
            hardwareMap, telemetry,
            gamepad1, gamepad2,
            true);
        
        waitForStart();
        
        while (opModeIsActive()) {
            robot.process();
        }
    }
}
