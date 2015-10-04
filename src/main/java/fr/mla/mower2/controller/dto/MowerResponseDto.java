package fr.mla.mower2.controller.dto;


import java.io.Serializable;

public class MowerResponseDto implements Serializable {

    private String response;
    private String errorMessage;

    public MowerResponseDto() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
