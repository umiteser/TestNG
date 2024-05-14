package Gun04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _04_DataProvider_IkiBoyut {

    @Test(dataProvider = "datalarim")
    public void searchText(String username,String sifre){
        System.out.println(username+" "+sifre);
    }

    @DataProvider
    Object[][] datalarim(){
        Object[][] kullaniciVesifre=
                {
                        {"ümit", "1234"},
                        {"gulcin", "123456"},
                        {"oguz", "123333"},
                        {"umut", "12222"},
                };
        return kullaniciVesifre;
    }

}
