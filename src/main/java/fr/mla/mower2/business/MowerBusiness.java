package fr.mla.mower2.business;

import fr.mla.mower2.core.util.exception.ConfigurationException;

import java.util.List;

public interface MowerBusiness {

    List<String> mowItNow(List<String> instructions) throws ConfigurationException;
}
