package fr.mla.mower2;

import fr.mla.mower2.business.service.ConfigurationService;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

@Component
@Test (enabled=true)
public class NothingTest {

    ConfigurationService configurationService;

    @BeforeClass
    private void testInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
        configurationService = context.getBean(ConfigurationService.class);
    }

    public void mgniah() throws Exception {

        MowItNowConfiguration mowItNowConfiguration = configurationService.configure(
                Arrays.asList(
                        "1 2",
                        "0 0 N",
                        "AAADAAA"));
    }


}
