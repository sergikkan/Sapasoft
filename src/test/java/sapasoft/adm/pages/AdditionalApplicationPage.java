package sapasoft.adm.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdditionalApplicationPage {
    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[6]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Подача дополнительной заявки на предоставление роли и прав"));
    }
}
