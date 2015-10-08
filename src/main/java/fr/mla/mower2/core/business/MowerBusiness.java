package fr.mla.mower2.core.business;

import fr.mla.mower2.core.util.exception.ConfigurationException;

import java.util.List;

public interface MowerBusiness {

    List<String> mowItNow(String[] instructions) throws ConfigurationException;
}
