import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        By checkBoxMessageLocator = By.id("message");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(checkBoxMessageLocator, "It's gone!"));
        Assertions.assertThat(isElementPresent(checkbox))
                .isFalse()
                .as("Checkbox should not be visible");
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertThat(input.isEnabled())
                .isFalse()
                .as("Input field should be disabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        By inputMessageLocator = By.xpath("//form[@id='input-example']/p");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(inputMessageLocator, "It's enabled!"));
        Assertions.assertThat(input.isEnabled())
                .isTrue()
                .as("Input field should be enabled");
    }

    private boolean isElementPresent(WebElement checkbox) {
        driver.findElements((By) checkbox);
        return false;
    }
}
