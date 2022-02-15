package sapasoft.adm;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BaseTest {
    static final String LOGIN = "admin";
    static final String PASSWORD = "I$NA43mp";

    /**
     * Настройка для Allure Report
     */
    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    /** Закрываем WebDriver после каждого теста*/
    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Генерация случайной строки русских букв
     */
    static Random sRandom = new Random();
    static char[] sAlphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    static int sLength = sAlphabet.length;

    static char getRandomChar() {
        return sAlphabet[sRandom.nextInt(sLength)];
    }

    static String str() {
        String str = "";
        for (int i = 0; i < 5; i++) {
            str = str + getRandomChar();
        }
        return str;
    }

    /**
     * Возвращает дату в формате dd.MM.yyyy
     */
     static String date() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Возвращает дату в формате yyyy-MM-dd
     */
     static String date1() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
