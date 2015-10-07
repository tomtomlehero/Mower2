package fr.mla.mower2.web.controller.dto;


import java.io.Serializable;
import java.util.List;

public class MowerResponseDto implements Serializable {

    private List<String> response;
    private String errorMessage;

    public MowerResponseDto() {
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
