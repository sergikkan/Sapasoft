package sapasoft.adm;

import org.junit.Test;
import sapasoft.adm.pages.Adm;
import sapasoft.adm.testconfigs.BaseSetings;

public class UsersManagment extends BaseSetings {

    @Test
    public void t1BlockUser(){
        Adm adm= new Adm();
        adm.logIn(login, password);
        adm.usersManagment().open();
        adm.usersManagment().openUser();
    }

}
