package sapasoft.ish;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import sapasoft.ish.pages.Ish;
import sapasoft.ish.testconfigs.Base;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.sleep;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Groups extends Base {

                                        /* РАЗДЕЛ ГРУППЫ  */

    private String code= "newGroup"+System.currentTimeMillis(); // Код группы для создания
    private String newCode= "newGroup"+System.currentTimeMillis(); // Код группы для редактирования
    private String existcode= "_Test_Group_"; // Код группы, которая существует в системе
    private String intcode = "ТестГрупСерик";  // Код группы, которая используется во взаимодействии
    private String deleteGroup ="newGroup1638789556177";  // Код группы, которую нужно удалить
    private String editGroup ="newGroup163";  // Код группы, которую нужно изменить


    // Создание новой группы
    @DisplayName("Добавление новой группы")
    @Test
    public void t1CreateNewGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().fillCodeOfGroup(code);
        ish.groups().save();
        ish.groups().search(code);
        ish.logOut();

    }

    // Проверка невозможности создания группы с имеющимся кодом
    @DisplayName("Проверка невозможности создания группы с одинаковым кодом")
    @Test
    public void t2TryToCreateExistCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().fillCodeOfGroup(existcode);
        ish.groups().save();
        ish.groups().checkGroupExist();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    @DisplayName("Проверка невозможности сохранения группы с одинаковым кодом при редактировании")
    @Test
    public void t3TryEditExistCodeGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().fillCodeOfGroup(existcode);
        ish.groups().save();
        ish.groups().checkGroupExist();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    // Проверка создания пустой формы группы
    @DisplayName("Проверка невозможности создания группы с пустым полем код")
    @Test
    public void t4CreateEmptyFieldCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().add();
        ish.groups().save();
        ish.groups().checkThatFieldIsEmpty();
        ish.groups().cancel();
        ish.logOut();
    }

    // Проверка сохранения пустой формы группы при редактировании
    @DisplayName("Проверка невозможности сохранения группы с пустым полем код при редактировании")
    @Test
    public void t5EditEmptyFieldCode(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().save();
        ish.groups().checkThatFieldIsEmpty();
        ish.groups().cancel();
        confirm();
        ish.logOut();
    }

    // Редактирование группы
    @DisplayName("Редактирование группы")
    @Test
    public void t6EditGroups(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().search(editGroup);
        ish.groups().edit();
        ish.groups().clearFieldGroup();
        ish.groups().fillNewCode(newCode);
        ish.groups().save();
        ish.groups().clearSerchLine();
        ish.groups().search(newCode);
        ish.logOut();
    }

    // Удаление группы

    @Test
    public void t7DeleteGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().search(deleteGroup);
        ish.groups().delete(deleteGroup);
        ish.groups().checkGroupNotExist(deleteGroup);
        ish.logOut();

    }

    // Проверка невозможности удаления группы, которая используется во взаимодействии

    @Test
    public void t8DeleteIntegrationGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().search(intcode);
        ish.groups().delete(intcode);
        ish.groups().checkThatGroupInInteger(intcode);
        ish.logOut();
    }

    //Поиск группы
    @DisplayName("Поиск группы по коду")
    @Test
    public void t9SearchGroup(){
        Ish ish = new Ish();
        ish.logIn(login, password);
        ish.groups().open();
        ish.groups().search(existcode);
        ish.groups().clearSearchField();
        ish.groups().checkGroupNotExist("wrongckjk;dfd;sfkkkds;");
        ish.logOut();

    }


}
