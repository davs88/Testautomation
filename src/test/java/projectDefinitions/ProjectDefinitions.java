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


import java.util.Random;


public class ProjectDefinitions {

    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(100000);
    private WebDriver driver;


    @Given("I have entered my {string}")
    public void i_have_entered_my_email(String mail) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

        if (mail.equals("mail")) {
            sendKeys(By.id("email"), mail + randomInt + "@sklm.se");
        } else if (mail.equals("")) {
            sendKeys(By.id("email"), (""));
        }

    }

    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String username) {


        if (username.equals("newusername")) {
            sendKeys(By.id("new_username"), ("xavier" + randomInt));

        } else if (username.equals("Longname")) {
            sendKeys(By.id("new_username"), (username.repeat(20)));
        } else if (username.equals("Davuserexists")) {
            sendKeys(By.id("new_username"), username);
        } else if (username.equals("noemail")) {
            sendKeys(By.id("new_username"), username + randomInt);
        }
    }


    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String password) {

        sendKeys(By.id("new_password"), (password));

        click(By.id("onetrust-accept-btn-handler"));

    }

    @When("I press sign up")
    public void i_press_sign_up() {


        click(By.cssSelector("#create-account"));

    }

    @Then("the {string} should be on the screen for {string}")
    public void the_result_should_be_on_the_screen(String result, String name) {
        if (name.equals("username")) {
            WebElement verify = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
            assertEquals(result, verify.getText());
        } else if (name.equals("Longname")) {
            WebElement check = driver.findElement(By.className("invalid-error"));
            assertEquals(result, check.getText());
        } else if (name.equals("Davuserexists")) {
            WebElement verify = driver.findElement(By.className("invalid-error"));
            assertEquals(result, verify.getText());
        } else if (name.equals("username2")) {
            WebElement verify = driver.findElement(By.className("invalid-error"));
            assertEquals(result, verify.getText());
        }
        driver.quit();

    }


    private void sendKeys(By by, String keys) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    private void click(By by) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }
}
