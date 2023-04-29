package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import utils.config.Config;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    @BeforeEach
    void setUp() {
        Configuration.screenshots = true;

        Configuration.browser = Config.getRunConfig().browser();
        Configuration.browserSize = Config.getRunConfig().browserSize();
        Configuration.baseUrl = Config.getApplicationConfig().baseUrl();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
