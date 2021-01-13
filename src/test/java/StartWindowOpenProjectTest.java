import app.windows.StartWindow;
import base.BaseTest;
import org.junit.jupiter.api.Test;

public class StartWindowOpenProjectTest extends BaseTest {
    String fileLink = "D:\\Data for testing\\Проекты";
    String fileName = "Полный набор_3.6.98.10";

    @Test
    public void test() {
        new StartWindow(desktopSession)
                .openProject(fileLink, fileName);
    }
}

