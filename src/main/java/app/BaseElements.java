package app;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BaseElements extends Base {

    public BaseElements(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    /*TreeElements*/
    protected WebElement targetForClick;

    /*Loader*/
    protected String wellName;
    protected String logName;
    protected String surfaceName;

    @FindBy(className = "Window")
    protected RemoteWebElement windowsElement;

    @FindBy(name = "Открытие")
    private RemoteWebElement openingWindowSelector;
    private String openingWindowLinkFieldSelector = "Предыдущие расположения";
    private String openingWindowFileNameFieldSelector = "Имя файла:";
    private String openingWindowOpenButtonSelector = "Открыть";
    private String openingWindowCancelButtonSelector = "Отмена";
    protected RemoteWebElement openingWindow;
    protected RemoteWebElement openingWindowCancelButton;
    protected RemoteWebElement openingWindowOpenButton;
    protected RemoteWebElement openingWindowLinkField;
    protected RemoteWebElement openingWindowFileNameField;

    public void getElementOpeningWindow() {
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
        copyInBuffer(fileName);
        click(openingWindowFileNameField);
        pastFromBuffer();
        click(openingWindowOpenButton);
    }


    protected RemoteWebElement loaderWindow;
    private List<RemoteWebElement> indicatorLoad;
    private String indicatorText = "Загрузка данных";

    public void waitLoading() {
        boolean load = true;
        while (load) {
            List<WebElement> indicator = loaderWindow.findElementsByName(indicatorText);
            if(indicator.size() == 0) {
                load = false;
            }
        }
    }



}
