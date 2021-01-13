package app.modules.loader;

import app.view.treeProject.WellsTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class LoadLog extends BaseLoader{

    private WellsTreeProject tree;
    public LoadLog getTree() {
        this.tree = new WellsTreeProject(driver);
        return this;
    }

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
    private String checkBoxClassName = "CheckBox";

    private RemoteWebElement treeLoad;
    private List<WebElement> curvesLogList;

    public LoadLog openLoader() {
        openModule();
        return this;
    }

    public LoadLog clickLoadFile() {
        clickLoadFileButton();
        return this;
    }

    public LoadLog loadLog(String path, String fileName) {
        clickOpenFileButton();
        loadFileFromWindows(path, fileName);
        this.treeLoad = (RemoteWebElement) loaderWindow.findElementByName(treeViewBase);
        this.wellName = fieldWellName.getAttribute(attributeName);
        this.logName = treeLoad.findElementByName(treeViewLog).findElement(By.className(comboBox)).getAttribute(attributeName);
        this.curvesLogList = treeLoad.findElementsByName(curveLog);
        clickLoadFileButton();
        return this;
    }

    public LoadLog checkLoadWell() {
        tree.checkWellByName(wellName);
        return this;
    }

    public LoadLog checkLoadLog() {
        tree.checkLogByName(wellName, logName);
        return this;
    }

    public LoadLog checkEditor() {
        tree.clickEditContextMenu();
        tree.checkDataEditor();
        return this;
    }

}
