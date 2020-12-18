package app.view.treeProject;

import app.Base;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTreeProject extends Base {

    public BaseTreeProject(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.treeWindow = mainView;
    }

    protected RemoteWebElement treeWindow;

//    @WindowsFindBy(accessibility = "TreeView")
    @WindowsFindBy(accessibility = "DataTreeElement")
    protected RemoteWebElement mainView;

    private String fluidContactsBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.FluidContactsTreeViewItem";
    private String zonesBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.ZonesTreeViewItem";
    private String trendsBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.TrendsTreeViewItem";
    private String surfacesBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.SurfacesTreeViewItem";
    private String polygonsBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.PolygonsTreeViewItem";
    private String pointsBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.PointsTreeViewItem";
    private String modulesBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.ModulesTreeViewItem";
    private String templatesBlock = "Geosteering.UI.Controls.DataTreeView.PropertiesTemplates.TemplatesTreeViewItem";
    private String picturesBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.PicturesTreeViewItem";
    private String cubesBlock = "Geosteering.Geonaft.Module.Module3D.Resources.DataTree.CubesTreeViewItem";
    private String wellSectionsBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.WellSectionsTreeViewitemViewModel";
    private String stressAnalysisBlock = "Geosteering.Geonaft.Module.StressAnalysis.Resources.DataTree.StressAnalysisTreeViewModel";

    protected String expander = "Button";
    protected String checkBox = "CheckBox";
    protected String clickablePoint = "TextBlock";

    public void unfoldElementTree(RemoteWebElement element) {
        if (checkExpander(element)) {
            RemoteWebElement elementButton = (RemoteWebElement) element.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, elementButton);
            doubleClick(elementButton);
        }
    }

    public boolean checkExpander(RemoteWebElement element) {
        int expanderPosition;
        List <WebElement> expanderList = element.findElementsByClassName(this.expander);
        assertThat("Block " + element.getTagName() + " is empty", expanderList.size() != 0);
        RemoteWebElement expander = (RemoteWebElement) expanderList.get(0);
        expanderPosition = Integer.parseInt(expander.getAttribute("Toggle.ToggleState"));
        return (expanderPosition == 0);
    }

    public void clickCheckBox(RemoteWebElement element) {
        RemoteWebElement checkBoxElement = (RemoteWebElement) element.findElementByClassName(checkBox);
        click(checkBoxElement);
    }

    public void clickFluidsTree() {
        RemoteWebElement fluids = (RemoteWebElement) treeWindow.findElementByName(fluidContactsBlock);
        if (checkExpander(fluids)) {
            RemoteWebElement fluidsButton = (RemoteWebElement) fluids.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, fluidsButton);
            doubleClick(fluidsButton);
        }
    }

    public void clickTrendsTree() {
        RemoteWebElement trends = (RemoteWebElement) treeWindow.findElementByName(fluidContactsBlock);
        if (checkExpander(trends)) {
            RemoteWebElement trendsButton = (RemoteWebElement) trends.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, trendsButton);
            doubleClick(trendsButton);
        }
    }

    public void clickSurfacesTree() {
        RemoteWebElement surfaces = (RemoteWebElement) treeWindow.findElementByName(surfacesBlock);
        if (checkExpander(surfaces)) {
            RemoteWebElement surfacesButton = (RemoteWebElement) surfaces.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, surfacesButton);
            doubleClick(surfacesButton);
        }
    }

    public void clickPolygonsTree() {
        RemoteWebElement polygons = (RemoteWebElement) treeWindow.findElementByName(fluidContactsBlock);
        if (checkExpander(polygons)) {
            RemoteWebElement polygonsButton = (RemoteWebElement) polygons.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, polygonsButton);
            doubleClick(polygonsButton);
        }
    }

    public void clickPointsTree() {
        RemoteWebElement points = (RemoteWebElement) treeWindow.findElementByName(fluidContactsBlock);
        if (checkExpander(points)) {
            RemoteWebElement pointsButton = (RemoteWebElement) points.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, pointsButton);
            doubleClick(pointsButton);
        }
    }

    public void clickModulesTree() {
        RemoteWebElement modules = (RemoteWebElement) treeWindow.findElementByName(fluidContactsBlock);
        if (checkExpander(modules)) {
            RemoteWebElement modulesButton = (RemoteWebElement) modules.findElementByClassName(clickablePoint);
            horizontalScroll(mainView, modulesButton);
            doubleClick(modulesButton);
        }
    }

    public void clickTemplatesTree() {
    }

    public void clickPicturesTree() {
    }

    public void clickCubesTree() {
    }

    public void clickSectionsTree() {
    }

    public void clickStressAnalysisTree() {
    }

    public void searchSurfacesInTree(String name) {
        clickSurfacesTree();
        boolean result = false;
        List<WebElement> results = mainView.findElementsByName(name);
        assertTrue(results.size() == 1, "Loaded surface not found");
    }


}
