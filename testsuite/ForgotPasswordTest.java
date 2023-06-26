package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    //set up base url
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //click on the ‘Forgot your password’ link
     driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']")).click();
     //Verify the text ‘Reset Password’
        WebElement reSetPasswordText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
        String text = reSetPasswordText.getText();
        System.out.println(text);
        Assert.assertEquals("Reset Password",text);
    }
    @After
    public void close(){
        closeBrowser();
    }

}
