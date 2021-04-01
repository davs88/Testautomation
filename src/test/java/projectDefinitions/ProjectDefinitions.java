package projectDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.UnexpectedException;
import java.util.Random;


public class ProjectDefinitions {

    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(100000);
    private WebDriver driver;


    @Given("I have entered my {string}")
    public void i_have_entered_my_email(String mail) throws UnexpectedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

        if (mail.equals("mail")) {
            sendKeys(driver, By.id("email"), mail + randomInt + "@sklm.se");
        } else if (mail.equals("")) {
            sendKeys(driver, By.id("email"), (""));
        }

    }

    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String username) throws UnexpectedException {


        if (username.equals("username")) {
            sendKeys(driver, By.id("new_username"), ("xavier" + randomInt));

        } else if (username.equals("Longname")) {
            sendKeys(driver, By.id("new_username"), (String.valueOf(username.repeat(20))));
        } else if (username.equals("Dav88999")) {
            sendKeys(driver, By.id("new_username"), username);
        } else if (username.equals("username2")) {
            sendKeys(driver, By.id("new_username"), username + randomInt);
        }
    }


    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String string) throws UnexpectedException, InterruptedException {

        sendKeys(driver, By.id("new_password"), (string));

        click(driver, By.id("onetrust-accept-btn-handler"));

    }

    @When("I press sign up")
    public void i_press_sign_up() {


        click(driver, By.cssSelector("#create-account"));

    }

    @Then("the {string} should be on the screen for {string}")
    public void the_result_should_be_on_the_screen(String string, String string2) {
        if (string2.equals("username")) {
            WebElement verify = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
            assertEquals(string, verify.getText());
        } else if (string2.equals("Longname")) {
            WebElement check = driver.findElement(By.className("invalid-error"));
            assertEquals(string, check.getText());
        } else if (string2.equals("Dav8899")) {
            WebElement verify = driver.findElement(By.className("invalid-error"));
            assertEquals(string, verify.getText());
        } else if (string2.equals("username2")) {
            WebElement verify = driver.findElement(By.className("invalid-error"));
            assertEquals(string, verify.getText());
        }
        driver.quit();

    }


    private void sendKeys(WebDriver driver, By by, String keys) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    private void click(WebDriver driver, By by) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }
}
