package app.windows;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartWindow extends BaseElements {

    protected List<WebElement> buttonsStartWindowGF;

    @FindBy(className = "StartPageView")
    private RemoteWebElement startWindowGF;
    private String button = "Button";

    @WindowsFindBy(accessibility = "Yes")
    private RemoteWebElement yesNotificationWindow;
    @WindowsFindBy(accessibility = "No")
    private RemoteWebElement noNotificationWindow;
    private String notificationWindowSelector = "Предупреждение";

    public StartWindow(WindowsDriver<RemoteWebElement> driver) {
        super(driver);

    }

    public StartWindow takeButtonsStartWindowGF() {
        this.buttonsStartWindowGF = startWindowGF.findElementsByClassName(button);
        return this;
    }

    public StartWindow openButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(0);
        openBtn.click();
        return this;
    }

    public StartWindow newButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(1);
        openBtn.click();
        return this;
    }

    public StartWindow openProject(String link, String name) {
        openButtonClick();
        getElementOpeningWindow();
        loadFileFromWindows(link, name);
        List<WebElement> notification = windowsElement.findElementsByName(notificationWindowSelector);
        if (notification.size() != 0){
            click(yesNotificationWindow);
            waitLoading();
        }
        return this;
    }

    public StartWindow logsButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(2);
        openBtn.click();
        return this;
    }
    public StartWindow aboutButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(3);
        openBtn.click();
        return this;
    }
    public StartWindow settingsButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(4);
        openBtn.click();
        return this;
    }
    public StartWindow exitButtonClick() {
        takeButtonsStartWindowGF();
        RemoteWebElement openBtn = (RemoteWebElement) buttonsStartWindowGF.get(5);
        openBtn.click();
        return this;
    }


}
