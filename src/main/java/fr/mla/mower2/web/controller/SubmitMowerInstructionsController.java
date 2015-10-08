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

    private static final String LINE_SEPARATOR = "\n";


    @Autowired
    private MowerBusiness mowerBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public MowItNowResponseDto submitMowerInstructions(@RequestBody MowItNowInstructionsDto instructions) {

        MowItNowResponseDto response = new MowItNowResponseDto();
        try {
            List<String> mowItResponse = mowerBusiness.mowItNow(instructions.getInstructions().split((LINE_SEPARATOR)));
            response.serialize(mowItResponse);
        } catch (ConfigurationException e) {
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }

}
