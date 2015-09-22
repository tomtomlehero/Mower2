package fr.mla.mower2;

import fr.mla.mower2.exception.ConfigurationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String SEPARATOR = " ";


    enum Orientation {
        N, W, E, S
    }

    enum Instruction {
        D, G, A
    }


	public static void main(String[] args) {


        if (args.length < 1) {
            usage();
            System.exit(1);
        }

        try {
            configure(args[0]);
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Erreur I/O");
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("### Config Ok ###");




    }

    private static void usage() {
        System.out.println("USAGE:");
        System.out.println("\tMower2.sh <configurationFile>");
    }




    private static void configure(String path) throws ConfigurationException, IOException {

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {

            // Line 1 : Coordonnées N-E
            String line = in.readLine();

            if (line == null) {
                throw new ConfigurationException("Erreur pendant la configuration : impossible de lire la ligne 1");
            }

            int x;
            int y;

            String[] sCoord = line.split(SEPARATOR);
            try {
                x = Integer.valueOf(sCoord[0]);
                y = Integer.valueOf(sCoord[1]);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new ConfigurationException(
                        "Erreur pendant la configuration : la première ligne doit contenir deux entiers séparés par un espace");
            }

            System.out.println(String.format("Coordonnées : %d %d", x, y));


            // Lignes d'instructions tondeuses

            int mowerCount = 0;

            while ((line = in.readLine()) != null) {

                mowerCount++;

                int x1;
                int y1;
                Orientation o1;

                MowerConfiguration mowerConfiguration;

                String[] sCoord1 = line.split(SEPARATOR);
                try {
                    x1 = Integer.valueOf(sCoord1[0]);
                    y1 = Integer.valueOf(sCoord1[1]);
                    o1 = Orientation.valueOf(sCoord1[2]);

                    mowerConfiguration = new MowerConfiguration(x1, y1, o1);

                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                    throw new ConfigurationException(String.format(
                            "Erreur pendant la configuration : [tondeuse #%d/ligne #1] doit contenir deux entiers et une orientation séparés par un espace", mowerCount));
                }

                System.out.println(String.format("Départ tondeuse %d : %d %d %s", mowerCount, x1, y1, o1));

                if ((line = in.readLine()) == null) {
                    throw new ConfigurationException(String.format("Erreur pendant la configuration : [tondeuse #%d] ligne d'instructions absente", mowerCount));
                }


                Pattern dgaPattern = Pattern.compile("[DGA]*");
                Matcher dgaMatcher = dgaPattern.matcher(line);
                if (!dgaMatcher.matches()) {
                    throw new ConfigurationException(String.format(
                            "Erreur pendant la configuration : [tondeuse #%d/ligne #2] doit contenir une liste d'instruction pour la tondeuse parmi 'D', 'G' et 'A'", mowerCount));
                }

                System.out.println("---- " + line);

                Pattern dga2Pattern = Pattern.compile("[DGA]");
                Matcher dga2Matcher = dga2Pattern.matcher(line);
                while (dga2Matcher.find()) {
                    mowerConfiguration.pushInstruction(Instruction.valueOf(dga2Matcher.group()));
                }




            }






        } catch (FileNotFoundException e) {
            throw new ConfigurationException(String.format("Erreur pendant la configuration : impossible de trouver le fichier %s ", path), e);
        }


    }



}
