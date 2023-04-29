package utils.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/testRun.properties")
public interface TestRunConfig extends Config {

//    @DefaultValue("chrome")
    @Config.Key("browser")
    String browser();

    @DefaultValue("1920x1080")
    @Config.Key("browser_size")
    String browserSize();
}
