package sapasoft.adm.testconfigs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.FileDownloadMode.PROXY;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseSetings {
    protected String login= "admin";
    protected String password= "I$NA43mp";

    //public String base = System.getProperty("base");
    //public String url = PropertyDataReader.getProperties(base).getProperty("main.url");
    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    {

        Configuration.baseUrl = "https://arm.sapasoft.kz";
        Configuration.timeout= 8000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        //Configuration.startMaximized = true;
       // Configuration.proxyEnabled = true;
        //Configuration.fileDownload = PROXY;
    }

    /*Генерация случайной строки русских букв*/
    protected static Random sRandom = new Random();
    protected static char[] sAlphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    protected static int sLength = sAlphabet.length;

    protected static char getRandomChar() {
        return sAlphabet[sRandom.nextInt(sLength)];
    }

    protected static String str() {
        String str = "";
        for (int i=0; i<5; i++) {
            str= str + getRandomChar();
        }
        return str;
    }

    protected static String date(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    protected static String date1(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }


}
