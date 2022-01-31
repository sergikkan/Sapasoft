package sapasoft.adm;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.services.PropertyDataReader;
import sapasoft.adm.testconfigs.BaseSetings;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Регистрация сотрудника")
public class RegistrationTest extends BaseSetings {
    //public String currentTestingEnv = System.getProperty("reg");
    //public String IIN = PropertyDataReader.getProperties(currentTestingEnv).getProperty("registration.iin");
    private String date=date1();
    private String iin="900522000608";
    private String wrongIin="900522008396";
    private String existIin="900522000607";

    @Test
    @DisplayName("Регистрация сотрудника")
    public void t1RegistrationUser() {
        Adm adm = new Adm();
        adm.registration();
        adm.registrationUser().fillIIN(iin);
        adm.registrationUser().pressSearch();
        adm.registrationUser().fillIPadress("234.545");
        adm.registrationUser().fillNumnerOfdDocunent();
        adm.registrationUser().chooseDate(date);
        adm.registrationUser().chooseModule("Администрирование и мониторинг");
        adm.registrationUser().uploadFile();
        adm.registrationUser().chooseRights();
        adm.registrationUser().checkThatButtonActive();
        adm.registrationUser().pressCancel();
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Попытка регистрации сотрудника, не зарегистрированного в базе")
    public void t2RegistrationWrongIin() {
        Adm adm = new Adm();
        adm.registration();
        adm.registrationUser().fillIIN(wrongIin);
        adm.registrationUser().pressSearch();
        adm.registrationUser().checkThatUserNotExist();
    }

    @Test
    @DisplayName("Попытка регистрации ранее зарегистрированного сотрудника")
    public void t3RegistrationExistUser() {
        Adm adm = new Adm();
        adm.registration();
        adm.registrationUser().fillIIN(existIin);
        adm.registrationUser().pressSearch();
        adm.registrationUser().checkThatUserExist();
    }

}
