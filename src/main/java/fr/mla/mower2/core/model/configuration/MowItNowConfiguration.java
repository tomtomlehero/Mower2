package fr.mla.mower2.core.model.configuration;


import java.util.ArrayList;
import java.util.List;

public class MowItNowConfiguration {

    private int maxX;
    private int maxY;

    List<MowerConfiguration> mowerConfigurations = new ArrayList<>();

    public MowItNowConfiguration(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void addMowerConfiguration(MowerConfiguration mowerConfiguration) {
        mowerConfigurations.add(mowerConfiguration);
    }

    @Override
    public String toString() {
        return "MowLawnConfiguration{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                ", mowerConfigurations=" + mowerConfigurations +
                '}';
    }
}
