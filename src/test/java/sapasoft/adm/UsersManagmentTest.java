package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление пользователями\"")
public class UsersManagmentTest extends BaseSetings {


    private String userName= "Сергей7";
    private String blockingDate=  date();
    private String existLogin = "6001_testpost7";
    private String reasonOfBlocking = "Отпуск";
    private String searchModule = "Администрирование и мониторинг";
    private String usersDepartment = "0101";


    @DisplayName("Поиск пользователя")
    @Test
    public void t1Search(){
        Adm adm= new Adm();
        adm.logIn(login, password);
        adm.usersManagment().open();
        adm.usersManagment().searchUser(userName);
        adm.logOut();
    }

    @DisplayName("Расширеный поиск пользователя")
    @Test
    public void t2ExtendedSearch(){
        Adm adm= new Adm();
        adm.logIn(login, password);
        adm.usersManagment().open();
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().fillSearchStatus("Активна");
        adm.usersManagment().applySearch();
        adm.usersManagment().checkSearchStatus("Активна");
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().resetSearch();
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().fillLogin(existLogin);
        adm.usersManagment().applySearch();
        adm.usersManagment().checkLogin(existLogin);
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().resetSearch();
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().chooseSearchModule(searchModule);
        adm.usersManagment().applySearch();
        adm.usersManagment().openUser();
        adm.usersManagment().checksearchModule(searchModule);
        adm.usersManagment().closeUserPage();
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().resetSearch();
        adm.usersManagment().extendedSearchUser();
        adm.usersManagment().chooseSearchDepartment(usersDepartment);
        adm.usersManagment().applySearch();
        adm.usersManagment().checkSearchDepartment(usersDepartment);
        adm.logOut();
        //Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Блокировка пользователя")
    @Test
    public void t3BlockUnblockUser(){
        Adm adm= new Adm();
        adm.logIn(login, password);
        adm.usersManagment().open();
        adm.usersManagment().searchUser(userName);
        adm.usersManagment().checkSearchStatus("Активна");
        adm.usersManagment().openUser();
        adm.usersManagment().blockUser();
        adm.usersManagment().reasonOfBlockingUser(reasonOfBlocking);
        adm.usersManagment().chooseDateFrom(blockingDate);
        adm.usersManagment().blockUserConfirm();
        adm.usersManagment().checkThatUserBlocked();
        adm.usersManagment().closeUserPage();
        adm.usersManagment().checkSearchStatus("Заблокирована");
        adm.usersManagment().openUser();
        adm.usersManagment().unblockUser();
        adm.usersManagment().unblockUserConfirm();
        adm.usersManagment().checkThatUserUnblocked();
        adm.usersManagment().closeUserPage();
        adm.usersManagment().checkSearchStatus("Активна");
        adm.logOut();
    }



}
