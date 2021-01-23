package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class StopIntake extends CommandBase {
    private Intake intake;

    public StopIntake(Intake intake) {
        this.intake = intake;

        addRequirements(this.intake);
    }

    @Override
    public void execute() {
        this.intake.setSpeed(0);

        var isUp = true;
        this.intake.setValue(isUp);
    }
}
