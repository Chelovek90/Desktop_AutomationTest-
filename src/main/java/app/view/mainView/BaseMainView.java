package app.view.mainView;

import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseMainView extends BaseElements {

    public BaseMainView(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.rootWindow = rootWindowId;
    }

    protected RemoteWebElement rootWindow;
    protected RemoteWebElement treeWindow;
    protected RemoteWebElement workWindow;
    protected RemoteWebElement workFlowWindow;


    protected RemoteWebElement rootWindowId;

    @WindowsFindBy(accessibility = "TreeView")
    protected RemoteWebElement treeWindowId;
    protected String workWindowId = "DocumentHost";
    protected String workFlowWindowID = "Workflow";

    private String tabHeadersPanelClassName = "TabHeadersPanel";
    private String tabHeaderClassName = "DocumentPaneItem";

}
