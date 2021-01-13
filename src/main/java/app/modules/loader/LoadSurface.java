package app.modules.loader;

import app.view.treeProject.WellsTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoadSurface extends BaseLoader{
    public LoadSurface(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    private WellsTreeProject tree;
    public LoadSurface getTree() {
        this.tree = new WellsTreeProject(driver);
        return this;
    }

    private RemoteWebElement surfaceLoad;
    private String treeViewBase = "Geosteering.Geonaft.Module.Dataloader.Classes.DataTree.Items.SurfaceTreeItem";
    @WindowsFindBy(accessibility = "tboxSurfaceViewModel")
    private RemoteWebElement fieldSurfaceName;

    public LoadSurface openLoader() {
        openModule();
        return this;
    }

    public LoadSurface loadSurface(String path, String fileName) {
        clickOpenFileButton();
        loadFileFromWindows(path, fileName);
        this.surfaceName = fieldSurfaceName.getAttribute(attributeName);
        clickLoadFileButton();
        return this;
    }

    public LoadSurface checkLoadSurface() {
        tree.checkSurfacesByName(surfaceName);
        tree.clickEditContextMenu();
        tree.checkDataEditor();
        return this;
    }


}
