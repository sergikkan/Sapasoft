package sapasoft.ish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Integrations {

    public void open(){
        $(By.xpath("//div/ul/li[1]")).click();
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
        $(By.xpath("//textarea[@name=\"receiver_name\"]")).setValue(rname);
    }

    public void fillReceiverProtocol(String protocol) {
        $(By.xpath("//textarea[@name=\"receiver_name\"]")).sendKeys(Keys.TAB);
        $(By.xpath("//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot FormikMaterialUIAutocomplete-inputRoot-52 MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd MuiInputBase-marginDense MuiOutlinedInput-marginDense\"]")).click();
        $(By.xpath("//label[text() = \"Протокол получателя\"]")).click();
        $(By.xpath("//ul/li[text()="+protocol+"]")).click();

    }
}
