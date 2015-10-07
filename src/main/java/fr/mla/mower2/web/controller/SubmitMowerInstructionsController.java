package fr.mla.mower2.web.controller;

import fr.mla.mower2.core.business.MowerBusiness;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import fr.mla.mower2.web.controller.dto.MowItNowInstructionsDto;
import fr.mla.mower2.web.controller.dto.MowItNowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submitInstructions")
public class SubmitMowerInstructionsController {

    @Autowired
    private MowerBusiness mowerBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public MowItNowResponseDto submitMowerInstructions(@RequestBody MowItNowInstructionsDto instructions) {

        System.out.println("----------- Instructions received -----------------");
//        System.out.println(instructions.getInstructions());

        MowItNowResponseDto response = new MowItNowResponseDto();
        try {
            List<String> mowItResponse = mowerBusiness.mowItNow(instructions.getInstructions());
            response.serialize(mowItResponse);
        } catch (ConfigurationException e) {
            response.setErrorMessage(e.getMessage());
        }

        System.out.println("----------------------------------------------------");

        return response;
    }

}
