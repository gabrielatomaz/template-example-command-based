package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveStraight extends CommandBase {
    private Drivetrain drivetrain;
    private double seconds;
    private Timer timer;

    public DriveStraight(Drivetrain drivetrain, double seconds) {
        this.drivetrain = drivetrain;
        this.seconds = seconds;

        this.timer = new Timer();

        addRequirements(this.drivetrain);
    }

    @Override
    public void initialize() {
        this.timer.reset();
        this.timer.start();
    }

    @Override
    public void execute() {
        this.drivetrain.arcadeDrive(0.5, 0);
    }
    
    @Override
    public void end(boolean interrupted) {
        this.drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return this.timer.get() >= this.seconds;
    }
}
