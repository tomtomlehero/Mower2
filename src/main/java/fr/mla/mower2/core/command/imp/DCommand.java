package fr.mla.mower2.core.command.imp;


import fr.mla.mower2.core.command.Command;
import fr.mla.mower2.core.model.mower.Mower;

public class DCommand implements Command {

    Mower mower;

    public DCommand(Mower mower) {
        this.mower = mower;
    }

    @Override
    public void execute() {
        mower.performTurnRight();
    }

}
