package fr.mla.mower2;


import java.util.ArrayList;
import java.util.List;

public class MowerClusterConfiguration {

    private int maxX;
    private int maxY;

    List<MowerConfiguration> mowerConfigurations = new ArrayList<>();

    public MowerClusterConfiguration(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void addMowerConfiguration(MowerConfiguration mowerConfiguration) {
        mowerConfigurations.add(mowerConfiguration);
    }

    @Override
    public String toString() {
        return "MowerClusterConfiguration{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                ", mowerConfigurations=" + mowerConfigurations +
                '}';
    }
}
