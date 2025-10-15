package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.FTCRobot;
import org.firstinspires.ftc.teamcode.SubsystemBase;


public class Drive extends SubsystemBase {
    private static Drive instance = null;
    
    private DcMotor m_leftMotor;
    private DcMotor m_rightMotor;
    
    private Drive() {
        super();
        HardwareMap hardwareMap = FTCRobot.getInstance().getHardwareMap();
        m_leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        m_rightMotor = hardwareMap.get(DcMotor.class, "right_motor");
    }
    
    public static Drive getInstance() {
        if (instance == null) instance = new Drive();
        return instance;
    }
    
    public void setPowers(double left, double right) {
        m_leftMotor.setPower(left);
        m_rightMotor.setPower(right);
    }
}
