package fr.mla.mower2.core.interpreter;

import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;

public class Context {


    MowItNowConfiguration output;

    public MowItNowConfiguration getOutput() {
        return output;
    }

    public void setOutput(MowItNowConfiguration output) {
        this.output = output;
    }

}
