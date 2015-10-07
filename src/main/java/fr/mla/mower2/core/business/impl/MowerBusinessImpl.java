package fr.mla.mower2.core.business.impl;

import fr.mla.mower2.core.business.MowerBusiness;
import fr.mla.mower2.core.business.service.ConfigurationService;
import fr.mla.mower2.core.business.service.MowItNowService;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MowerBusinessImpl implements MowerBusiness {

    @Autowired
    ConfigurationService configurationService;

    @Autowired
    MowItNowService mowItNowService;

    @Override
    public List<String> mowItNow(String instructions) throws ConfigurationException {

        MowItNowConfiguration configuration = configurationService.configure(instructions);
        return mowItNowService.mowIt(configuration);
    }

}
