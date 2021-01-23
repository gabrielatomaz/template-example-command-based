package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class CollectPowerCell extends CommandBase {
    private Intake intake;

    public CollectPowerCell(Intake intake) {
        this.intake = intake;

        addRequirements(this.intake);
    }

    @Override
    public void execute() {
        this.intake.setSpeed(1);

        var isUp = false;
        this.intake.setValue(isUp);
    }
}
