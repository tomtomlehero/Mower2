package fr.mla.mower2.core.model.mower;

import fr.mla.mower2.core.strategy.mow.MowStrategy;
import fr.mla.mower2.core.util.OrientationEnum;

public abstract class Mower {

    private int xMax;
    private int yMax;

    private int x;
    private int y;

    private OrientationEnum orientation;

    private MowStrategy mowStrategy;

    public Mower(int xMax, int yMax, int x, int y, OrientationEnum orientation) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public void setMowStrategy(MowStrategy mowStrategy) {
        this.mowStrategy = mowStrategy;
    }


    public void performTurnRight() {
        mowStrategy.turnRight();
    }

    public void performTurnLeft() {
        mowStrategy.turnLeft();
    }

    public void performOneStepForward() {
        mowStrategy.oneStepForward();
    }


}
