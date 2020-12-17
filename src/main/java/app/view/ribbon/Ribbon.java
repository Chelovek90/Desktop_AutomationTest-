package app.view.ribbon;

import app.BaseElements;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class Ribbon extends BaseElements {

    protected RemoteWebElement projectButton;
    protected RemoteWebElement toolsButton;
    protected RemoteWebElement optionButton;
    private String clickablePointTab = "RibbonTabHeader";

    public Ribbon(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.projectButton = (RemoteWebElement) projectButtonTab.findElementByClassName(clickablePointTab);
//        this.toolsButton = (RemoteWebElement) toolsButtonTab.findElementByClassName(clickablePointTab);
//        this.optionButton = (RemoteWebElement) optionButtonTab.findElementByClassName(clickablePointTab);
    }

    @FindBy(className = "ProjectTab")
    private RemoteWebElement projectButtonTab;
    @FindBy(className = "ProjectToolsTab")
    private RemoteWebElement toolsButtonTab;
    @FindBy(className = "OptionsTab")
    private RemoteWebElement optionButtonTab;


    @FindBy(name = "Geosteering.Geonaft.Module.CrossSection.CrossSectionToolbarInfo")
    private RemoteWebElement csButton;

    @FindBy(name = "Geosteering.Geonaft.Module.Dataloader.Modularity.DataLoaderToolbarInfo")
    private RemoteWebElement loaderButton;


    public void openCsModule() {
        click(projectButton);
        click(csButton);
    }

    public void openLoader() {
        click(projectButton);
        click(loaderButton);
    }


}
