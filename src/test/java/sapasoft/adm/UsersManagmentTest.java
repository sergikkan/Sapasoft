package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Раздел \"Управление пользователями\"")
public class UsersManagmentTest extends BaseSetings {

    @Test
    public void t1Search(){
        Adm adm= new Adm();
        adm.logIn(login, password);
        adm.usersManagment().open();
        adm.usersManagment().searchUser("Аудитор");
        adm.usersManagment().extendedSearchUser();

        Configuration.holdBrowserOpen = true;
    }

}
