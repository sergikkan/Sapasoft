package sapasoft.ish.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Journals {

    public void open(){
        $(By.xpath("//div/ul/li[6]")).click();
    }

    public void searchButton(){
        $(byText("Поиск")).click();
    }

    public void reset(){
        $(byText("Сбросить")).click();
    }

    public void downloadRequest(){
        $(byText("Скачать запрос")).click();
    }

    public void downloadResponse(){
        $(byText("Скачать ответ")).click();
    }

    public void closeMessage(){
        $(byText("Закрыть")).click();
    }

    public void  extendedMode(){
        $$(By.xpath("//tbody/tr[1]/td")).shouldHave(CollectionCondition.size(8));
        $(By.xpath("//div[text()=\"Фильтр журнала запросов\"]/following::div[1]")).click();
        $$(By.xpath("//tbody/tr[1]/td")).shouldHave(CollectionCondition.size(14));
    }

    public void  normalMode(){
        $$(By.xpath("//tbody/tr[1]/td")).shouldHave(CollectionCondition.size(14));
        $(By.xpath("//div[text()=\"Фильтр журнала запросов\"]/following::div[1]")).click();
        $$(By.xpath("//tbody/tr[1]/td")).shouldHave(CollectionCondition.size(8));
    }

    public void openMessage(int n){
        $(By.xpath("//tbody/tr["+n+"]/td[4]")).click();
        $(By.xpath("//form//h2")).shouldHave(Condition.text("Журнал сообщений участников взаимодействий"));
    }

    public void openMessage(){
        $(By.xpath("//tbody/tr[1]/td[4]")).click();
        $(By.xpath("//form/div/h2")).shouldHave(Condition.text("Журнал сообщений участников взаимодействий"));
    }

    public void SearchMessage(){
        $(By.xpath("//label[text()=\"Класс взаимодействия\"]/..")).click();
    }





}
