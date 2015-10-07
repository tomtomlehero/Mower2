package fr.mla.mower2.core.command.imp;

import fr.mla.mower2.core.command.Command;

public class GCommand extends Command {

    @Override
    public void execute() {
        mower.performTurnLeft();
    }

}
