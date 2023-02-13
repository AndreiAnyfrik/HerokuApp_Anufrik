/*Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения,
        используя Keys.ARROW_UP  И Keys.ARROW_DOWN*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest{
    @Test
    public void addUP(){
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement typos = driver.findElement(By.tagName("input"));
        typos.sendKeys(Keys.UP);
        Assert.assertEquals(typos.getAttribute("value"),"1","The number is not 1");
    }
    @Test
    public void addDown() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement typos = driver.findElement(By.tagName("input"));
        typos.sendKeys(Keys.UP);
        typos.sendKeys(Keys.UP);
        typos.sendKeys(Keys.DOWN);
        Assert.assertEquals(typos.getAttribute("value"),"1","The number is not 1");
    }
}
