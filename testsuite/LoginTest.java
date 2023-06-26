package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //set up base url
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        // Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
       //Verify the text “Secure Area”
        String expectedMessage = "Secure Area";
        String actualMessage = driver.findElement(By.xpath("//div[@class='example']//h2[text()=' Secure Area']")).getText();

        WebElement secureAreaText = driver.findElement(By.xpath("//div[@class='example']//h2[text()=' Secure Area']"));
        String text = secureAreaText.getText();
        System.out.println(text);
        Assert.assertEquals("Secure Area",text);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Verify the error message “Your username is invalid!”
        WebElement userInvalid = driver.findElement(By.xpath("//div[@class='flash error']"));
        String text = userInvalid.getText();
        System.out.println(text);
        Assert.assertEquals("Your username is invalid!" +
                                    "                          " +
                "×",text);
    }
@Test
public void verifyThePasswordErrorMessage(){
    //Enter “tomsmith” username
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
    //Enter “SuperSecretPassword” password
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
    //Click on ‘LOGIN’ button
    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
    //Verify the error message “Your password is invalid!”
    WebElement passwordInvalid = driver.findElement(By.xpath("//div[@id='flash-messages']"));
    String text = passwordInvalid.getText();
    System.out.println(text);
    Assert.assertEquals("\n" +
            "            Your password is invalid!\n" +
            "            ×",text);

}

    @After
    public void close(){
        closeBrowser();
    }
}
