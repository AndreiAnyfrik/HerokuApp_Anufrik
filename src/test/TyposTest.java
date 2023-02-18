import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*Typos - Проверить соответствие параграфа орфографии
        Локатор By.tagName(“p”)*/

public class TyposTest extends BaseTest {

    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.tagName("p"));
        Assert.assertEquals(typos.getText(), "This example demonstrates a typo being introduced. It does it " +
                        "randomly on each page load.\n" + "Sometimes you'll see a typo, other times you won't.",
                "Mistake in the world won,t ");
    }
}
