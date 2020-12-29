package app;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public abstract class BaseElements extends Base {

    public BaseElements(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    /*TreeElements*/
    protected WebElement targetForClick;

    /*LoadLog*/
    protected String wellName;
    protected String logName;


}
