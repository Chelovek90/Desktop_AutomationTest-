package app.view;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class propertiesBlock extends BaseElements {

    @WindowsFindBy(accessibility = "Properties")
    private RemoteWebElement properties;

    @FindBy(name = "Geosteering.Core.Properties.Base.CategoryItem")
    private RemoteWebElement categoryProperties;

    public propertiesBlock(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }
}
