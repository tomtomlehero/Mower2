package fr.mla.mower2.web.controller.dto;


import java.io.Serializable;

public class MowerInstructionsDto implements Serializable {

    private String instructions;

    public MowerInstructionsDto() {
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
