package fr.mla.mower2.web.controller.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MowItNowResponseDto implements Serializable {

    private List<MowerResponseDto> response = new ArrayList<>();
    private String errorMessage;

    public MowItNowResponseDto() {
    }

    public void serialize(List<String> mowItResponse) {

        int id = 1;
        for (String mowerResponse : mowItResponse) {
            response.add(new MowerResponseDto(id++, mowerResponse));
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return (errorMessage != null ? errorMessage : response.toString());

    }
}


// Encapsulate each mower response with a unique id to garantie uniqueness
// and avoid a [ngRepeat/dupe] issue at front end
class MowerResponseDto implements Serializable {

    int id;
    String response;

    public MowerResponseDto(int id, String response) {
        this.id = id;
        this.response = response;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", id, response);
    }
}