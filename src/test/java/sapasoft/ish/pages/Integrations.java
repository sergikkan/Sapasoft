package sapasoft.ish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Integrations {

    public void open(){
        $(By.xpath("//div/ul/li[5]")).click();
    }

    public void add() {
        $(By.xpath("//button[@title=\"Добавить\"]")).click();
    }

    public void edit() {
        $$(By.xpath("//td/div/button")).first().click();
    }

    public void delete(int n ) {
        $(By.xpath("//tbody/tr["+n+"]/td[1]")).shouldBe(exist);
        String t = $(By.xpath("//tbody/tr["+n+"]/td[1]")).getText();
        $(By.xpath("//tbody/tr["+n+"]/td[3]/div/button[2]")).click();
        confirm();
        $$(By.xpath("//tbody")).findBy(text(t)).shouldNotBe(visible);
    }

    public void save() {
        $(By.xpath("//span[text()=\"Сохранить\"]")).click();
    }

    public void cancel() {
        $(By.xpath("//span[text()=\"Отмена\"]")).click();
    }

    public void fillCodeOfIntegation(String code) {
        $(By.xpath("//textarea[@name=\"code_class\"]")).setValue(code);
    }
    public void fillNameOfIntegration(String name) {
        $(By.xpath("//textarea[@name=\"name\"]")).setValue(name);
    }
    public void fillReceiverURL(String url) {
        $(By.xpath("//textarea[@name=\"receiver_url\"]")).setValue(url);
    }
    public void fillReceiverName(String rname) {
        $(By.xpath("//textarea[@name=\"receiver_name\"]")).setValue(rname).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER );
    }

    public void fillReceiverProtocol(String protocol) {

        $(By.xpath("//ul/li[@data-value=\"EIS\"]")).click();

    }

    public void chooseGroup(String eis) {
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//label[text()=\"Группа\"]/..//input")).click();
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//label[text()=\"Группа\"]/..//input")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void stopReceive(){
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//input[@name=\"income_disable\"]")).click();
    }

    public void stopTransfer(){
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//input[@name=\"outcome_disable\"]")).click();
    }

    public void checkShep2(){
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//input[@name=\"is_shep\"]")).click();
    }

    public void extendedLoging(){
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//input[@name=\"extend_log\"]")).click();
    }

    public void checkTagData(){
        $(By.xpath("//div[@aria-labelledby=\"form-dialog-objects\"]//input[@name=\"with_tag_data\"]")).click();
    }
}
