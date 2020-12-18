package app;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public abstract class BaseElements extends Base {

    public BaseElements(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

}
