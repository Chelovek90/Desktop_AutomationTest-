package app.view.ribbon;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class ProjectTab extends BaseRibbon{

    protected RemoteWebElement loaderButton;

    public ProjectTab(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    private String loaderButtonSelector = "Geosteering.Geonaft.Module.Dataloader.Modularity.DataLoaderToolbarInfo";

    public void openLoader() {
        clickProjectTab();
        this.loaderButton = (RemoteWebElement) projectButtonTab.findElementByName(loaderButtonSelector);
        click(loaderButton);
    }
}
