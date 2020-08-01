package appium.config;

import appium.device.Android;
import appium.device.Iphone;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(value = {"appium"})
@PropertySources(@PropertySource("config.properties"))
public class Config {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Profile("iphone")
    @Bean
    public Iphone iphone() {
        return new Iphone();
    }

    @Profile("android")
    @Bean
    public Android android() {
        return new Android();
    }

}
