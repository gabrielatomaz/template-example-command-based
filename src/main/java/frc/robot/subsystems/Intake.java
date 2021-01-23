package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    private Victor motor;
    private Solenoid solenoid;

    public Intake() {
        this.motor = new Victor(IntakeConstants.motorPort);
        this.solenoid = new Solenoid(IntakeConstants.solenoidPort);
    }
    
    public void setSpeed(double speed) {
        this.motor.set(speed);
    }

    public void setValue(boolean isUp) {
        this.solenoid.set(isUp);
    }
}
