package app.view.treeProject;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class WellsTreeProject extends BaseTreeProject {

    private List<WebElement> wellsList;
    private List<WebElement> logsList;
    private List<RemoteWebElement> stratigraphiesList;
    private List<RemoteWebElement> markersCheckBoxList;
    private List<RemoteWebElement> wellDesignsList;

    public WellsTreeProject(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
    }

    private String wells = "Geosteering.UI.Controls.DataTreeView.DataTree.WellTreeViewItem";
    private String logsMain = "Geosteering.UI.Controls.DataTreeView.DataTree.LogsTreeViewItem";
    private String logs = "Geosteering.UI.Controls.DataTreeView.DataTree.LogTreeViewItem";

    @FindBy(name = "Geosteering.UI.Controls.DataTreeView.DataTree.TrajectoryTreeViewItem")
    private List<RemoteWebElement> trajectories;
    @FindBy(name = "Geosteering.UI.Controls.DataTreeView.DataTree.MarkersTreeViewItem")
    private List<RemoteWebElement> stratigraphy;
    @WindowsFindBy(accessibility = "cbMarker")
    private List<RemoteWebElement> markersCheckBox;
    @FindBy(name = "Geosteering.UI.Controls.DataTreeView.DataTree.WellDesignsTreeViewItemViewModel")
    private List<RemoteWebElement> wellDesigns;

    public void takeWellsList() {
        RemoteWebElement wellsTop = (RemoteWebElement) treeWindow.findElementByName(wellsTopBlock);
        this.wellsList = wellsTop.findElementsByName(wells);
    }

    public void takeLogsList() {
        RemoteWebElement logsTop = (RemoteWebElement) treeWindow.findElementByName(logsMain);
        this.logsList = logsTop.findElementsByName(logs);
    }

    public void takeStratigraphiesList() {
        this.stratigraphiesList = stratigraphy;
    }

    public void takeMarkersCheckBoxList() {
        this.markersCheckBoxList = markersCheckBox;
    }

    public void takeWellDesignsList() {
        this.wellDesignsList = wellDesigns;
    }

    public void clickWellsTopTree() {
        unfoldElementTree((RemoteWebElement) treeWindow.findElementByName(wellsTopBlock));
    }

    public void clickLogsTree() {
        unfoldElementTree((RemoteWebElement) treeWindow.findElementByName(logsMain));
    }

    public void checkWellByName(String nameWell) {
//        DateFormat newDate = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
//        Date date = new Date();
//        moveTo(mainViewSelector);
//        horizontalScroll(mainViewSelector, (RemoteWebElement) treeWindow.findElementByName(wellsTopBlock));
        clickWellsTopTree();
        takeWellsList();
        this.targetForClick = wellsList.stream()
                .filter(well -> well.findElement(By.className(clickablePoint)).getText().equals(nameWell))
                .findFirst().orElse(null);
//        if (targetWellForClick == null){
//            makeElementScreenshot(mainViewSelector, "Fail search well by name " + newDate.format(date), appointment.ACTUAL);
//        }else {makeElementScreenshot((RemoteWebElement) treeWindow.findElementByName(wellsTopBlock), targetWellForClick.getText(), appointment.ACTUAL);}

        assertTrue(targetForClick != null, "Search for name " + nameWell + " returned no results");
    }

    public void clickWellByName(String name) {
        checkWellByName(name);
        unfoldElementTree((RemoteWebElement) targetForClick);
    }

    public void checkLogByName(String nameWell, String nameLog) {
        clickWellByName(nameWell);
        clickLogsTree();
        takeLogsList();
        this.targetForClick = logsList.stream()
                .filter(trajectory -> trajectory.findElement(By.className(clickablePoint)).getText().equals(nameLog))
                .findFirst().orElse(null);
        assertTrue(targetForClick != null, "Search for name " + nameLog + " returned no results");
    }

    public void clickEditContextMenu(){
        clickEditContextMenu((RemoteWebElement) targetForClick);
    }



//    public void clickWell(int index) {
//        takeWellsList();
//        RemoteWebElement well = wellsList.get(index);
//        if (checkExpander(well)) {
//            RemoteWebElement wellButton = (RemoteWebElement) well.findElementByClassName(clickablePoint);
//            horizontalScroll(mainView, wellButton);
//            doubleClick(wellButton);
//        }
//    }

//    public void clickWellByName(String name) {
//        takeWellsList();
//        System.out.println(wellsList.size());
//        for (RemoteWebElement e: wellsList) {
//            System.out.println(e.findElementByClassName(clickablePoint).getText());
//        }
//        RemoteWebElement listWells;
//        listWells = wellsList.stream()
//                .filter(e -> e.findElementByClassName(clickablePoint).getText().equals(name))
//                .findFirst().orElse(null);
////                .collect(Collectors.toList());
//        System.out.println(listWells);

//        for (RemoteWebElement element : wellsList) {
//            String wellName = element.findElementByClassName(clickablePoint).getText();
//            if (wellName.equals(name)) {
//               well = element;
//                if (checkExpander(well)) {
//                    RemoteWebElement wellButton = (RemoteWebElement) well.findElementByClassName(clickablePoint);
//                    horizontalScroll(mainView, wellButton);
//                    doubleClick(wellButton);
//                    break;
//                }
//            }
//        }
//    }

//    public void clickWellCheckBox(int index) {
//        takeWellsList();
//        RemoteWebElement well = wellsList.get(index);
//        RemoteWebElement wellButton = (RemoteWebElement) well.findElementByClassName(clickablePoint);
//        horizontalScroll(mainView, wellButton);
//        clickCheckBox(well);
//    }

//    public void clickTrajectory(int index) {
//        takeTrajectoryWellsList();
//        RemoteWebElement trajectory = trajectoryWellsList.get(index);
//        if (checkExpander(trajectory)) {
//            RemoteWebElement trajectoryButton = (RemoteWebElement) trajectory.findElementByClassName(clickablePoint);
//            horizontalScroll(mainView, trajectoryButton);
//            doubleClick(trajectoryButton);
//        }
//    }

//    public void clickTrajectoryCheckBox(int index) {
//        takeTrajectoryWellsList();
//        RemoteWebElement trajectory = trajectoryWellsList.get(index);
//        RemoteWebElement trajectoryButton = (RemoteWebElement) trajectory.findElementByClassName(clickablePoint);
//        horizontalScroll(mainView, trajectoryButton);
//        clickCheckBox(trajectory);
//    }
//
//    public void clickStratigraphy(int index) {
//        takeStratigraphiesList();
//        RemoteWebElement stratigraphy = stratigraphiesList.get(index);
//        if (checkExpander(stratigraphy)) {
//            RemoteWebElement stratigraphyButton = (RemoteWebElement) stratigraphy.findElementByClassName(clickablePoint);
//            horizontalScroll(mainView, stratigraphyButton);
//            doubleClick(stratigraphyButton);
//        }
//    }
//
//    public void clickStratigraphyCheckBox(int index) {
//        takeStratigraphiesList();
//        RemoteWebElement stratigraphy = stratigraphiesList.get(index);
//        RemoteWebElement stratigraphyButton = (RemoteWebElement) stratigraphy.findElementByClassName(clickablePoint);
//        horizontalScroll(mainView, stratigraphyButton);
//        clickCheckBox(stratigraphy);
//    }
//
//    public void clickMarkerCheckBox(int index) {
//        takeMarkersCheckBoxList();
//        RemoteWebElement marker = markersCheckBoxList.get(index);
//        horizontalScroll(mainView, marker);
//        clickCheckBox(marker);
//    }
//
//    public void clickWellDesigns(int index) {
//        takeWellDesignsList();
//        RemoteWebElement wellDesigns = wellDesignsList.get(index);
//        if (checkExpander(wellDesigns)) {
//            RemoteWebElement wellDesignsButton = (RemoteWebElement) wellDesigns.findElementByClassName(clickablePoint);
//            horizontalScroll(mainView, wellDesignsButton);
//            doubleClick(wellDesignsButton);
//        }
//    }
//
//    public void clickWellDesignsCheckBox(int index) {
//        takeWellDesignsList();
//        RemoteWebElement wellDesigns = wellDesignsList.get(index);
//        RemoteWebElement wellDesignsButton = (RemoteWebElement) wellDesigns.findElementByClassName(clickablePoint);
//        horizontalScroll(mainView, wellDesignsButton);
//        clickCheckBox(wellDesigns);
//    }
//
//    public void searchWellInTree(String name) {
//        clickWellsTopTree();
//        boolean result = false;
//        List<WebElement> results = mainView.findElementsByName(name);
//        assertTrue(results.size() == 1, "Loaded well not found");
//    }
//
//    public void searchTrajectoryInTree(String name) {
//        clickWellsTopTree();
//        boolean result = false;
//        List<WebElement> results = mainView.findElementsByName(name);
//        assertTrue(results.size() == 1, "Loaded well not found");
//    }

}
