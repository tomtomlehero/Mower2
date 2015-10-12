package fr.mla.mower2.business.service;


import fr.mla.mower2.core.interpreter.Parser;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {


    public MowItNowConfiguration configure(List<String> instructions) throws ConfigurationException {

        Parser parser = new Parser(instructions);
        return parser.evaluate();
    }

}
