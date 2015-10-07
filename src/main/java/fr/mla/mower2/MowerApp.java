package fr.mla.mower2;

import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import fr.mla.mower2.core.model.mower.Mower;
import fr.mla.mower2.core.strategy.mow.impl.DGAMowerStrategy;
import fr.mla.mower2.core.model.mower.impl.DGAMower;
import fr.mla.mower2.core.util.InstructionEnum;
import fr.mla.mower2.core.util.OrientationEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MowerApp {

    private static final String SEPARATOR = " ";

    public static void main(String[] args) {

        if (args.length < 1) {
            usage();
            System.exit(1);
        }

        MowItNowConfiguration config;

        try {
            config = configure(args[0]);
            System.out.println(config);
            System.out.println("### Config Ok ###");
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Erreur I/O");
            e.printStackTrace();
            System.exit(1);
        }

    }

    private static void usage() {
        System.out.println("USAGE:");
        System.out.println("\tMower2.sh <configurationFile>");
    }



    private static MowItNowConfiguration configure(String path) throws ConfigurationException, IOException {

        MowItNowConfiguration mowItNowConfiguration;

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {

            // Line 1 : Coordonnées N-E
            String line = in.readLine();

            if (line == null) {
                throw new ConfigurationException("Erreur pendant la configuration : impossible de lire la ligne 1");
            }

            int maxX;
            int maxY;

            String[] sCoord = line.split(SEPARATOR);
            try {
                maxX = Integer.valueOf(sCoord[0]);
                maxY = Integer.valueOf(sCoord[1]);

                mowItNowConfiguration = new MowItNowConfiguration(maxX, maxY);

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new ConfigurationException(
                        "Erreur pendant la configuration : la première ligne doit contenir deux entiers séparés par un espace");
            }

            // Lignes d'instructions tondeuses

            int mowerNum = 0;

            while ((line = in.readLine()) != null) {

                mowerNum++;

                int x1;
                int y1;
                OrientationEnum o1;

                MowerConfiguration mowerConfig;

                String[] sCoord1 = line.split(SEPARATOR);
                try {
                    x1 = Integer.valueOf(sCoord1[0]);
                    y1 = Integer.valueOf(sCoord1[1]);
                    o1 = OrientationEnum.valueOf(sCoord1[2]);

                    mowerConfig = new MowerConfiguration(mowerNum, x1, y1, o1);

                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                    throw new ConfigurationException(String.format(
                            "Erreur pendant la configuration : [tondeuse #%d/ligne #1] doit contenir deux entiers et une orientation séparés par un espace", mowerNum));
                }


                if ((line = in.readLine()) == null) {
                    throw new ConfigurationException(String.format("Erreur pendant la configuration : [tondeuse #%d] ligne d'instructions absente", mowerNum));
                }


                Pattern dgaPattern = Pattern.compile("[DGA]*");
                Matcher dgaMatcher = dgaPattern.matcher(line);
                if (!dgaMatcher.matches()) {
                    throw new ConfigurationException(String.format(
                            "Erreur pendant la configuration : [tondeuse #%d/ligne #2] doit contenir une liste d'instruction pour la tondeuse parmi 'D', 'G' et 'A'", mowerNum));
                }

                Pattern dga2Pattern = Pattern.compile("[DGA]");
                Matcher dga2Matcher = dga2Pattern.matcher(line);
                while (dga2Matcher.find()) {
                    mowerConfig.pushInstruction(InstructionEnum.valueOf(dga2Matcher.group()));
                }


                mowItNowConfiguration.addMowerConfiguration(mowerConfig);


            }


            return mowItNowConfiguration;




        } catch (FileNotFoundException e) {
            throw new ConfigurationException(String.format("Erreur pendant la configuration : impossible de trouver le fichier %s ", path), e);
        }


    }



}
