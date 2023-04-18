package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the username Field Element and send username on username field
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        //Find the Login btn Element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify the ‘Welcome’ text is displayed
        String expectedText = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found",expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
