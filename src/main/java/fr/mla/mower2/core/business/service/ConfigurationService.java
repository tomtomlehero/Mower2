package fr.mla.mower2.core.business.service;


import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.util.InstructionEnum;
import fr.mla.mower2.core.util.OrientationEnum;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConfigurationService {

    private static final String LINE_SEPARATOR = "\n";

    // 1 ore more digits followed by a space followed by one ore more digits followed by any (unused) whitespaces
    private static Pattern firstLinePattern = Pattern.compile("^\\d+ \\d+\\s*$");
    // 1 ore more digits followed by a space followed by one ore more digits followed by N|E|W|S followed by any (unused) whitespaces
    private static Pattern mowerInitializationPattern = Pattern.compile("^\\d+ \\d+ [NEWS]\\s*$");
    // Any D|G|A followed by any (unused) whitespaces
    private static Pattern mowerInstructionsPattern = Pattern.compile("^[DGA]*\\s*$");

    private static Pattern digitFinderPattern = Pattern.compile("\\d+");
    private static Pattern orientationFinderPattern = Pattern.compile("[NEWS]");
    private static Pattern dgaFinderPattern = Pattern.compile("[DGA]");


    public MowItNowConfiguration configure(String instructions) throws ConfigurationException {
        String instrucionLines[] = extractInstructions(instructions);
        return processInstructions(instrucionLines);
    }


    private String[] extractInstructions(String instructions) {
        return instructions.split(LINE_SEPARATOR);
    }


    private MowItNowConfiguration processInstructions(String[] lines) throws ConfigurationException {

        // Line #1
        String firstLine = lines[0];
        Matcher firstLineMatcher = firstLinePattern.matcher(firstLine);

        if (!firstLineMatcher.matches()) {
            throw new ConfigurationException("1st line must contain 2 integers separated by a space");
        }

        Matcher digitFinderMatcher = digitFinderPattern.matcher(firstLine);

        digitFinderMatcher.find();
        int maxX = Integer.valueOf(digitFinderMatcher.group());
        digitFinderMatcher.find();
        int maxY = Integer.valueOf(digitFinderMatcher.group());

        MowItNowConfiguration mowItNowConfiguration = new MowItNowConfiguration(maxX, maxY);

        int mowerNum = 0;
        for (int i = 1; i < lines.length; i++) {

            mowerNum++;

            // -- Mower Initialisation Line --
            // Validation
            String mowerInitialisationLine = lines[i++];

            Matcher mowerInitialisationMatcher = mowerInitializationPattern.matcher(mowerInitialisationLine);

            if (!mowerInitialisationMatcher.matches()) {
                throw new ConfigurationException(String.format("Mower #%d : Initialisation line must contain 2 integers ans an orientaion (NEWS) separated by a space", mowerNum));
            }

            // Parsing
            Matcher digitMatcher = digitFinderPattern.matcher(mowerInitialisationLine);

            digitMatcher.find();
            int startX = Integer.valueOf(digitMatcher.group());
            digitMatcher.find();
            int startY = Integer.valueOf(digitMatcher.group());

            Matcher orientationMatcher = orientationFinderPattern.matcher(mowerInitialisationLine);

            orientationMatcher.find();
            OrientationEnum startOrientation = OrientationEnum.valueOf(orientationMatcher.group());

            MowerConfiguration mowerConfig = new MowerConfiguration(mowerNum, startX, startY, startOrientation);


            // Mower Instructions Line
            if (i >= lines.length) {
                throw new ConfigurationException(String.format("Mower #%d has nothing to do...", mowerNum));
            }

            String mowerInstructionsLine = lines[i];

            Matcher mowerInstructionsMatcher = mowerInstructionsPattern.matcher(mowerInstructionsLine);

            if (!mowerInstructionsMatcher.matches()) {
                throw new ConfigurationException(String.format("Mower #%d : Instructions line must contain DGAs...", mowerNum));
            }


            Matcher dgaMatcher = dgaFinderPattern.matcher(mowerInstructionsLine);


            while (dgaMatcher.find()) {
                mowerConfig.pushInstruction(InstructionEnum.valueOf(dgaMatcher.group()));
            }

            mowItNowConfiguration.addMowerConfiguration(mowerConfig);

        }

        return mowItNowConfiguration;

    }

}
