package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.FTCRobot;
import org.firstinspires.ftc.teamcode.SubsystemBase;
import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;


public class Intake extends SubsystemBase {
    private static Intake instance = null;
    
    private DcMotor m_intakeMotor;
    
    private double speed = 0.0;
    
    private Intake() {
        super();
        HardwareMap hardwareMap = FTCRobot.getInstance().getHardwareMap();
        m_intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
    }
    
    public static Intake getInstance() {
        if (instance == null) instance = new Intake();
        return instance;
    }
    
    public void setPower(double power) {
        m_intakeMotor.setPower(power);
    }
    
    public void intake() {
        speed = -IntakeConstants.kMaxSpinSpeed;
    }
    
    public void outtake() {
        speed = IntakeConstants.kMaxSpinSpeed;
    }
    
    @Override
    public void periodic() {
        setPower(speed);
        speed -= speed * 0.05;
    }
}
