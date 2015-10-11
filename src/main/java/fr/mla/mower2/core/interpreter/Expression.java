package fr.mla.mower2.core.interpreter;

import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.util.InstructionEnum;
import fr.mla.mower2.core.util.OrientationEnum;
import fr.mla.mower2.core.util.exception.ConfigurationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Expression {

    // 1 ore more digits followed by a space followed by one ore more digits followed by any (unused) whitespaces
    // (for GardenInitializationExpression validation)
    protected static Pattern firstLinePattern = Pattern.compile("^\\d+ \\d+\\s*$");

    // 1 ore more digits followed by a space followed by one ore more digits followed by N|E|W|S followed by any (unused) whitespaces
    // (for MowerInitialPositionExpression validation)
    protected static Pattern mowerInitializationPattern = Pattern.compile("^\\d+ \\d+ [NEWS]\\s*$");

    // Any number of characters D|G|A
    // (for MowerInstructionsExpression validation)
    protected static Pattern mowerInstructionsPattern = Pattern.compile("^[DGA]*\\s*$");

    // 1 positive integer
    protected static Pattern integerFinderPattern = Pattern.compile("\\d+");

    // 1 character N|E|W|S
    protected static Pattern orientationFinderPattern = Pattern.compile("[NEWS]");

    // 1 character D|G|A
    protected static Pattern instructionFinderPattern = Pattern.compile("[DGA]");



    // The line beeing interpreted e.g: "50 50", "0 0 N" or "AAADAAADAAAGAAA"
    protected String line;

    public void interpret(Context context) throws ConfigurationException {
        validate();
        select(context);
    }

    public abstract void validate() throws ConfigurationException;

    public abstract void select(Context context) throws ConfigurationException;

}


class GardenInitializationExpression extends Expression {


    public GardenInitializationExpression(String line) {
        this.line = line;
    }

    @Override
    public void validate() throws ConfigurationException {

        Matcher firstLineMatcher = firstLinePattern.matcher(this.line);

        if (!firstLineMatcher.matches()) {
            throw new ConfigurationException("1st line must contain 2 positive integers separated by a space");
        }
    }

    @Override
    public void select(Context context) {

        Matcher digitFinderMatcher = integerFinderPattern.matcher(this.line);

        digitFinderMatcher.find();
        int maxX = Integer.valueOf(digitFinderMatcher.group());
        digitFinderMatcher.find();
        int maxY = Integer.valueOf(digitFinderMatcher.group());

        context.setOutput(new MowItNowConfiguration());
        context.getOutput().setMaxX(maxX);
        context.getOutput().setMaxY(maxY);

    }
}


class MowerInitialPositionExpression extends Expression {

    // The mower currently configured
    private int mowerNum;


    public MowerInitialPositionExpression(String line, int mowerNum) {
        this.line = line;
        this.mowerNum = mowerNum;
    }

    @Override
    public void validate() throws ConfigurationException {

        Matcher mowerInitialisationMatcher = mowerInitializationPattern.matcher(this.line);

        if (!mowerInitialisationMatcher.matches()) {
            throw new ConfigurationException(String.format(
                    "Mower #%d : Initialisation line must contain 2 positive integers and an orientation (N E W or S) separated by a space",
                    mowerNum));
        }

    }

    @Override
    public void select(Context context) throws ConfigurationException {

        Matcher digitMatcher = integerFinderPattern.matcher(this.line);

        digitMatcher.find();
        int startX = Integer.valueOf(digitMatcher.group());
        digitMatcher.find();
        int startY = Integer.valueOf(digitMatcher.group());

        if ((startX > context.getOutput().getMaxX()) || (startY > context.getOutput().getMaxY())) {
            throw new ConfigurationException(String.format("Oooops!! Mower #%d can't start from outside of the garden", mowerNum));
        }

        Matcher orientationMatcher = orientationFinderPattern.matcher(line);

        orientationMatcher.find();
        OrientationEnum startOrientation = OrientationEnum.valueOf(orientationMatcher.group());

        MowerConfiguration mowerConfig = new MowerConfiguration(mowerNum, startX, startY, startOrientation);

        context.getOutput().addMowerConfiguration(mowerConfig);


    }
}

class MowerInstructionsExpression extends Expression {

    // The mower currently configured
    private int mowerNum;

    public MowerInstructionsExpression(String line, int mowerNum) {
        this.line = line;
        this.mowerNum = mowerNum;
    }

    @Override
    public void validate() throws ConfigurationException {


        Matcher mowerInstructionsMatcher = mowerInstructionsPattern.matcher(this.line);

        if (!mowerInstructionsMatcher.matches()) {
            throw new ConfigurationException(String.format("Mower #%d : Instructions line must contain DGAs...", mowerNum));
        }


    }

    @Override
    public void select(Context context) {

        Matcher dgaMatcher = instructionFinderPattern.matcher(this.line);

        while (dgaMatcher.find()) {
            context.getOutput().addInstructionToCurrentMower(InstructionEnum.valueOf(dgaMatcher.group()));
        }


    }
}

