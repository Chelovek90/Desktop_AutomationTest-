package base;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WindowsDriver<RemoteWebElement> desktopSession;
    private String geonaftPath = "F:\\Geonaft\\3.7.37.8\\644\\Geosteering.Launcher.exe";
    private String winAppDriverPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
    private Runtime runtime = Runtime.getRuntime();
    private Process geonaftProcess;

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {

//        geonaftProcess = runtime.exec(geonaftPath);
//        Thread.sleep(10000);
//        File file = new File(winAppDriverPath);
//        Desktop.getDesktop().open(file);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", "Root");

        desktopSession = new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723"), capabilities);
        desktopSession.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        desktopSession.manage().window().maximize();

    }

    @AfterEach
    public void tearDown() throws IOException {
//        geonaftProcess.destroy();
//        Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
        desktopSession.quit();
    }

    public void restartDesktopSession() throws MalformedURLException {
        desktopSession.quit();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", "Root");
        desktopSession = new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723"), capabilities);
        desktopSession.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
}
