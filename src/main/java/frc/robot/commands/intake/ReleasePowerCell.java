package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ReleasePowerCell extends CommandBase {
    private Intake intake;

    public ReleasePowerCell(Intake intake) {
        this.intake = intake;

        addRequirements(this.intake);
    }

    @Override
    public void execute() {
        this.intake.setSpeed(-1);

        var isUp = false;
        this.intake.setValue(isUp);
    }
}
