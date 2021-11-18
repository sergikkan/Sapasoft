package sapasoft.isez;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SubmissionOfAPurchaseRequestOT {

    @Test
    public void SubmissionOfAPurchaseRequestOT() {
        open("http://dev10.sapasoft.kz/#/ext");
        element(Selectors.byXpath("//span//*[text()='зарегистрироваться']")).click();
        element(Selectors.byXpath("//span[text()='Войти без ЭЦП']")).click();
        element(Selectors.byXpath("//*/label[text()=' Логин ']/../input")).setValue("777777777797_777777777797");
        element(Selectors.byXpath("//*[@type='password']")).setValue("123456");
        element(Selectors.byXpath("//*[@type='submit']")).click();
        element(Selectors.byXpath("//ul[@class=\"menu\"]/div[2]/li/a/span")).click();
        element(Selectors.byXpath("//ul[@class=\"menu\"]/div[2]//ul//span")).click();
        Configuration.holdBrowserOpen = true;
       // sleep(5000);

    }
}
