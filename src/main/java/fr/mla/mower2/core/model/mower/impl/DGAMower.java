package fr.mla.mower2.core.model.mower.impl;


import fr.mla.mower2.core.model.mower.Mower;
import fr.mla.mower2.core.strategy.mow.impl.DGAMowerStrategy;

public class DGAMower extends Mower {

    public DGAMower() {
        setMowStrategy(new DGAMowerStrategy(this));
    }
}
