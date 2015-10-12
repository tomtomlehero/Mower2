package fr.mla.mower2.core.command;


import fr.mla.mower2.core.model.mower.Mower;

public abstract class Command {

    protected Mower mower;

    public abstract void execute();

    public void setMower(Mower mower) {
        this.mower = mower;
    }

}
