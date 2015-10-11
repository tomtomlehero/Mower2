package fr.mla.mower2.core.business.service;


import fr.mla.mower2.core.interpreter.Parser;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {


    public MowItNowConfiguration configure(String[] instructions) throws ConfigurationException {

        Parser parser = new Parser(instructions);
        return parser.evaluate();
    }

}
