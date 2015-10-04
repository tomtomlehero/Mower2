package fr.mla.mower2.controller.dto;


import java.io.Serializable;

public class MowerInstructionsDto implements Serializable {

    private String instructions;
    private String response;

    public MowerInstructionsDto() {
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
