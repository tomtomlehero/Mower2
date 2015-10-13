package fr.mla.mower2;

import fr.mla.mower2.business.service.MowItNowService;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.util.InstructionEnum;
import fr.mla.mower2.core.util.OrientationEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@Component
public class MowItNowServiceTest {

    MowItNowService mowItNowService;

    @BeforeClass
    private void testInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
        mowItNowService = context.getBean(MowItNowService.class);
    }

    @Test
    public void acceptBasiConfig() {

        MowItNowConfiguration mowItNowConfiguration = new MowItNowConfiguration();
        mowItNowConfiguration.setMaxX(5);
        mowItNowConfiguration.setMaxY(5);

        MowerConfiguration mowerConfiguration1 = new MowerConfiguration(1, 1, 2, OrientationEnum.N);
        mowItNowConfiguration.addMowerConfiguration(mowerConfiguration1);

        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.G);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.G);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.G);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.G);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);

        MowerConfiguration mowerConfiguration2 = new MowerConfiguration(2, 3, 3, OrientationEnum.E);
        mowItNowConfiguration.addMowerConfiguration(mowerConfiguration2);

        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.D);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.D);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.D);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.D);
        mowItNowConfiguration.addInstructionToCurrentMower(InstructionEnum.A);

        List<String> result = mowItNowService.mowIt(mowItNowConfiguration);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 2);

        Assert.assertEquals(result.get(0), "1 3 N");
        Assert.assertEquals(result.get(1), "5 1 E");

    }

}
