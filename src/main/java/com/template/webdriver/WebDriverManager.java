package com.template.webdriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.qameta.allure.Attachment;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.extension.ShouldMethodExtension;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.template.props.Properties.props;
import static java.util.Collections.singletonList;

public class WebDriverManager {

    private WebDriver driver;

    private Atlas atlas;

    private Map<String, String> headers;

    public static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment
    public byte[] makeScreenshot() {
        String fname = RandomStringUtils.randomAlphanumeric(20);
        Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).withName(fname).save("target/screenshots");
        try {
            return Files.readAllBytes(new File("target/screenshots/" + fname + ".png").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void startWebDriver() {
        String environmentName = props.environment();
        switch (environmentName) {
            case "local": {
                if (props.browserName().equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_settings.popups", 0);
                    prefs.put("safebrowsing.enabled", "false");
                    prefs.put("download.prompt_for_download", "false");
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("--safebrowsing-disable-download-protection");
//                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    driver.manage().window().setSize(new Dimension(props.browserWidth(), props.browserHeight()));
                    break;
                }
                if (props.browserName().equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "tools\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                }
            }
            case "remote": {
                if (props.browserName().equals("chrome")) {
                    try {
                        ChromeOptions capability = new ChromeOptions();
                        Map<String, Object> prefs = new HashMap<>();
                        String downloadDir = Paths.get("target").toAbsolutePath().toString();
                        prefs.put("download.default_directory", downloadDir); // Bypass default download directory in Chrome
                        capability.setExperimentalOption("prefs", prefs);
                        capability.setCapability("idleTimeout", 150);
                        capability.addArguments("--safebrowsing-disable-download-protection");
//                        capability.setCapability("browserVersion", "86");
                        driver = new RemoteWebDriver(new URL(props.remoteWebDriverUrl()), capability);
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        driver.manage().window().setSize(new Dimension(1440, 1024));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                if (props.browserName().equals("firefox")) {
                    try {
                        DesiredCapabilities capability = new DesiredCapabilities();
                        capability.setBrowserName(props.browserName());
                        driver = new RemoteWebDriver(new URL(props.remoteWebDriverUrl()), capability);
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        driver.manage().window().setSize(new Dimension(1440, 1024));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        atlas = new Atlas(new WebDriverConfiguration(driver)).extension(new ShouldMethodExtension()).context(
                new RetryerContext(new DefaultRetryer(5000L, 100L, singletonList(Throwable.class))));
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Atlas getAtlas() {
        return atlas;
    }

}
