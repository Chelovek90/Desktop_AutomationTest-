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

    private List<RemoteWebElement> indicatorLoad;
    private String indicatorText = "Загрузка данных";

    protected RemoteWebElement loaderWindow;
    private RemoteWebElement openFileButton;
    private RemoteWebElement loadFileButton;
    private RemoteWebElement skipFileButton;
    private RemoteWebElement closeFileButton;

    private RemoteWebElement openingWindow;
    private RemoteWebElement openingWindowOpenButton;
    private RemoteWebElement openingWindowCancelButton;
    private RemoteWebElement openingWindowLinkField;
    private RemoteWebElement openingWindowFileNameField;

    private String loaderWindowSelector = "ЗАГРУЗЧИК ДАННЫХ";
    @WindowsFindBy(accessibility = "cbName")
    private RemoteWebElement cbLoadFileName;
    @FindBy(name = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.LogTreeItem")
    private RemoteWebElement downloadedFile;
    private String openFileButtonSelector = "Открыть файл";
    private String loadFileButtonSelector = "Загрузить";
    private String skipButtonSelector = "Пропустить";
    private String closeButtonSelector = "Закрыть";
    private String openingWindowOpenButtonSelector = "Открыть";
    private String openingWindowCancelButtonSelector = "Отмена";
    private String openingWindowLinkFieldSelector = "Предыдущие расположения";
    private String openingWindowFileNameFieldSelector = "Имя файла:";

    @FindBy(name = "Открытие")
    private RemoteWebElement openingWindowSelector;

    public void waitLoading() {
        boolean load = true;
        while (load) {
            List<WebElement> indicator = loaderWindow.findElementsByName(indicatorText);
            if(indicator.size() == 0) {
                load = false;
            }
        }
    }

    public void clickOpenFileButton() {
        click(openFileButton);
        this.openingWindow = openingWindowSelector;
        this.openingWindowLinkField = (RemoteWebElement) openingWindow.findElementByName(openingWindowLinkFieldSelector);
        List<WebElement> listNameFiled = openingWindow.findElementsByName(openingWindowFileNameFieldSelector);
        this.openingWindowFileNameField = (RemoteWebElement) listNameFiled.get(1);
        this.openingWindowOpenButton = (RemoteWebElement) openingWindow.findElementByName(openingWindowOpenButtonSelector);
        this.openingWindowCancelButton = (RemoteWebElement) openingWindow.findElementByName(openingWindowCancelButtonSelector);
    }

    public void loadFileFromWindows(String path, String fileName) {
        copyInBuffer(path);
        click(openingWindowLinkField);
        pastFromBuffer();
        enterClick();
        click(openingWindowFileNameField);
        copyInBuffer(fileName);
        pastFromBuffer();
        click(openingWindowOpenButton);
    }

    public void clickLoadFileButton() {
        waitLoading();
        click(loadFileButton);
    }

    public void checkLoadSurface(String fileName) {

    }

}
