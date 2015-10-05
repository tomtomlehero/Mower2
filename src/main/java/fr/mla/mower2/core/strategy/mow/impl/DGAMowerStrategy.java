package fr.mla.mower2.core.strategy.mow.impl;


import fr.mla.mower2.core.model.mower.Mower;
import fr.mla.mower2.core.strategy.mow.MowStrategy;
import fr.mla.mower2.core.util.OrientationEnum;

public class DGAMowerStrategy implements MowStrategy {


    Mower mower;

    public DGAMowerStrategy(Mower mower) {
        this.mower = mower;
    }

    @Override
    public void turnRight() {

        switch (mower.getOrientation()) {
            case N:
                mower.setOrientation(OrientationEnum.E);
                break;
            case E:
                mower.setOrientation(OrientationEnum.S);
                break;
            case S:
                mower.setOrientation(OrientationEnum.W);
                break;
            case W:
                mower.setOrientation(OrientationEnum.N);
                break;
        }
    }

    @Override
    public void turnLeft() {

        switch (mower.getOrientation()) {
            case N:
                mower.setOrientation(OrientationEnum.W);
                break;
            case E:
                mower.setOrientation(OrientationEnum.N);
                break;
            case S:
                mower.setOrientation(OrientationEnum.E);
                break;
            case W:
                mower.setOrientation(OrientationEnum.S);
                break;
        }
    }

    @Override
    public void oneStepForward() {

        int x = mower.getX();
        int y = mower.getY();

        switch (mower.getOrientation()) {
            case N:
                mower.setY(Math.min(y + 1, mower.getyMax()));
                break;
            case E:
                mower.setX(Math.min(x + 1, mower.getxMax()));
                break;
            case S:
                mower.setY(Math.max(y - 1, 0));
                break;
            case W:
                mower.setX(Math.min(x - 1, 0));
                break;
        }


    }

    @Override
    public void flyTenStepsForward() {
        // No way...
    }
}
