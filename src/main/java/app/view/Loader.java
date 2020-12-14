package app.view;

import app.BaseElements;
import app.OpenModule;
import app.view.ribbon.Ribbon;
import app.view.treeProject.BaseTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class Loader extends BaseElements implements OpenModule {

    private Ribbon ribbon;
    private BaseTreeProject treeProject;
    private RemoteWebElement loaderWindow;
    private RemoteWebElement openFileButton;
    private RemoteWebElement loadFileButton;
    private RemoteWebElement skipFileButton;
    private RemoteWebElement closeFileButton;

    public Loader(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.ribbon = new Ribbon(driver);
        this.treeProject = new BaseTreeProject(driver);
    }

    @Override
    public Loader openModule() {
        ribbon.openLoader();
        this.loaderWindow = loaderWindowSelector;
        this.openFileButton = (RemoteWebElement) loaderWindow.findElementByName(openFileButtonSelector);
        this.loadFileButton = (RemoteWebElement) loaderWindow.findElementByName(loadFileButtonSelector);
        this.skipFileButton = (RemoteWebElement) loaderWindow.findElementByName(skipButtonSelector);
        this.closeFileButton = (RemoteWebElement) loaderWindow.findElementByName(closeButtonSelector);
        return this;
    }

    @FindBy(name = "ЗАГРУЗЧИК ДАННЫХ")
    private RemoteWebElement loaderWindowSelector;
    @WindowsFindBy(accessibility = "cbName")
    private RemoteWebElement cbLoadFileName;
    @FindBy(name = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.LogTreeItem")
    private RemoteWebElement downloadedFile;
    private String openFileButtonSelector = "Открыть файл";
    private String loadFileButtonSelector = "Загрузить";
    private String skipButtonSelector = "Пропустить";
    private String closeButtonSelector = "Закрыть";

    public Loader clickOpenFileButton() {
        click(openFileButton);
        return this;
    }

    public Loader loadFile(String path, String fileName) {
        loadFileFromWindows(path, fileName);
        return this;
    }

    public Loader clickLoadFileButton() {
        waitLoading();
        click(loadFileButton);
        return this;
    }

    public Loader checkLoadSurface(String fileName) {
        treeProject.searchSurfacesInTree(fileName);
        return this;
    }

}
