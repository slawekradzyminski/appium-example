package appium.device;

import org.openqa.selenium.Capabilities;

public interface Device {

    Capabilities getCapabilities();

    String getTestAppPath();

}
