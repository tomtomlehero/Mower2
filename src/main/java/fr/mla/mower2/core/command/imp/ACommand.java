package fr.mla.mower2.core.command.imp;

import fr.mla.mower2.core.command.Command;

public class ACommand extends Command {

    @Override
    public void execute() {
        mower.performOneStepForward();
    }

}
