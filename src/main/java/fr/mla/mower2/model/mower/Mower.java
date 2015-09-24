package fr.mla.mower2.model.mower;

import fr.mla.mower2.strategy.mow.IMowBehavior;

public abstract class Mower {

    private IMowBehavior mowBehavior;

    public void setMowBehavior(IMowBehavior mowBehavior) {
        this.mowBehavior = mowBehavior;
    }


    public void performMow() {
        mowBehavior.mow();
    }


}
