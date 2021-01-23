package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.buffer.Feed;
import frc.robot.commands.drivetrain.DriveStraight;
import frc.robot.commands.shooter.PushPowerCell;
import frc.robot.subsystems.Buffer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class InnerGoal extends SequentialCommandGroup {
    public InnerGoal(Drivetrain drivetrain, Buffer buffer, Shooter shooter) {
        new SequentialCommandGroup(
            new DriveStraight(drivetrain, 5),
            new ParallelCommandGroup(
                new PushPowerCell(shooter),
                new Feed(buffer)
            )
        );
    }
}
