package fr.mla.mower2.core.business.impl;

import fr.mla.mower2.core.business.MowerBusiness;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MowerBusinessImpl implements MowerBusiness {


    private static final String LINE_SEPARATOR = "\n";

    // 1 ore more digits followed by a space followed by one ore more digits followed by any (unused) whitespaces
    private static Pattern firstLinePattern = Pattern.compile("^\\d+ \\d+\\s*$");
    // 1 ore more digits followed by a space followed by one ore more digits followed by N|E|W|S followed by any (unused) whitespaces
    private static Pattern mowerInitializationPattern = Pattern.compile("^\\d+ \\d+ [NEWS]\\s*$");
    // Any D|G|A followed by any (unused) whitespaces
    private static Pattern mowerInstructionsPattern = Pattern.compile("^[DGA]*\\s*$");

    private static Pattern digitFinderPattern = Pattern.compile("\\d+");
    private static Pattern dgaFinderPattern = Pattern.compile("[DGA]");

    @Override
    public String processInstructions(String instructions) throws ConfigurationException {
        String instrucionLines[] = extractInstructions(instructions);
        return processInstructions(instrucionLines);
    }


    private String[] extractInstructions(String instructions) {
        return instructions.split(LINE_SEPARATOR);
    }


    private String processInstructions(String[] lines) throws ConfigurationException {


        // Line #1
        String firstLine = lines[0];
        System.out.println("<" + firstLine + ">");
        Matcher firstLineMatcher = firstLinePattern.matcher(firstLine);

        if (!firstLineMatcher.matches()) {
            throw new ConfigurationException("1st line must contain 2 integers separated by a space");
        }

        Matcher digitFinderMatcher = digitFinderPattern.matcher(firstLine);

        digitFinderMatcher.find();
        int maxX = Integer.valueOf(digitFinderMatcher.group());
        digitFinderMatcher.find();
        int maxY = Integer.valueOf(digitFinderMatcher.group());

        int mowerCount = 0;
        for (int i = 1; i < lines.length; i++) {

            mowerCount++;

            // Mower Initialisation Line
            String mowerInitialisationLine = lines[i++];

            Matcher mowerInitialisationMatcher = mowerInitializationPattern.matcher(mowerInitialisationLine);

            if (!mowerInitialisationMatcher.matches()) {
                throw new ConfigurationException(String.format("Mower #%d : Initialisation line must contain 2 integers ans an orientaion (NEWS) separated by a space", mowerCount));
            }

            // Mower Instructions Line
            String mowerInstructionsLine;
            try {
                mowerInstructionsLine = lines[i];
            } catch (IndexOutOfBoundsException e) {
                throw new ConfigurationException(String.format("Mower #%d has nothinf to do...", mowerCount));
            }

            Matcher mowerInstructionsMatcher = mowerInstructionsPattern.matcher(mowerInstructionsLine);

            if (!mowerInstructionsMatcher.matches()) {
                throw new ConfigurationException(String.format("Mower #%d : Instructions line must contain DGAs...", mowerCount));
            }


        }


        return "Config Ok " + maxX + " - " + maxY;

    }

}
