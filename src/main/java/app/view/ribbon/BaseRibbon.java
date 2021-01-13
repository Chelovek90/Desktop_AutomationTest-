package app.view.ribbon;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class BaseRibbon extends BaseElements {

    protected RemoteWebElement ribbonPanel;
    protected RemoteWebElement projectTab;
    protected RemoteWebElement projectButtonTab;

    public BaseRibbon(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.ribbonPanel = ribbonPanelSelector;

    }

    @WindowsFindBy(accessibility = "RibbonGeo")
    private RemoteWebElement ribbonPanelSelector;

    private String tabButtonSelector = "RibbonTabHeader";
    private String projectTabSelector = "ProjectTab";
    private String modulesGroupSelector = "RibbonGroup";
    private String loaderButtonSelector = "Geosteering.Geonaft.Module.Dataloader.Modularity.DataLoaderToolbarInfo";
    private String editorButtonSelector = "Geosteering.Geonaft.Module.DataEditor.DataEditorToolbarInfo";
    private String CsButtonSelector = "Geosteering.Geonaft.Module.CrossSection.CrossSectionToolbarInfo";
    private String syntheticsButtonSelector = "Geosteering.Geonaft.Module.Synthetics.SyntheticsToolbarInfo";
    private String correlationButtonSelector = "Geosteering.Geonaft.Module.CorrelationPanel.Modularity.CorrelationPanelToolbarInfo";

    public void clickProjectTab() {
        this.projectTab = (RemoteWebElement) ribbonPanel.findElementByClassName(projectTabSelector);
        this.projectButtonTab = (RemoteWebElement) projectTab.findElementByClassName(tabButtonSelector);
        click(projectButtonTab);
    }

    public void openLoader() {
        clickProjectTab();
        List<WebElement> groups = projectTab.findElementsByClassName(modulesGroupSelector);
        RemoteWebElement dataGroup = (RemoteWebElement) groups.get(0);
        click((RemoteWebElement) dataGroup.findElementByName(loaderButtonSelector));
    }

    public void openEditor() {
        clickProjectTab();
        click((RemoteWebElement) projectTab.findElementByName(editorButtonSelector));
    }

    public void openCs() {
        clickProjectTab();
        click((RemoteWebElement) projectTab.findElementByName(CsButtonSelector));
    }

    public void openSynthetics() {
        clickProjectTab();
        click((RemoteWebElement) projectTab.findElementByName(syntheticsButtonSelector));
    }

    public void openCorrelation() {
        clickProjectTab();
        click((RemoteWebElement) projectTab.findElementByName(correlationButtonSelector));
    }

}
