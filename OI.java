package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.commands.IntakeSpinIn;
import org.firstinspires.ftc.teamcode.commands.IntakeSpinOut;
import org.firstinspires.ftc.teamcode.util.Trigger;

public class OI {
    private static OI m_OI = null;
    
    private OI() {
        // configure drive inputs
    }
    
    public static OI getInstance() {
        if (m_OI == null) {
            m_OI = new OI();
        }
        return m_OI;
    }
    
    public void bindControls() {
        Gamepad driverGamepad = FTCRobot.getInstance().getDriverGamepad();
        //Gamepad operatorGamepad = FTCRobot.getInstance().getOperatorGamepad();

        new Trigger(() -> {return driverGamepad.dpad_up;})
            .whileTrue(new IntakeSpinIn());
        new Trigger(() -> {return driverGamepad.dpad_down;})
            .whileTrue(new IntakeSpinOut());
    }
}

