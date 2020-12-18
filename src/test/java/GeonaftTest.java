import app.modules.loader.LoadLog;
import app.view.treeProject.WellsTreeProject;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class GeonaftTest extends BaseTest {
    private final int INDEXACTUALWELL = 0;
    private final int INDEXKEYWELL = 1;

    @Test
    public void test() throws InterruptedException {
        List<RemoteWebElement> indicator = desktopSession.findElementsByAccessibilityId("IndicatorText");
        System.out.println(indicator.size());
        System.out.println(indicator.size());
//        RemoteWebElement el = desktopSession.findElementByName("Открытие");
//        List<WebElement> listNameFiled = el.findElementsByName("Имя файла:");
//        System.out.println(listNameFiled.size());
//        listNameFiled.get(0).click();
//        Thread.sleep(200);
//        listNameFiled.get(1).click();
//        Thread.sleep(200);
//        listNameFiled.get(2).click();
//        new BaseTreeProject(desktopSession)
//                .clickFluidsTree();
//        new BaseTreeProject(desktopSession)
//                .clickTrendsTree();
//        new BaseTreeProject(desktopSession)
//                .clickSurfacesTree();
//        new BaseTreeProject(desktopSession)
//                .clickPolygonsTree();
//        new BaseTreeProject(desktopSession)
//                .clickModulesTree();

    }

    @Test
    public void testWells() {
//        RemoteWebElement el = desktopSession.findElementByAccessibilityId("DataTreeElement");
//        RemoteWebElement el1 = desktopSession.findElementByAccessibilityId("TreeView");
//        RemoteWebElement el2 = desktopSession.findElementByName("Geosteering.UI.Controls.DataTreeView.DataTree.WellsTreeViewItem");
//        System.out.println(el.getAttribute("ClickablePoint"));
//        System.out.println(el1.getAttribute("ClickablePoint"));
//        System.out.println(el2.getAttribute("ClickablePoint"));

//        new WellsTreeProject(desktopSession)
//                .clickWellsTopTree();



        new LoadLog(desktopSession)
                .openLoader()
                .clickOpenFile()
                .loadLog("D:\\Data for testing\\Каротажи", "12_actual_CUT_2m.las")
                .clickLoadFile()

                .checkLoadWell();
    }
}
