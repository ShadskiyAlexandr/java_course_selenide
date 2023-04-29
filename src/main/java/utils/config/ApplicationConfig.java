package utils.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/application.properties")
public interface ApplicationConfig extends Config{

    @Config.Key("base_url")
    String baseUrl();
}
