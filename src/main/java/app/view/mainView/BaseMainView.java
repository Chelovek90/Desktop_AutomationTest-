package app.view.mainView;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseMainView extends BaseElements {

    public BaseMainView(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.rootWindow = rootWindowSelector;
    }

    protected RemoteWebElement rootWindow;
    @WindowsFindBy(accessibility = "DocumentHost")
    private RemoteWebElement rootWindowSelector;
    @WindowsFindBy(accessibility = "TabHeadersPanel")
    private RemoteWebElement tabPanel;
    private String tabHeadersSelector = "TabHeadersPanel";
    private String tabNameHeadersSelector = "DocumentPaneItem";
    private String tabCloseButtonHeaderSelector = "ControlBoxButtonPresenter";
    private String nameValue = "Name";

    public void closeWorkspace() {
        RemoteWebElement header = (RemoteWebElement) tabPanel.findElementByClassName(tabNameHeadersSelector);
        RemoteWebElement closeButton = (RemoteWebElement) header.findElementByClassName(tabCloseButtonHeaderSelector);
        click(closeButton);
    }

}
