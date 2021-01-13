package app;

import app.helpers.GifSequenceWriter;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Base {


    protected String expectedDir = ".\\src\\main\\resources\\testScreenshots\\expected\\";
    protected String actualDir = ".\\src\\main\\resources\\testScreenshots\\actual\\";
    protected String diffDir = ".\\src\\main\\resources\\testScreenshots\\markedImages\\";
    protected String resultGifsDir = ".\\src\\main\\resources\\testScreenshots\\gifs\\";
    protected String fileName;
    protected WindowsDriver<RemoteWebElement> driver;
    protected Robot robot;
    protected Actions actions;
    protected GifSequenceWriter gifSequenceWriter;
    protected String clickablePoint = "TextBlock";


    public Base(WindowsDriver<RemoteWebElement> driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public enum appointment {
        ACTUAL,
        EXPECTED
    }

    public String getFileName(RemoteWebElement element) {
        fileName = getClass().getName() + "_" + element.getText();
        return fileName;
    }

    protected Base moveTo(RemoteWebElement element) {
        actions.moveToElement(element).build().perform();
        return this;
    }

    protected Base doubleClick(RemoteWebElement element) {
        actions.doubleClick(element).perform();
        return this;
    }

    protected Base click(RemoteWebElement element) {
        actions.click(element).perform();
        return this;
    }

    protected Base rightClick(RemoteWebElement element) {
        RemoteWebElement target = (RemoteWebElement) element.findElementByClassName(clickablePoint);
        actions.contextClick(target).perform();
        return this;
    }

    protected Base horizontalScroll(RemoteWebElement mainView, RemoteWebElement element) {
        moveTo(mainView);
        String coordinatesCenterMainView = mainView.getAttribute("ClickablePoint");
        String coordinatesCenterElement = element.getAttribute("ClickablePoint");
        Pattern pattern = Pattern.compile("\\-*\\d*$");
        Matcher matcherMainView = pattern.matcher(coordinatesCenterMainView);
        Matcher matcherElement = pattern.matcher(coordinatesCenterElement);
        boolean mainViewFind = matcherMainView.find();
        boolean elementFind = matcherElement.find();
        int mainView_Y = Integer.parseInt(matcherMainView.group());
        int element_Y = Integer.parseInt(matcherElement.group());
        int scrollValue = (element_Y - mainView_Y);
        robot.mouseWheel(scrollValue);
        return this;
    }

    protected Base makeElementScreenshot(RemoteWebElement element, String fileName, appointment appointment) {
        File screen = element.getScreenshotAs(OutputType.FILE);
        if (appointment == Base.appointment.ACTUAL) {
            try {
                FileUtils.copyFile(screen, new File(actualDir + fileName + ".png"));
            } catch (IOException e) {
                System.out.println("ScreenShot is not created");
            }
        } else {
            try {
                FileUtils.copyFile(screen, new File(expectedDir + fileName + ".png"));
            } catch (IOException e) {
                System.out.println("ScreenShot is not created");
            }
        }

        return this;
    }

    protected Base takeDiffImage(String fileName) {
        try {
            Screenshot actualScreenshot = new Screenshot(ImageIO.read(new File(actualDir + fileName + ".png")));
            Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(expectedDir + fileName + ".png")));
            ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
            File diffFile = new File(diffDir + fileName + ".png");
            ImageIO.write(diff.getMarkedImage(), "png", diffFile);
            int diffPoint = diff.getDiffSize();
            Assertions.assertNotEquals(diffPoint, 0);
        } catch (IOException e) {
            System.out.println("File is not created");
        }
        return this;
    }

    protected Base creatGiffFile(String fileName) {
        try {
            BufferedImage first = ImageIO.read(new File(actualDir + fileName + ".png"));
            ImageOutputStream output = new FileImageOutputStream(new File(resultGifsDir + fileName + ".gif"));
            GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
            writer.writeToSequence(first);
            File[] images = new File[]{
                    new File(actualDir + fileName + ".png"),
                    new File(expectedDir + fileName + ".png"),
                    new File(diffDir + fileName + ".png"),
            };
            for (File image : images) {
                BufferedImage next = ImageIO.read(image);
                writer.writeToSequence(next);
            }
            writer.close();
            output.close();
        }catch (Exception e){}
        return this;
    }

    protected Base copyInBuffer(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return this;
    }

    protected Base pastFromBuffer(){
        actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();

        return this;
    }

    protected Base enterClick() {
        actions.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
        return this;
    }

}
