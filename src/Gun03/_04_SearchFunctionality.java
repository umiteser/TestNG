package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_SearchFunctionality extends BaseDriver {
/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
 */
    @Test
    @Parameters("searchText")
    public void SearchFunction(String arananKelime){

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(1);

        WebElement search= driver.findElement(By.name("search"));
        search.sendKeys(arananKelime+ Keys.ENTER);
        Tools.Bekle(1);

        List<WebElement> captions=driver.findElements(By.cssSelector("[class='caption']>h4"));

        for (WebElement e:captions){
            
            Assert.assertTrue(e.getText().toLowerCase().contains(arananKelime.toLowerCase()), "Aranan kelime bulunamadı!");

            System.out.println("e.getText() = " + e.getText());
        }
    }
}
