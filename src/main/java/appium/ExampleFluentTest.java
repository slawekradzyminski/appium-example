package appium;

import appium.config.Config;
import appium.config.ConfigException;
import appium.device.Device;
import io.appium.java_client.AppiumDriver;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
public class ExampleFluentTest extends FluentTest {

    private static final Logger log = LoggerFactory.getLogger(ExampleFluentTest.class);

    @Autowired
    private Device device;

    @Value("${appium.server.url}")
    private String appiumServerUrl;

    @Override
    public WebDriver newWebDriver() {
        log.info("Running test on Appium server {} using {}", appiumServerUrl, getDevice());
        return runTestOnAppiumServer();
    }

    private WebDriver runTestOnAppiumServer() {
        try {
            return new AppiumDriver<>(
                    new URL(appiumServerUrl), getCapabilities());
        } catch (MalformedURLException e) {
            throw new ConfigException("Invalid hub location: " + appiumServerUrl, e);
        }
    }

    @Override
    public Capabilities getCapabilities() {
        return getDevice().getCapabilities();
    }

    private Device getDevice() {
        return device;
    }

}
