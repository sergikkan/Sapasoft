package sapasoft.ish;

import com.codeborne.selenide.Configuration;
import sapasoft.ish.pages.Ish;
import sapasoft.ish.testconfigs.Base;
import org.junit.Test;

public class Integrations extends Base {


    @Test
    public void t17CreateNewIntegration(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.integrations().open();
        ish.integrations().add();
        //ish.integrations().fillCodeOfIntegation("codeofintegraton");
        // ish.integrations().fillNameOfIntegration("nameofintegraton");
        // ish.integrations().fillReceiverURL("https://t.t");
        ish.integrations().fillReceiverName("https://t.t");
        ish.integrations().fillReceiverProtocol("EIS");
//        ish.integrations().save();
//        ish.groups().checkGroupWasCreated(code);
//        ish.logOut();
        Configuration.holdBrowserOpen = true;
    }
}
