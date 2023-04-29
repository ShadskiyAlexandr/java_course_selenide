package utils.config;

import org.aeonbits.owner.ConfigFactory;

public class Config {

    private Config() {
        throw new IllegalStateException("Utility class");
    }

    public static TestRunConfig getRunConfig() {
        return ConfigFactory.create(TestRunConfig.class);
    }
    public static ApplicationConfig getApplicationConfig() {
        return ConfigFactory.create(ApplicationConfig.class);
    }
}
