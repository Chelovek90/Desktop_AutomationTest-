package app.view.ribbon;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseRibbon extends BaseElements {

    protected RemoteWebElement ribbonPanel;
    protected RemoteWebElement projectTab;
    protected RemoteWebElement projectButtonTab;

    public BaseRibbon(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.ribbonPanel = ribbonPanelSelector;
        this.projectTab = (RemoteWebElement) ribbonPanel.findElementByClassName(projectTabSelector);
        this.projectButtonTab = (RemoteWebElement) projectTab.findElementByClassName(tabButtonSelector);
    }

    @WindowsFindBy(accessibility = "RibbonGeo")
    private RemoteWebElement ribbonPanelSelector;

    private String tabButtonSelector = "RibbonTabHeader";
    private String projectTabSelector = "ProjectTab";
    private String loaderButtonSelector = "Geosteering.Geonaft.Module.Dataloader.Modularity.DataLoaderToolbarInfo";

    public void clickProjectTab() {
        click(projectButtonTab);
    }

    public void openLoader() {
        clickProjectTab();
        click((RemoteWebElement) projectTab.findElementByName(loaderButtonSelector));
    }



}
