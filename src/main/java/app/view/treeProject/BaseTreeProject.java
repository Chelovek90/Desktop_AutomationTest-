package app.view.treeProject;

import app.Base;
import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTreeProject extends BaseElements {

    public BaseTreeProject(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.treeWindow = mainViewSelector;
    }

    protected RemoteWebElement treeWindow;
    protected RemoteWebElement contextMenu;
    protected RemoteWebElement editContextMenu;

    @WindowsFindBy(accessibility = "TreeView")
    protected RemoteWebElement mainViewSelector;
    @FindBy(className = "ContextMenu")
    protected RemoteWebElement contextMenuSelector;

    protected String wellsTopBlock = "Geosteering.UI.Controls.DataTreeView.DataTree.WellsTreeViewItem";
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

//    public void getContextMenu (RemoteWebElement element) {
//        rightClick(element);
//        this.contextMenu = contextMenuSelector;
//        this.editContextMenu = (RemoteWebElement) contextMenu.findElementByName("Редактировать");
//    }

    public void clickEditContextMenu(RemoteWebElement element) {
        rightClick(element);
        this.contextMenu = contextMenuSelector;
        this.editContextMenu = (RemoteWebElement) contextMenu.findElementByName("Редактировать");
        click(editContextMenu);
    }

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
        assertThat("Block " + element.getText() + " is empty", expanderList.size() != 0);
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
            horizontalScroll(treeWindow, fluidsButton);
            doubleClick(fluidsButton);
        }
    }

    public void clickTrendsTree() {
        RemoteWebElement trends = (RemoteWebElement) treeWindow.findElementByName(trendsBlock);
        if (checkExpander(trends)) {
            RemoteWebElement trendsButton = (RemoteWebElement) trends.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, trendsButton);
            doubleClick(trendsButton);
        }
    }

    public void clickSurfacesTree() {
        RemoteWebElement surfaces = (RemoteWebElement) treeWindow.findElementByName(surfacesBlock);
        if (checkExpander(surfaces)) {
            RemoteWebElement surfacesButton = (RemoteWebElement) surfaces.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, surfacesButton);
            doubleClick(surfacesButton);
        }
    }

    public void clickPolygonsTree() {
        RemoteWebElement polygons = (RemoteWebElement) treeWindow.findElementByName(polygonsBlock);
        if (checkExpander(polygons)) {
            RemoteWebElement polygonsButton = (RemoteWebElement) polygons.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, polygonsButton);
            doubleClick(polygonsButton);
        }
    }

    public void clickPointsTree() {
        RemoteWebElement points = (RemoteWebElement) treeWindow.findElementByName(pointsBlock);
        if (checkExpander(points)) {
            RemoteWebElement pointsButton = (RemoteWebElement) points.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, pointsButton);
            doubleClick(pointsButton);
        }
    }

    public void clickModulesTree() {
        RemoteWebElement modules = (RemoteWebElement) treeWindow.findElementByName(modulesBlock);
        if (checkExpander(modules)) {
            RemoteWebElement modulesButton = (RemoteWebElement) modules.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, modulesButton);
            doubleClick(modulesButton);
        }
    }

    public void clickTemplatesTree() {
        RemoteWebElement templates = (RemoteWebElement) treeWindow.findElementByName(templatesBlock);
        if (checkExpander(templates)) {
            RemoteWebElement templatesButton = (RemoteWebElement) templates.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, templatesButton);
            doubleClick(templatesButton);
        }
    }

    public void clickPicturesTree() {
        RemoteWebElement pictures = (RemoteWebElement) treeWindow.findElementByName(picturesBlock);
        if (checkExpander(pictures)) {
            RemoteWebElement picturesButton = (RemoteWebElement) pictures.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, picturesButton);
            doubleClick(picturesButton);
        }
    }

    public void clickCubesTree() {
        RemoteWebElement cubes = (RemoteWebElement) treeWindow.findElementByName(cubesBlock);
        if (checkExpander(cubes)) {
            RemoteWebElement cubesButton = (RemoteWebElement) cubes.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, cubesButton);
            doubleClick(cubesButton);
        }
    }

    public void clickSectionsTree() {
        RemoteWebElement sections = (RemoteWebElement) treeWindow.findElementByName(wellSectionsBlock);
        if (checkExpander(sections)) {
            RemoteWebElement sectionsButton = (RemoteWebElement) sections.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, sectionsButton);
            doubleClick(sectionsButton);
        }
    }

    public void clickStressAnalysisTree() {
        RemoteWebElement stressAnalysis = (RemoteWebElement) treeWindow.findElementByName(stressAnalysisBlock);
        if (checkExpander(stressAnalysis)) {
            RemoteWebElement stressAnalysisButton = (RemoteWebElement) stressAnalysis.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, stressAnalysisButton);
            doubleClick(stressAnalysisButton);
        }
    }

    public void searchSurfacesInTree(String name) {
        clickSurfacesTree();
        boolean result = false;
        List<WebElement> results = treeWindow.findElementsByName(name);
        assertTrue(results.size() == 1, "Loaded surface not found");
    }
}
