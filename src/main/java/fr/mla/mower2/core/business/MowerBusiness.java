package fr.mla.mower2.core.business;

import fr.mla.mower2.core.util.exception.ConfigurationException;

public interface MowerBusiness {

    String processInstructions(String instructions) throws ConfigurationException;
}
