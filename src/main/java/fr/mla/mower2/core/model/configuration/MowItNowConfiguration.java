package fr.mla.mower2.core.model.configuration;

import fr.mla.mower2.core.util.InstructionEnum;

import java.util.*;

public class MowItNowConfiguration {

    private int maxX;
    private int maxY;

    Deque<MowerConfiguration> mowerConfigurations = new ArrayDeque<>();


    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void addMowerConfiguration(MowerConfiguration mowerConfiguration) {
        mowerConfigurations.add(mowerConfiguration);
    }

    public Deque<MowerConfiguration> getMowerConfigurations() {
        return mowerConfigurations;
    }


    public void addInstructionToCurrentMower(InstructionEnum instruction) {
        mowerConfigurations.getLast().pushInstruction(instruction);
    }

    @Override
    public String toString() {
        return "MowItNowConfiguration{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                ", mowerConfigurations=" + mowerConfigurations +
                '}';
    }
}
