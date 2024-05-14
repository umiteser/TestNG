package Gun06;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_WishList_POM extends BaseDriver {

    @Test
    public void addToWishList(){
        _01_PlaceOrderElements poe=new _01_PlaceOrderElements();
        _02_WishList_Elements wle=new _02_WishList_Elements();

        poe.searchBox.sendKeys("ipod" + Keys.ENTER);

        int randomSecim= Tools.randomGenerator(wle.wishButton.size());
        String wishTeamText=wle.productName.get(randomSecim).getText();

        wle.wishButton.get(randomSecim).click();
        wait.until(ExpectedConditions.elementToBeClickable(wle.wishListLink));
        wle.wishListLink.click();

        boolean bulundu=Tools.ListContainsString(wle.wishnameList, wishTeamText);
        Assert.assertTrue(bulundu, "Wish Listte eleman bulunamadı");
    }

}
