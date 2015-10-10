package fr.mla.mower2.web.controller.dto;


import java.io.Serializable;

public class MowItNowInstructionsDto implements Serializable {

    private String instructions;

    public MowItNowInstructionsDto() {
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return instructions;
    }
}
