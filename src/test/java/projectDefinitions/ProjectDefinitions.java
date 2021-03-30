package projectDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.UnexpectedException;
import java.util.Random;

public class ProjectDefinitions {

    private WebDriver driver;

    @Given("I have entered my {string}")
    public void i_have_entered_my_email(String string) throws UnexpectedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
       // WebElement mailfield = driver.findElement(By.id("email"));
        //mailfield.sendKeys(string);
        sendKeys(driver, By.id("email"),(string));

    }

    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String string)throws UnexpectedException {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
       // WebElement user = driver.findElement(By.id("new_username"));
        //user.sendKeys(String.valueOf(randomInt));
        sendKeys(driver,By.id("new_username"),(String.valueOf(randomInt)));


    }

    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String string) throws UnexpectedException, InterruptedException {
        //WebElement password = driver.findElement(By.id("new_password"));
        //password.sendKeys(string);
        //Thread.sleep(2000);
        sendKeys(driver,By.id("new_password"),(string));

        click(driver,By.id("onetrust-accept-btn-handler"));

    }

    @When("I press sign up")
    public void i_press_sign_up() {
        WebElement signup = driver.findElement(By.cssSelector("#create-account"));
        signup.click();

        click(driver,By.cssSelector("#create-account"));
        driver.quit();
    }

    @Then("the {string} should be on the screen")
    public void the_result_should_be_on_the_screen(String string) {

    }


private void sendKeys(WebDriver driver, By by, String keys) {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
        }
private void click(WebDriver driver, By by) {
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

        }
        }
