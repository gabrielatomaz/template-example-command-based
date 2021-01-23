package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class StopShooter extends CommandBase {
    private Shooter shooter;

    public StopShooter(Shooter shooter) {
        this.shooter = shooter;

        addRequirements(this.shooter);
    }

    @Override
    public void execute() {
        this.shooter.setSpeed(0);
    }
}
