package app.modules.loader;

import app.BaseElements;
import app.OpenModule;
import app.view.ribbon.BaseRibbon;
import app.view.treeProject.BaseTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BaseLoader extends BaseElements implements OpenModule {

    private BaseRibbon baseRibbon;
    private BaseTreeProject treeProject;

    public BaseLoader(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
//        this.treeProject = new BaseTreeProject(driver);
        this.baseRibbon = new BaseRibbon(driver);
    }

    protected String attributeName = "Value.Value";
    private String loaderWindowSelector = "ЗАГРУЗЧИК ДАННЫХ";
    @WindowsFindBy(accessibility = "cbName")
    private RemoteWebElement cbLoadFileName;
    @FindBy(name = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.LogTreeItem")
    private RemoteWebElement downloadedFile;
    private String openFileButtonSelector = "Открыть файл";
    private String loadFileButtonSelector = "Загрузить";
    private String skipButtonSelector = "Пропустить";
    private String closeButtonSelector = "Закрыть";

    @Override
    public BaseLoader openModule() {
        baseRibbon.openLoader();
        this.loaderWindow = (RemoteWebElement) driver.findElementByClassName("Window").findElementByName(loaderWindowSelector);
        this.openFileButton = (RemoteWebElement) loaderWindow.findElementByName(openFileButtonSelector);
        this.loadFileButton = (RemoteWebElement) loaderWindow.findElementByName(loadFileButtonSelector);
        this.skipFileButton = (RemoteWebElement) loaderWindow.findElementByName(skipButtonSelector);
        this.closeFileButton = (RemoteWebElement) loaderWindow.findElementByName(closeButtonSelector);
        return this;
    }
    private RemoteWebElement openFileButton;
    private RemoteWebElement loadFileButton;
    private RemoteWebElement skipFileButton;
    private RemoteWebElement closeFileButton;

    public void clickOpenFileButton() {
        click(openFileButton);
        getElementOpeningWindow();
    }

    public void clickLoadFileButton() {
        waitLoading();
        click(loadFileButton);
    }

    public void checkLoadSurface(String fileName) {

    }

}
