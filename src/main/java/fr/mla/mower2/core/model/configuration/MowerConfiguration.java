package fr.mla.mower2.core.model.configuration;


import fr.mla.mower2.core.util.InstructionEnum;
import fr.mla.mower2.core.util.OrientationEnum;

import java.util.ArrayList;
import java.util.List;

public class MowerConfiguration {

    private int mowerNum;

    private int startX;
    private int startY;
    private OrientationEnum startO;

    List<InstructionEnum> instructions = new ArrayList<>();

    public MowerConfiguration(int mowerNum, int startX, int startY, OrientationEnum startO) {
        this.mowerNum = mowerNum;
        this.startX = startX;
        this.startY = startY;
        this.startO = startO;
    }

    public void pushInstruction(InstructionEnum instruction) {
        instructions.add(instruction);
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public OrientationEnum getStartO() {
        return startO;
    }

    public List<InstructionEnum> getInstructions() {
        return instructions;
    }

    public int getMowerNum() {
        return mowerNum;
    }

    @Override
    public String toString() {
        return "MowerConfiguration{" +
                "mowerNum=" + mowerNum +
                ", startX=" + startX +
                ", startY=" + startY +
                ", startO=" + startO +
                ", instructions=" + instructions +
                '}';
    }

}
