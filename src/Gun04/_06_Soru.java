package Gun04;

import Utility.BaseDriverParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
 * Bir önceki taskı PARAMETERDRIVER ile yapınız
 * sonrasında farklı tarayıcılar ile çalıştırınız. (crossbrowser)
 * sonrasında paralel çalıştırınız.(parallel)
 */
public class _06_Soru extends BaseDriverParameters {

    @Test(dataProvider = "getData")
    @Parameters("searchText")
    public void searchFunction(String arananKelime) {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(arananKelime + Keys.ENTER);

        List<WebElement> captions = driver.findElements(By.cssSelector("[class='caption']> h4> a"));

        for (WebElement e : captions) {
            System.out.println("e.getText() = " + e.getText());
            Assert.assertTrue(e.getText().toLowerCase().contains
                    (arananKelime.toLowerCase()), "Arana kelime bulunmadı");
        }

    }

    @DataProvider
    Object[] getData() {
        Object[] aranacaklar = {"mac", "ipod", "samsung"};

        return aranacaklar;
    }
}