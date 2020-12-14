package app.modules;

import app.BaseElements;
import app.OpenModule;
import app.view.ribbon.Ribbon;
import app.view.treeProject.WellsTreeProject;
import app.windows.StartWindow;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsModule extends BaseElements implements OpenModule {

    /*Ribbon elements*/
    @WindowsFindBy(className = "RibbonTabHeader")
    private RemoteWebElement csRibbonHeader;
    @FindBy(name = "Геонавигация")
    private RemoteWebElement csRibbonButton;
    @WindowsFindBy(accessibility = "PART_Content")
    private RemoteWebElement listOfAvailableWells;

    /*Скважины*/
    @WindowsFindBy(accessibility = "beActualWell")
    private RemoteWebElement actualWellField;
    @WindowsFindBy(accessibility = "biOffsetWell")
    private RemoteWebElement keyWellField;
    @FindBy(name = "Geosteering.Core.Infrastructure.ViewModels.EntityInfoViewModel`1[System.Guid]")
    private List<RemoteWebElement> listWellsInField;

    /*mainSection elements*/
    @FindBy(className = "DocumentPaneItem")
    private RemoteWebElement projectNameTabHeader;
    @WindowsFindBy(accessibility = "MarkersLayerForWellSection")
    private RemoteWebElement mainSection;
    @WindowsFindBy(accessibility = "TrackBoxVerGr")
    private RemoteWebElement verticalTrack;
    @WindowsFindBy(accessibility = "TrackBoxHorGr")
    private RemoteWebElement horizontalTrack;

    private final int INDEXACTUALWELL = 0;
    private final int INDEXKEYWELL = 1;
    private RemoteWebElement actaulWell;
    private RemoteWebElement keyWell;
    private StartWindow startWindow;
    private WellsTreeProject tree;
    private Ribbon ribbon;


    public CsModule(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.startWindow = new StartWindow(driver);
        this.tree = new WellsTreeProject(driver);
        this.ribbon = new Ribbon(driver);
    }

    @Override
    public CsModule openModule() {
        ribbon.openCsModule();
        return this;
    }

    public void appointWellsToWork() {

    }

    public CsModule chooseActualWell() {
        click(actualWellField);
        List<RemoteWebElement> list = listWellsInField;
        click(list.get(INDEXACTUALWELL));
        return this;
    }

    public CsModule chooseKeyWell() {
        click(keyWellField);
        List<RemoteWebElement> list = listWellsInField;
        click(list.get(INDEXKEYWELL));
        return this;
    }

    public CsModule checkDisplayActualWell(String name) {
        makeElementScreenshot(mainSection, name, appointment.ACTUAL);
        click(mainSection);
        tree.clickWellsTopTree();
        tree.clickWell(INDEXACTUALWELL);
        tree.clickTrajectoryCheckBox(INDEXACTUALWELL);
        makeElementScreenshot(mainSection, name, appointment.EXPECTED);
        takeDiffImage(name);
        return this;
    }

    public CsModule openProject(String link, String name) {
        startWindow.openProject(link, name);
        return this;
    }

    public CsModule checkValidProjectName() {
        String CsTabName = projectNameTabHeader.getText();
        Pattern pattern = Pattern.compile("\\^.+(_\\dTabButton)");
        Matcher matcherCsModuleName = pattern.matcher(CsTabName);
        boolean findName = matcherCsModuleName.find();
        String CsModuleName = matcherCsModuleName.group(0);
        return this;
    }


}
