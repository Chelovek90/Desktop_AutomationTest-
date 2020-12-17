package app.modules.loader;

import app.view.treeProject.BaseTreeProject;
import app.view.treeProject.WellsTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class LoadLog extends BaseLoader{


    public LoadLog(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    @WindowsFindBy(accessibility = "cbName")
    private RemoteWebElement fieldWellName;
    @WindowsFindBy(accessibility = "cbWellDataLoader")
    private RemoteWebElement checkBoxWell;
    @WindowsFindBy(accessibility = "cbMapTemplateViewModel")
    private RemoteWebElement checkBoxLogs;
    @WindowsFindBy(accessibility = "cbLogDataLoader")
    private RemoteWebElement checkBoxLog;

    private String treeViewBase = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.WellTreeItem";
    private String treeViewLog = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.LogTreeItem";
    private String curveLog = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.CurveTreeItem";
    private String comboBox = "ComboBox";
    private String attributeName = "Value.Value";
    private String checkBoxClassName = "CheckBox";

    private RemoteWebElement treeLoad;
    private List<WebElement> curvesLogList;

    protected String wellName;
    protected String logName;

    public LoadLog openLoader() {
        openModule();
        return this;
    }

    public LoadLog clickOpenFile() {
        clickOpenFileButton();
        return this;
    }

    public LoadLog clickLoadFile() {
        clickLoadFileButton();
        return this;
    }

    public LoadLog loadLog(String path, String fileName) {
        loadFileFromWindows(path, fileName);
        this.treeLoad = (RemoteWebElement) loaderWindow.findElementByName(treeViewBase);
        this.wellName = fieldWellName.getAttribute(attributeName);
        this.logName = treeLoad.findElementByName(treeViewLog).findElement(By.className(comboBox)).getAttribute(attributeName);
        this.curvesLogList = treeLoad.findElementsByName(curveLog);
        return this;
    }


}