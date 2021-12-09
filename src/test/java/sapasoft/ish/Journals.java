//package sapasoft.ish;
//
//import com.codeborne.selenide.Configuration;
//import sapasoft.ish.pages.Ish;
//import sapasoft.ish.testconfigs.Base;
//import org.junit.Test;
//
//public class Journals extends Base {
//
//    private String title= "ФНО 220";
//    private String integrationClass= "ISNA_FS_FILE";
//    private String corelation_ID= "";
//
//
//    @Test
//    public  void t1SwitchMode(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.journals().open();
//        ish.journals().extendedMode();
//        ish.journals().normalMode();
//        ish.logOut();
//    }
//
//    @Test
//    public  void t2OpenMessage(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.journals().open();
//        ish.journals().openMessage();
//        ish.journals().closeMessage();
//        ish.logOut();
//    }
//
//    @Test
//    public void t3SearchMessage(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.journals().open();
//        ish.journals().SearchMessage();
//        Configuration.holdBrowserOpen = true;
//    }
//}
