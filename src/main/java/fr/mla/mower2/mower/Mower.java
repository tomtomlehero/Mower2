package fr.mla.mower2.mower;

import fr.mla.mower2.mower.behavior.IMowerBehavior;

public abstract class Mower {

    private IMowerBehavior mowerBehavior;

    public void setMowerBehavior(IMowerBehavior mowerBehavior) {
        this.mowerBehavior = mowerBehavior;
    }


    public void performMow() {
        mowerBehavior.mow();
    }


}
