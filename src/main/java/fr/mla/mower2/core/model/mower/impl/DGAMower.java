package fr.mla.mower2.core.model.mower.impl;

import fr.mla.mower2.core.model.mower.Mower;
import fr.mla.mower2.core.strategy.mow.impl.DGAMowerStrategy;
import fr.mla.mower2.core.util.OrientationEnum;

public class DGAMower extends Mower {

    public DGAMower(int xMax, int yMax, int x, int y, OrientationEnum orientation) {
        super(xMax, yMax, x, y, orientation);
        setMowStrategy(new DGAMowerStrategy(this));
    }
}
