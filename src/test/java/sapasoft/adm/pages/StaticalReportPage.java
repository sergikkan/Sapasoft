package sapasoft.adm.pages;

import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Стаитистические отчеты\"")
public class StaticalReportPage {

    public void open(){
        $(By.xpath("//div[@class='antd-pro-components-menu-page-index-items']/a[7]")).click();
        $(By.xpath("//div/h1")).shouldHave(text("Статистические отчеты"));
    }

    public void openUsers(){
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[1]/span[2]")).click();
    }

    public void openRoles(){
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[2]/span[2]")).click();
    }
    public void openRights(){
        $(By.xpath("//div[@class=\"ant-radio-group ant-radio-group-solid\"]/label[3]/span[2]")).click();
    }


}
