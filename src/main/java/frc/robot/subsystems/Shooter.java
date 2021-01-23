package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
    private Talon motorRight, motorLeft;

    public Shooter() {
        this.motorRight = new Talon(ShooterConstants.motorRight);
        this.motorLeft = new Talon(ShooterConstants.motorLeft);
    }

    public void setSpeed(double speed) {
        this.motorRight.set(speed);
        this.motorLeft.set(speed);
    }
}
