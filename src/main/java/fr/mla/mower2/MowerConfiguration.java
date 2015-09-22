package fr.mla.mower2;


import java.util.ArrayList;
import java.util.List;

public class MowerConfiguration {

    int startX;
    int startY;
    Application.Orientation startO;

    List<Application.Instruction> instructions = new ArrayList<>();

    public MowerConfiguration(int startX, int startY, Application.Orientation startO) {
        this.startX = startX;
        this.startY = startY;
        this.startO = startO;
    }

    public void pushInstruction(Application.Instruction instruction) {
        instructions.add(instruction);
    }




}
