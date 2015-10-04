package fr.mla.mower2.controller;

import fr.mla.mower2.controller.dto.MowerInstructionsDto;
import fr.mla.mower2.controller.dto.MowerResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submitInstructions")
public class SubmitMowerInstructionsController {

//    @Autowired
//    TODO : Inject MowItStrategy

    @RequestMapping(method = RequestMethod.POST)
    public MowerResponseDto submitMowerInstructions(@RequestBody MowerInstructionsDto instructions) {
        System.out.println("###### " + instructions.getInstructions());

        MowerResponseDto response = new MowerResponseDto();

        if (instructions.getInstructions().startsWith("GONTRAN")) {
            response.setErrorMessage("Hey instructions can't start with GONTRAN !!!!");
        } else {
            response.setResponse("You said : " + instructions.getInstructions() + " !!!!!!! BRAVO !!!");
        }

        return response;
    }

}
