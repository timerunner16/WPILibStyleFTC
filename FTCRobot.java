package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Gamepad;


public class FTCRobot {
    private static FTCRobot instance = null;
    
    private HardwareMap m_hardwareMap = null;
    private Telemetry m_telemetry = null;
    private Gamepad m_gamepad1 = null;
    private Gamepad m_gamepad2 = null;
    private boolean m_inTeleop = false;
    
    private RobotContainer m_robotContainer = null;
    
    private FTCRobot(
            HardwareMap hardwareMap, Telemetry telemetry,
            Gamepad gamepad1, Gamepad gamepad2,
            boolean inTeleop) {
        m_hardwareMap = hardwareMap;
        m_telemetry = telemetry;
        m_gamepad1 = gamepad1;
        m_gamepad2 = gamepad2;
        m_inTeleop = inTeleop;
        instance = this;

        m_robotContainer = new RobotContainer();
    }
    
    public static FTCRobot getInstance() {
        return instance;
    }
    
    public static FTCRobot createFTCRobot(
            HardwareMap hardwareMap, Telemetry telemetry,
            Gamepad gamepad1, Gamepad gamepad2,
            boolean inTeleop) {
        if (instance != null) return instance;
        instance = new FTCRobot(
            hardwareMap, telemetry,
            gamepad1, gamepad2,
            inTeleop);
        return instance;
    }
    
    public void process() {
        CommandScheduler scheduler = CommandScheduler.getInstance();
        scheduler.process();
        
        m_telemetry.update();
    }
    
    public HardwareMap getHardwareMap() {
        return m_hardwareMap;
    }
    
    public Telemetry getTelemetry() {
        return m_telemetry;
    }
    
    public Gamepad getDriverGamepad() {
        return m_gamepad1;
    }
    
    public Gamepad getOperatorGamepad() {
        return m_gamepad2;
    }
    
    public boolean getInTeleop() {
        return m_inTeleop;
    }
}
