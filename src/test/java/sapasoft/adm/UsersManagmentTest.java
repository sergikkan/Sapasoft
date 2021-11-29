//package sapasoft.adm;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.Step;
//import io.qameta.allure.junit4.DisplayName;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import sapasoft.adm.pages.Adm;
//import sapasoft.adm.testconfigs.BaseSetings;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@DisplayName("Раздел \"Управление пользователями\"")
//public class UsersManagmentTest extends BaseSetings {
//
//
//    private String userName= "Тестов";
//    private String blockingDate=  date();
//
//    @DisplayName("Поиск пользователя")
//    @Test
//    public void t1Search(){
//        Adm adm= new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().searchUser(userName);
//        adm.logOut();
//    }
//
//    @DisplayName("Расширеный поиск пользователя")
//    @Test
//    public void t2ExtendedSearch(){
//        Adm adm= new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().fillSearchStatus("Активна");
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchStatus("Активна");
//        //Configuration.holdBrowserOpen = true;
//        adm.logOut();
//    }
//
//    @DisplayName("Блокировка пользователя")
//    @Test
//    public void t3BlockUser(){
//        Adm adm= new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().fillSearchStatus("Активна");
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchStatus("Активна");
//        adm.usersManagment().openUser();
//        adm.usersManagment().blockUser();
//        adm.usersManagment().reasonOfBlockingUser();
//        adm.usersManagment().chooseDateFrom(blockingDate);
//        adm.usersManagment().blockUserConfirm();
//        adm.usersManagment().checkThatUserBlocked();
//        adm.usersManagment().closeUserPage();
//        //Configuration.holdBrowserOpen = true;
//        adm.logOut();
//    }
//
//    @DisplayName("Разблокировка пользователя")
//    @Test
//    public void t4UnblockUser(){
//        Adm adm= new Adm();
//        adm.logIn(login, password);
//        adm.usersManagment().open();
//        adm.usersManagment().extendedSearchUser();
//        adm.usersManagment().fillSearchStatus("Заблокирована");
//        adm.usersManagment().applySearch();
//        adm.usersManagment().checkSearchStatus("Заблокирована");
//        adm.usersManagment().openUser();
//        adm.usersManagment().unblockUser();
//        adm.usersManagment().unblockUserConfirm();
//        adm.usersManagment().checkThatUserUnblocked();
//        adm.usersManagment().closeUserPage();
//        //Configuration.holdBrowserOpen = true;
//        adm.logOut();
//    }
//
//
//
//}
