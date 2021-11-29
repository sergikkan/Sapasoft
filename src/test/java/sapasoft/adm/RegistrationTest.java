package sapasoft.adm;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.services.PropertyDataReader;
import sapasoft.adm.testconfigs.BaseSetings;

@DisplayName("Регистрация сотрудника")
public class RegistrationTest extends BaseSetings {
    //public String currentTestingEnv = System.getProperty("reg");
    //public String IIN = PropertyDataReader.getProperties(currentTestingEnv).getProperty("registration.iin");
    private String date=date1();
    private String iin="900522000608";

    //@Test
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
    }

}
