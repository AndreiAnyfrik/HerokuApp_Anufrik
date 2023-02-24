import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
       /*Взять все элементы дроп-дауна и проверить их наличие.
         Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран*/

public class DropDownTest extends BaseTest {
    @Test
    public void dropDownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = dropDown.getOptions();
        WebElement firstOption = options.get(0);
        assertEquals(firstOption.getText(), "Please select an option", "The option is invalid");
        assertFalse(firstOption.isEnabled(), "The option should be disabled");
        assertTrue(firstOption.isSelected(), "The option should be selected");


        WebElement secondOption = options.get(1);
        assertEquals(secondOption.getText(), "Option 1", "The option is invalid");
        WebElement thirdOption = options.get(2);
        assertEquals(thirdOption.getText(), "Option 2", "The option is invalid");

        dropDown.selectByVisibleText("Option 1");
        assertTrue(secondOption.isSelected(), "The option 1 should be selected");
        dropDown.selectByVisibleText("Option 2");
        assertTrue(thirdOption.isSelected(), "The option 2 should be selected");
    }
}
