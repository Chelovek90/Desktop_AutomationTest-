package app;

import app.view.treeProject.BaseTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BaseElements extends Base {

    public BaseElements(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

}
