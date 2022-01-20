package sapasoft.adm;


import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел Статистические отчеты, отчет по ролям")
public class StatisticReportRolesTest extends BaseSetings{

        /*Данные для отчета пользователям*/

        String whoRegister = "naik";
        String status = "Удалена";
        String registerDateFrom = "31.12.2021";
        String registerDateTo = "20.01.2022";
        String module = "Лицевые счета";
        String rolesCode = "LS_06";
        String validityDateFrom="31.05.2021";
        String validityDateTo="24.06.2021";

        @Test
        @DisplayName("Открыть отчет по ролям")
        public void t1RolesReport(){
            Adm adm =new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.logOut();
            //Configuration.holdBrowserOpen = true;
        }


        @Test
        @DisplayName("Отчет по ролям, отфильтрованный по полю кем зарегистрирован")
        public void t2whoRegisterSearch() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().fillWhoRegister(whoRegister);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkWhoRegister(whoRegister);
            adm.logOut();
        }

        @Test// ПОКА НЕ РАБОТАЕТ
        @DisplayName("Отчет по ролям, отфильтрованный по статусу")
        public void t3StatusSearch() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().chooseStatus(status);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkStatus(status);
            adm.logOut();
        }

        @Test
        @DisplayName("Отчет по ролям, отфильтрованный по дате регистрации")
        public void t4checkDateSearch() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().chooseRegisterDates(registerDateFrom, registerDateTo);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkRegisterDates(registerDateFrom, registerDateTo);
            adm.logOut();
        }

        @Test
        @DisplayName("Отчет по ролям, отфильтрованный по полю Подсистема/модуль")
        public void t5checkModuleSearch() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().chooseSearchModule(module);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkModule(module);
            adm.logOut();
        }

        @Test
        @DisplayName("Отчет по ролям, отфильтрованный по Коду роли")
        public void t6checkRolesCode() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().chooseSearchModule(module);
            adm.statisticRolesReport().chooseRolesCode(rolesCode);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkRolesCode(rolesCode);
            adm.logOut();
        }

        @Test // НЕ РАБОТАЕТ
        @DisplayName("Отчет по ролям, отфильтрованный по периоду действия")
        public void t7checkValidityDates() {
            Adm adm = new Adm();
            adm.logIn(login, password);
            adm.statisticRolesReport().open();
            adm.statisticRolesReport().openRoles();
            adm.statisticRolesReport().chooseValidityDates(validityDateFrom, validityDateTo);
            adm.statisticRolesReport().formReportButton();
            adm.statisticRolesReport().checkValidityDates(validityDateFrom, validityDateTo);
            adm.logOut();
            //Configuration.holdBrowserOpen = true;
        }

}
