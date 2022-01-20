package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел Статистические отчеты, отчет по правам")
public class StatisticRulesReportTest extends BaseSetings {

    String whoRegister = "naik";
    String status = "Активна";
    String dateFrom = "18.10.2021";
    String dateTo = "20.10.2021";
    String module = "Лицевые счета";
    String rulesCode = "LS_06";

    @Test
    @DisplayName("Открыть отчет по правам")
    public void t1openRightsReport() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.logOut();
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Отчет по правам, отфильтрованный по полю кем зарегистрирован")
    public void t2whoRegisterSearch() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.statisticRulesReport().fillWhoRegister(whoRegister);
        adm.statisticRulesReport().formReportButton();
        adm.statisticRulesReport().checkWhoRegister(whoRegister);
        adm.logOut();

    }

    @Test // ОШИБКИ ПРИ ВЫБОРЕ СТАТУСА
    @DisplayName("Отчет по правам, отфильтрованный по статусу")
    public void t3StatusSearch() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.statisticRulesReport().chooseStatus(status);
        adm.statisticRulesReport().formReportButton();
        adm.statisticRulesReport().checkStatus(status);
        adm.logOut();
    }

    @Test
    @DisplayName("Отчет по правам, отфильтрованный по дате регистрации")
    public void t4checkDateSearch() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.statisticRulesReport().chooseDates(dateFrom, dateTo);
        adm.statisticRulesReport().formReportButton();
        adm.statisticRulesReport().checkDates(dateFrom, dateTo);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Отчет по правам, отфильтрованный по полю Подсистема/модуль")
    public void t5checkModuleSearch() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.statisticRulesReport().chooseSearchModule(module);
        adm.statisticRulesReport().formReportButton();
        adm.logOut();
    }

    @Test
    @DisplayName("Отчет по правам, отфильтрованный по Коду права")
    public void t6checkRulesCode() {
        Adm adm = new Adm();
        adm.logIn(login, password);
        adm.statisticRulesReport().open();
        adm.statisticRulesReport().openRules();
        adm.statisticRulesReport().chooseSearchModule(module);
        adm.statisticRulesReport().chooseRulesCode(rulesCode);
        adm.statisticRulesReport().formReportButton();
        adm.statisticRulesReport().checkRulesCode(rulesCode);
        adm.logOut();
    }
}
