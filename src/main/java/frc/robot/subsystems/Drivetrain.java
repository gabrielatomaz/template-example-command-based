package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  private SpeedControllerGroup motorsRight, motorsLeft;
  private DifferentialDrive drive;

  public Drivetrain() {
    this.motorsRight = new SpeedControllerGroup(
      new VictorSP(DrivetrainConstants.motorRightPort[0]), 
      new VictorSP(DrivetrainConstants.motorRightPort[1])
    );
    this.motorsLeft = new SpeedControllerGroup(
      new VictorSP(DrivetrainConstants.motorLeftPort[0]), 
      new VictorSP(DrivetrainConstants.motorLeftPort[1])
    );

    this.drive = new DifferentialDrive(this.motorsRight, this.motorsLeft);
  }

  public void arcadeDrive(double forward, double rotation) {
    this.drive.arcadeDrive(forward, rotation);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Right speed", this.motorsRight.get());
    SmartDashboard.putNumber("Left speed", this.motorsLeft.get());
  }
}
