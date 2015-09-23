package fr.mla.mower2;


import fr.mla.mower2.util.Instruction;
import fr.mla.mower2.util.OrientationEnum;

import java.util.ArrayList;
import java.util.List;

public class MowerConfiguration {

    int startX;
    int startY;
    OrientationEnum startO;

    List<Instruction> instructions = new ArrayList<>();

    public MowerConfiguration(int startX, int startY, OrientationEnum startO) {
        this.startX = startX;
        this.startY = startY;
        this.startO = startO;
    }

    public void pushInstruction(Instruction instruction) {
        instructions.add(instruction);
    }


    @Override
    public String toString() {
        return "MowerConfiguration{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", startO=" + startO +
                ", instructions=" + instructions +
                '}';
    }
}
