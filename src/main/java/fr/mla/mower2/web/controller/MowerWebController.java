package fr.mla.mower2.web.controller;

import fr.mla.mower2.business.MowerBusiness;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import fr.mla.mower2.web.controller.dto.MowItNowInstructionsDto;
import fr.mla.mower2.web.controller.dto.MowItNowResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/submitInstructions")
public class MowerWebController {

    private static Logger log = LoggerFactory.getLogger(MowerWebController.class);

    private static final String LINE_SEPARATOR = "\n";


    @Autowired
    private MowerBusiness mowerBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public MowItNowResponseDto submitMowerInstructions(@RequestBody MowItNowInstructionsDto instructions) {

        log.trace("Request: \n{}", instructions);

        MowItNowResponseDto response = new MowItNowResponseDto();
        try {

            String x[] = instructions.getInstructions().split(LINE_SEPARATOR);
            List<String> y = new ArrayList<>();

            for (String z : x) {
                y.add(z);
            }

            List<String> mowItResponse = mowerBusiness.mowItNow(y);

//            List<String> mowItResponse = mowerBusiness.mowItNow(
//                    Arrays.asList(instructions.getInstructions().split(LINE_SEPARATOR)));
            response.serialize(mowItResponse);
        } catch (ConfigurationException e) {
            response.setErrorMessage(e.getMessage());
        }

        log.trace("Response: \n{}", response);

        return response;
    }

}
