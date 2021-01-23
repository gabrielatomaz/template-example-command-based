package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.autonomous.InnerGoal;
import frc.robot.commands.buffer.Feed;
import frc.robot.commands.buffer.Rollback;
import frc.robot.commands.buffer.StopBuffer;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.intake.CollectPowerCell;
import frc.robot.commands.intake.StopIntake;
import frc.robot.commands.shooter.PushPowerCell;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.subsystems.Buffer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private Drivetrain drivetrain;
  private Intake intake;
  private Shooter shooter;
  private Buffer buffer;

  private XboxController driver, operator;

  private SendableChooser<Command> chooser;

  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.intake = new Intake();
    this.shooter = new Shooter();
    this.buffer = new Buffer();

    this.chooser = new SendableChooser<>();
    
    this.driver = new XboxController(OIConstants.driverControllerPort);
    this.operator = new XboxController(OIConstants.operatorControllerPort);

    this.configureAutonomous();
    this.configureDefaultCommand();
    this.configureButtonBindings();
  }

  private void configureAutonomous() {
    this.chooser.setDefaultOption("Simple Auto", 
      new InnerGoal(this.drivetrain, this.buffer, this.shooter)
    );

    Shuffleboard.getTab("Autonomous").add(this.chooser);
  }

  private void configureButtonBindings() {
    this.configureButtonBindingsIntake();
    this.configureButtonBindingsShooter();
    this.configureButtonBindingsBuffer();
  }

  private void configureButtonBindingsIntake() {
    var buttonBumperLeft = new JoystickButton(this.operator, Button.kBumperLeft.value);

    buttonBumperLeft
      .whileHeld(new CollectPowerCell(this.intake))
      .whenReleased(new StopIntake(this.intake));
  }

  public void configureButtonBindingsShooter() {
    var buttonBumperRight = new JoystickButton(this.operator, Button.kBumperRight.value);

    buttonBumperRight
      .whileHeld(new PushPowerCell(this.shooter))
      .whenReleased(new StopShooter(this.shooter));
  }

  public void configureButtonBindingsBuffer() {
    var buttonY = new JoystickButton(this.operator, Button.kY.value);
    var buttonA = new JoystickButton(this.operator, Button.kA.value);

    buttonY
      .whileHeld(new Feed(this.buffer))
      .whenReleased(new StopBuffer(this.buffer));

    buttonA
      .whileHeld(new Rollback(this.buffer))
      .whenReleased(new StopBuffer(this.buffer));
  }

  private void configureDefaultCommand() {
    this.drivetrain.setDefaultCommand(
      new ArcadeDrive(
        this.drivetrain, 
        () -> this.driver.getY(Hand.kLeft), 
        () -> this.driver.getX(Hand.kRight)
      )
    );
  }

  public Command getAutonomousCommand() {
    return this.chooser.getSelected();
  }
}
