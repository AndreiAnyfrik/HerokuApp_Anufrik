import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

        /*Checkboxes - проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
        Проверить, что второй чекбокс checked, сделать unchecked, проверить, что он unchecked*/

public class CheckBoxesTest extends BaseTest {
    @Test
    public void checkBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(checkboxes.size(), 2, "There not 2 checkboxes");
        WebElement firstCheckBox = checkboxes.get(0);
        WebElement secondCheckBox = checkboxes.get(1);
        assertFalse(firstCheckBox.isSelected(), "FirstCheckBox is selected ");
        firstCheckBox.click();
        assertTrue(firstCheckBox.isSelected(), "FirstCheckBox is not selected ");
        assertTrue(secondCheckBox.isSelected(), "SecondCheckBox box is not selected");
        secondCheckBox.click();
        assertFalse(secondCheckBox.isSelected(), "SecondCheckBox box is selected ");
    }

}
