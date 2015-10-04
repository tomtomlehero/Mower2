package fr.mla.mower2.controller;

import fr.mla.mower2.controller.dto.MowerInstructionsDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submitInstructions")
public class SubmitMowerInstructionsController {

//    @Autowired
//    TODO : Inject MowItStrategy

    @RequestMapping(method = RequestMethod.POST)
    public MowerInstructionsDto submitMowerInstructions(@RequestBody MowerInstructionsDto instructions) {
        System.out.println("###### " + instructions.getInstructions());
        instructions.setResponse("You said : " + instructions.getInstructions() + " BRAVO !!!");

        return instructions;
    }

}
