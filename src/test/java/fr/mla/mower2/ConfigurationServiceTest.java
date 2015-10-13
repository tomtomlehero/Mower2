package fr.mla.mower2;

import fr.mla.mower2.business.service.ConfigurationService;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.util.FileUtil;
import fr.mla.mower2.core.util.OrientationEnum;
import fr.mla.mower2.core.util.exception.ConfigurationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

@Component
public class ConfigurationServiceTest {

    ConfigurationService configurationService;

    private static final String RESOURCE_PATH = "src/test/resources/";

    private static final String BASIC = RESOURCE_PATH + "basic.txt";
    private static final String FAILING_GARDEN_INITIALIZATION = RESOURCE_PATH + "failing_garden_initialization.txt";
    private static final String FAILING_MOWER_INITIAL_POSITION = RESOURCE_PATH + "failing_mower_initial_position.txt";
    private static final String FAILING_MOWER_INSTRUCTIONS = RESOURCE_PATH + "failing_mower_instructions.txt";
    private static final String FAILING_MOWER_OUT_OF_GARDEN = RESOURCE_PATH + "failing_mower_out_of_garden.txt";


    @BeforeClass
    private void testInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
        configurationService = context.getBean(ConfigurationService.class);
    }

    @Test
    public void acceptBasicConfig() {

        List<String> instructions = null;

        try {
            instructions = FileUtil.instructionsFromFile(BASIC);
        } catch (IOException e) {
            fail("IOException", e);
        }

        MowItNowConfiguration configuration = null;

        try {
            configuration = configurationService.configure(instructions);
        } catch (ConfigurationException e) {
            fail("Basic config should pass", e);
        }

        assertNotNull(configuration);

        assertEquals(configuration.getMaxX(), 5);
        assertEquals(configuration.getMaxY(), 5);

        assertNotNull(configuration.getMowerConfigurations());

        assertEquals(configuration.getMowerConfigurations().size(), 2);

        MowerConfiguration mowerConfiguration1 = configuration.getMowerConfigurations().removeFirst();
        assertEquals(mowerConfiguration1.getMowerNum(), 1);
        assertEquals(mowerConfiguration1.getStartX(), 1);
        assertEquals(mowerConfiguration1.getStartY(), 2);
        assertEquals(mowerConfiguration1.getStartO(), OrientationEnum.N);
        assertEquals(mowerConfiguration1.getInstructions().size(), 9);

        MowerConfiguration mowerConfiguration2 = configuration.getMowerConfigurations().removeFirst();
        assertEquals(mowerConfiguration2.getMowerNum(), 2);
        assertEquals(mowerConfiguration2.getStartX(), 3);
        assertEquals(mowerConfiguration2.getStartY(), 3);
        assertEquals(mowerConfiguration2.getStartO(), OrientationEnum.E);
        assertEquals(mowerConfiguration2.getInstructions().size(), 10);

    }

    @Test
    public void acceptFailOnGardenInitialization() {
        try {
            List<String> instructions = FileUtil.instructionsFromFile(FAILING_GARDEN_INITIALIZATION);
            expectThrows(ConfigurationException.class, () -> configurationService.configure(instructions));
        } catch (IOException e) {
            fail("IOException", e);
        }
    }

    @Test
    public void acceptFailOnMowerInitialPosition() {
        try {
            List<String> instructions = FileUtil.instructionsFromFile(FAILING_MOWER_INITIAL_POSITION);
            expectThrows(ConfigurationException.class, () -> configurationService.configure(instructions));
        } catch (IOException e) {
            fail("IOException", e);
        }
    }

    @Test
    public void acceptFailOnMowerInstructions() {
        try {
            List<String> instructions = FileUtil.instructionsFromFile(FAILING_MOWER_INSTRUCTIONS);
            expectThrows(ConfigurationException.class, () -> configurationService.configure(instructions));
        } catch (IOException e) {
            fail("IOException", e);
        }
    }

    @Test
    public void acceptFailOnMowerOutOfGarden() {
        try {
            List<String> instructions = FileUtil.instructionsFromFile(FAILING_MOWER_OUT_OF_GARDEN);
            expectThrows(ConfigurationException.class, () -> configurationService.configure(instructions));
        } catch (IOException e) {
            fail("IOException", e);
        }
    }

}
