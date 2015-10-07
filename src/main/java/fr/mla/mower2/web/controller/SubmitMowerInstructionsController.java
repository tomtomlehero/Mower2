package fr.mla.mower2.web.controller;

import fr.mla.mower2.core.business.MowerBusiness;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import fr.mla.mower2.web.controller.dto.MowerInstructionsDto;
import fr.mla.mower2.web.controller.dto.MowerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submitInstructions")
public class SubmitMowerInstructionsController {

    @Autowired
    private MowerBusiness mowerBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public MowerResponseDto submitMowerInstructions(@RequestBody MowerInstructionsDto instructions) {

        System.out.println("----------- Instructions received -----------------");
        System.out.println(instructions.getInstructions());

        MowerResponseDto response = new MowerResponseDto();
        try {
            List<String> mowerResponse = mowerBusiness.mowItNow(instructions.getInstructions());
            response.setResponse(mowerResponse);
        } catch (ConfigurationException e) {
            response.setErrorMessage(e.getMessage());
        }

        System.out.println("----------------------------------------------------");

        return response;
    }

}
