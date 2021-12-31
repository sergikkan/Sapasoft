package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление правами\"")
public class RightsMangmentTest extends BaseSetings {



    /*Тестовые данные*/

    private String module = "АРМ ОГД"; //Название подсистемы/модуля при создании
    private String code = "new" + System.currentTimeMillis(); //Код права при создании
    private String rusName = "Право" + str();  //Наименование на русском и казахском
    private String engName = "right" + RandomStringUtils.randomAlphabetic(5); //Наименование на латинице при создании
    private String newRusName = "Право" + str();  //Наименование на русском и казахском при редактировании
    private String newEngName = "right" + RandomStringUtils.randomAlphabetic(5); //Наименование на латинице
    private String searchStatus = "Неактивна"; //Значение статуса в расширенном поиске
    private String searchModule = "Кабинет налогоплательщика"; //Значение Модуля в расширенном поиске
    private String existCode = "666"; //Существующий код для проверки уникальности при создании
    private String existRusName = "Тестовое право шесть"; //Существующее имя для проверки уникальности при создании
    private String existEngName = "Testovoe pravo west"; //Существующее имя для проверки уникальности при создании
    private String deactivationName = "Право для деактивации и активации ТЕСТ";
    private String editName = "Право для редактирования Тест";


    @Test
    @DisplayName("Создание нового права")
    public void t1CreateNewRight() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().createNewRight();
        adm.rightsManagment().chooseModule(module);
        adm.rightsManagment().fillCode(code);
        adm.rightsManagment().fillNames(rusName, engName);
        adm.rightsManagment().synchronizeKNP();
        adm.rightsManagment().create();
        adm.rightsManagment().checkRightWasCreated(rusName);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;

    }


    @Test
    @DisplayName("Деактивация и активация права")
    public void t2DeactivationActivationRight() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().searchRight(deactivationName);
        adm.rightsManagment().checkSearchStatus("Активна");
        adm.rightsManagment().openRight();
        adm.rightsManagment().deactivateRight();
        adm.rightsManagment().clearSearchField(); //Временный метод, пока не работает сброс
        adm.rightsManagment().searchRight(deactivationName);
        adm.rightsManagment().checkSearchStatus("Неактивна");
        adm.rightsManagment().openRight();
        adm.rightsManagment().activateRight();
        adm.rightsManagment().clearSearchField();
        adm.rightsManagment().searchRight(deactivationName);
        adm.rightsManagment().checkSearchStatus("Активна");
        adm.logOut();

    }


    @Test
    @DisplayName("Поиск права")
    public void t3SearchRight() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().searchRight(existRusName); // Вводим в поисковую строку текст, система проверяет, что в таблице в первой строке есть право с таким наименованием или кодом
        adm.logOut();
    }


    @Test
    @DisplayName("Расширенный поиск права")
    public void t4ExtendedSearchRight() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().extendedSearch();
        adm.rightsManagment().chooseSearchModule(searchModule);
        adm.rightsManagment().fillSearchStatus(searchStatus);
        adm.rightsManagment().applySearch();
        adm.rightsManagment().checkSearchModule(searchModule);
        adm.rightsManagment().checkSearchStatus(searchStatus);
        adm.logOut();
    }

    @Test
    @DisplayName("Редактирование права")
    public void t5EditRight() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().searchRight(editName);
        adm.rightsManagment().checkSearchStatus("Активна");
        adm.rightsManagment().openRight();
        adm.rightsManagment().editRight();
        adm.rightsManagment().fillNames(newRusName, newEngName);
        adm.rightsManagment().editRightApply();
        adm.rightsManagment().clearSearchField();
        adm.rightsManagment().searchRight(newRusName);
        adm.rightsManagment().openRight();
        adm.rightsManagment().editRight();
        adm.rightsManagment().fillNames(editName, newEngName);
        adm.rightsManagment().editRightApply();
        adm.rightsManagment().clearSearchField();
        adm.rightsManagment().searchRight(editName);
        adm.logOut();
    }

    @Test
    @DisplayName("Проверка уникальных полей")
    public void t6CheckUniqueFields() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.rightsManagment().open();
        adm.rightsManagment().createNewRight();
        adm.rightsManagment().chooseModule("Кабинет налогоплательщика");
        adm.rightsManagment().fillCode(existCode);
        adm.rightsManagment().fillNames(rusName, engName);
        adm.rightsManagment().create();
        adm.rightsManagment().checkThatCodeExist();
        adm.rightsManagment().fillCode(code);
        adm.rightsManagment().fillNames(existRusName, existEngName);
        adm.rightsManagment().create();
        adm.rightsManagment().checkThatNamesExist();
        adm.rightsManagment().cancel();
        adm.logOut();
    }
}
