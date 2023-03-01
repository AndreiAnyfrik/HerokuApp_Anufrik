import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
/*Add/Remove Elements - добавить 2 элемента, удалить элемент, проверить количество элементов*/

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        List<WebElement> deleteElementButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteElementButtons.size(), 2, "There not 2 buttons");
        deleteElementButtons.get(0).click();
        //assert deleteElementButtons.get(1).isDisplayed()
        assertTrue(deleteElementButtons.get(1).isDisplayed(), "Delete button is not displayed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        int numberOfElements = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }
}
