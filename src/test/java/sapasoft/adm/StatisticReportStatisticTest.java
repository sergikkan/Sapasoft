package sapasoft.adm;

import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел Статистические отчеты, Статистичский отчет")
public class StatisticReportStatisticTest extends BaseTest {

    String userLogin = "kgd_rib";
    String userName = "Генадий";
    String userSurname = "Старовойтов";
    String userMiddlename = "Александрович";
    String ipAdress = "12322333";
    String dateFrom = "13.01.2022";
    String dateTo = "14.01.2022";
    String subdivision = "Управление анализа и статистики";
    String position = "Главный эксперт";
    String module = "Отчетность";
    String ruleCode = "OTCH_VIEW_TAX_FORMS_JOURNAL_BY_AREA";
    //String userType = "Аудитор";
    String department = "Комитет государственных доходов Министерства финансов Республики Казахстан";

    @Test
    @DisplayName("Открыть статистический отчет")
    public void t1OpenStatisticReport() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по учетной записи")
    public void t2UserLoginSearch() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().fillUserlogin(userLogin);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkUserLogin(userLogin);
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по ФИО")
    public void t3NameSearch() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().fillName(userName);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkName(userName);
        adm.statisticReportStatistic().resetButton();
        adm.statisticReportStatistic().fillName(userSurname);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkSurname(userSurname);
        adm.statisticReportStatistic().resetButton();
        adm.statisticReportStatistic().fillName(userMiddlename);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkMiddlename(userMiddlename);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Статистистический отчет отфильтрованный по полю IP адрес")
    public void t4ipAdressSearch() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().fillIPAdress(ipAdress);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkIPAdress(ipAdress);
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по дате входа")
    public void t5checkDateSearch() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().chooseDates(dateFrom, dateTo);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkDates(dateFrom, dateTo);
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по полю Код права")
    public void t6checkRulesCode() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().chooseSearchModule(module);
        adm.statisticReportStatistic().chooseRulesCode(ruleCode);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkRulesCode(ruleCode);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по полю Орган государственных доходов")
    public void t7checkDepartment() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().chooseSearchDepartment(department);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkSearchDepartment(department);
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по подразделению")
    public void t8checkSubdivision() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().chooseSearchDepartment(department);
        adm.statisticReportStatistic().chooseSubdivision(subdivision);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkSubdivision(subdivision);
        adm.logOut();
    }

    @Test
    @DisplayName("Статистистический отчет, отфильтрованный по должности")
    public void t9checkPosition() {
        Adm adm = new Adm();
        adm.logIn(LOGIN, PASSWORD);
        adm.statisticReportStatistic().open();
        adm.statisticReportStatistic().openReport();
        adm.statisticReportStatistic().chooseSearchDepartment(department);
        adm.statisticReportStatistic().chooseSubdivision(subdivision);
        adm.statisticReportStatistic().choosePosition(position);
        adm.statisticReportStatistic().formReportButton();
        adm.statisticReportStatistic().checkPosition(position);
        adm.logOut();
    }
}
