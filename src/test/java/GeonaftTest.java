import app.modules.CsModule;
import app.view.treeProject.WellsTreeProject;
import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.remote.RemoteWebElement;

public class GeonaftTest extends BaseTest {
    private final int INDEXACTUALWELL = 0;
    private final int INDEXKEYWELL = 1;

    @Disabled
    @Test
    public void chooseActaulWeellOnCS() {
        new CsModule(desktopSession)
                .chooseActualWell();
    }

    @Test
    @DisplayName("Отображение актуальной скважины в окне главного разреза")
    public void shouldDisplayActualWell(TestInfo testInfo) {
        String name = testInfo.getDisplayName();
        new CsModule(desktopSession)
                .openModule()
                .chooseActualWell()
                .chooseKeyWell()
                .checkDisplayActualWell(name);
    }

//    @Test
//    public  void testOnCheckBoxTrajectory() {
//        new CsModule(desktopSession)
//                .offOnCheckBoxTrajectory(INDEXACTUALWELL);
//    }

    @Test
    public void test() {

//        new WellsTreeProject(desktopSession)
//                .clickWellsTree();

//        new WellsTreeProject(desktopSession)
//                .clickWellInTreeProject(0);

        new WellsTreeProject(desktopSession)
                .clickWellDesignsCheckBox(0);
    }

    @Test
    public void testExpander() {
        RemoteWebElement element = desktopSession.findElementByName("Geosteering.UI.Controls.DataTreeView.DataTree.TrajectoryTreeViewItem");
        RemoteWebElement element1 = (RemoteWebElement) element.findElementByClassName("Button");
        boolean expander = Boolean.parseBoolean(element1.getAttribute("Toggle.ToggleState"));
        System.out.println(expander);
        System.out.println(element1.getAttribute("Toggle.ToggleState"));
    }

    @Test
    public void testLoader() {
//        new Loader(desktopSession)
//                .openModule()
//                .clickOpenFileButton()
//                .loadFile("D:\\Data for testing\\Поверхности\\GRD", "U3_top.grd")
//                .clickLoadFileButton()
//                .checkLoadSurface("U3_t");

//        new WellsTreeProject(desktopSession)
//                .searchWellInTree("WBS");
//    }

        new WellsTreeProject(desktopSession)
                .clickWellByName("Опорная");
    }
}
