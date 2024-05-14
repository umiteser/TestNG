package Gun06;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
public class _02_WishList extends BaseDriver {

    @Test
    public void addToWishList() {

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod" + Keys.ENTER);

        //urunlerin wish butonlari
        List<WebElement> wishButtons = driver.findElements(By.cssSelector("[data-original-title='Add to Wish List']"));

        //urununlerin basliklari
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='caption']/h4"));

        //element sayisina random sayi alindi.
        int randomSecim = Tools.randomGenerator(wishButtons.size());

        //random daki urunun adi alindi.
        String wishItemText = productName.get(randomSecim).getText();

        System.out.println("wishItemText = " + wishItemText); //kontrol etmek icin

        //ilgili random urun tiklandi
        wishButtons.get(randomSecim).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("wish list")));
        //urunun bulundugu wishlist linki tiklaniyor
        WebElement wishListLink = driver.findElement(By.linkText("wish list"));
        wishListLink.click(); //wishliste gidildi.

        //wish listesindeki isimler alindi.
        List<WebElement> wishnameList = driver.findElements(By.cssSelector("[class='text-left']"));

        //aradigimiz urun listede var mi yok mu?
        boolean bulundu = false;
        for (WebElement e : wishnameList)
        {
            if (e.getText().toLowerCase().equals(wishItemText.toLowerCase()))
                bulundu=true;
        }
        Assert.assertTrue(bulundu, "WishListe eklenen urun listede bulunamadi");

    }
}
