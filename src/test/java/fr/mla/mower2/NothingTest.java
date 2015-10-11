package fr.mla.mower2;

import fr.mla.mower2.business.service.ConfigurationService;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Component
@Test (enabled=false)
public class NothingTest {

    ConfigurationService configurationService;

    @BeforeClass
    private void testInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
        configurationService = context.getBean(ConfigurationService.class);
    }

    public void mgniah() throws Exception {

        MowItNowConfiguration mowItNowConfiguration = configurationService.configure(new String[]{
                "1 2",
                "0 0 N",
                "AAADAAA"});
    }


}
