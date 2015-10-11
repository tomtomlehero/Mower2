package fr.mla.mower2;

import fr.mla.mower2.business.MowerBusiness;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MowerApp {

    private static Logger log = LoggerFactory.getLogger(MowerApp.class);

    @Autowired
    private MowerBusiness mowerBusiness;


    public static void main(String[] args) {

        if (args.length < 1) {
            usage();
            System.exit(1);
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
        MowerApp app = context.getBean(MowerApp.class);

        app.start(args[0]);
    }


    public void start(String filePath) {

        try {
            mowItNow(filePath).forEach(System.out::println);
        } catch (ConfigurationException e) {
            log.error(e.getMessage());
        } catch (FileNotFoundException e) {
            log.error("Erreur : le fichier {} n'existe pas", filePath);
        } catch (IOException e) {
            log.error(String.format("Erreur I/O: %s", e.getMessage()), e);
        }
    }


    private List <String> mowItNow(String filePath) throws ConfigurationException, IOException {
        String[] instructions = instructionsFromFile(filePath);
        return mowerBusiness.mowItNow(instructions);
    }

    private String[] instructionsFromFile(String filePath) throws IOException {

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {

            String line;
            List<String> lines = new ArrayList<>();

            while ((line = in.readLine()) != null) {
                lines.add(line);
            }

            String result[] = new String[lines.size()];

            int i = 0;
            for (String line2 : lines) {
                result[i++] = line2;
            }

            return result;
        }
    }


    private static void usage() {
        log.warn("USAGE:");
        log.warn("\tMower2.sh <configurationFile>");
    }

}
