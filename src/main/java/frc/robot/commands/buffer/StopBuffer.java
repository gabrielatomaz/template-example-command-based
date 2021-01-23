package frc.robot.commands.buffer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Buffer;

public class StopBuffer extends CommandBase {
    private Buffer buffer;

    public StopBuffer(Buffer buffer) {
        this.buffer = buffer;

        addRequirements(this.buffer);
    }

    @Override
    public void execute() {
        this.buffer.setSpeed(0);
    }
}
