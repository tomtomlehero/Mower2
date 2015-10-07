package fr.mla.mower2.core.business;

import fr.mla.mower2.core.util.exception.ConfigurationException;

public interface MowerBusiness {

    String mowItNow(String instructions) throws ConfigurationException;
}
