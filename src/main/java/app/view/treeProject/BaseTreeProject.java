package app.view.treeProject;

import app.Base;
import app.BaseElements;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTreeProject extends BaseElements {

    public BaseTreeProject(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.treeWindow = mainViewSelector;
    }

    private List<WebElement> surfacesList;
    private String surfaces = "Geosteering.UI.Controls.DataTreeView.DataTree.SurfaceTreeViewItem";

    protected RemoteWebElement treeWindow;
    protected RemoteWebElement editContextMenu;

    @WindowsFindBy(accessibility = "TreeView")
    protected RemoteWebElement mainViewSelector;
    @FindBy(className = "ContextMenu")
    protected RemoteWebElement contextMenuSelector;
    @WindowsFindBy(accessibility = "OKButton")
    protected RemoteWebElement okButton;

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

//    public void getContextMenu (RemoteWebElement element) {
//        rightClick(element);
//        this.contextMenu = contextMenuSelector;
//        this.editContextMenu = (RemoteWebElement) contextMenu.findElementByName("Редактировать");
//    }

    public void getContextMenu(RemoteWebElement element) {
        scrollToElementTree(element);
        rightClick(element);
        RemoteWebElement contextMenu = contextMenuSelector;
        this.editContextMenu = (RemoteWebElement) contextMenu.findElementByName("Редактировать");
    }

    public void unfoldElementTree(RemoteWebElement element) {
        if (checkExpander(element)) {
            RemoteWebElement elementButton = (RemoteWebElement) element.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, elementButton);
            doubleClick(elementButton);
        }
    }

    public void scrollToElementTree(RemoteWebElement element) {
            RemoteWebElement elementButton = (RemoteWebElement) element.findElementByClassName(clickablePoint);
            horizontalScroll(treeWindow, elementButton);
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

    public void takeSurfacesList() {
        this.surfacesList = treeWindow.findElementsByName(surfaces);
    }

    public void clickSurfacesTree() {
        RemoteWebElement surfaces = (RemoteWebElement) treeWindow.findElementByName(surfacesBlock);
        unfoldElementTree(surfaces);
    }

    public void checkSurfacesByName(String nameSurface) {
        clickSurfacesTree();
        takeSurfacesList();
        this.targetForClick = surfacesList.stream()
                .filter(surface -> surface.findElement(By.className(clickablePoint)).getText().equals(nameSurface))
                .findFirst().orElse(null);
        assertTrue(targetForClick != null, "Search surfaces by name " + nameSurface + " returned no results");
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


    public void clickEditContextMenu(){
        getContextMenu((RemoteWebElement)targetForClick);
        click(editContextMenu);
        List<WebElement> attention = driver.findElementByClassName("Window").findElementsByName("Предупреждение");
        if (attention.size() != 0) {
            RemoteWebElement ok = okButton;
            click(ok);
        }
    }

    public void checkDataEditor(){
        RemoteWebElement table = driver.findElementByAccessibilityId("dataPresenter");
        List<WebElement> list = table.findElementsByName("System.Data.DataRowView");
        assertTrue(list.size() != 0, "Data is empty");
    }
}
