package app;

import app.view.treeProject.BaseTreeProject;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BaseElements extends Base {

    @WindowsFindBy(accessibility = "IndicatorText")
    private List<RemoteWebElement> indicatorLoad;

    /*Окно открытия файла*/
    @FindBy(name = "Открытие")
    private RemoteWebElement windowOpening;
    @FindBy(name = "Все папки")
    private RemoteWebElement linkField;
    @FindBy(name = "Breadcrumb Parent")
    private RemoteWebElement linkFieldClick;
    @FindBy(className = "Edit")
    private RemoteWebElement nameFileField;

    private String openButton = "Открыть";
    @FindBy(name = "Отмена")
    private RemoteWebElement cancelButton;

    /*Дерево проекта*/
    @FindBy(name = "Geosteering.UI.Controls.DataTreeView.DataTree.WellTreeViewItem")
    private List<WebElement> wellsInProject;
    private String classNameWell = "TextBlock";

    protected BaseTreeProject baseTreeProject;
    protected Base base;

    public BaseElements(WindowsDriver<RemoteWebElement> driver) {
        super(driver);
        this.baseTreeProject = new BaseTreeProject(driver);
        this.base = new Base(driver);
    }

    public void loadFileFromWindows(String path, String fileName) {
        copyInBuffer(path);
        click(linkField);
        pastFromBuffer();
        enterClick();
        click((RemoteWebElement) nameFileField.findElementByName("Имя файла:"));
        copyInBuffer(fileName);
        pastFromBuffer();
        windowOpening.findElementByName(openButton).click();
    }

    public void waitLoading() {
        boolean load = true;
        List<RemoteWebElement> indicator = indicatorLoad;
        while (load) {
            if(indicator.size() != 1) {
                load = false;
            }
        }
    }
}
