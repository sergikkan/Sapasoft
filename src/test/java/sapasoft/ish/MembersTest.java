//package sapasoft.ish;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.junit4.DisplayName;
//import sapasoft.ish.pages.Ish;
//import sapasoft.ish.testconfigs.Base;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import static com.codeborne.selenide.Selenide.confirm;
//import static com.codeborne.selenide.Selenide.sleep;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MembersTest extends Base {
//
//    /* Участники */
//
//    String memberCode="code"+System.currentTimeMillis(); // создание  кода участника
//    String membername="name"+System.currentTimeMillis(); // создание наименования участника
//    String memberUsername="username"+System.currentTimeMillis(); // создание имени пользователя участника
//    String editMemberCode="MemberFoEditingTest"; // код для редактирования
//    String editMembername="MemberFoEditingTest"; // имя для редактирования
//    String editMemberUsername="MemberFoEditingTest"; // имя пользователя для редактирования
//    String deleteMemberName="MemberForDeleteTest"; // имя пользователя для удаления
//    String memberCodeNew="newcode"+System.currentTimeMillis(); // создание нового кода участника
//    String membernameNew="newname"+System.currentTimeMillis(); // создание нового наименования участника
//    String memberUsernameNew="newusername"+System.currentTimeMillis(); // создание новго имени пользователя участника
//    String memberPassword="Code23432!"; // Значение пароль состоит из букв верхнего и нижнего регистра, цифр и специальных символов
//    String memberGroup="ТестГрупСерик"; // Группа используется во взаимодействии
//    String existMember = "SFN12";  // Существующий участник для проверки поля поиска
//
//    // Создание нового участника
//    //
//    //Тест создает, участник сразу появляется, вручную нет
//    @DisplayName("Добавление нового участника")
//    @Test
//    public void t1СreateNewMember(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().add();
//        ish.members().fillCode(memberCode);
//        ish.members().fillName(membername);
//        ish.members().fillUsername(memberUsername);
//        ish.members().fillPasswordOfMember(memberPassword);
//        ish.members().chooseGroup(memberGroup);
//        ish.members().save();
//        ish.members().searchMember(membername);
//        ish.members().delete();
//        ish.members().clearSearchField();
//        ish.members().checkMemberNotExist(membername);
//        ish.logOut();
//    }
//
//    /*Данные после редактирования не всегда обновляются, нужна перезагрузка */
//    @DisplayName("Редактирование участника")
//    @Test
//    public void t2editMember(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().searchMember(editMembername);
//        ish.members().edit();
//        ish.members().fillCode(memberCodeNew);
//        ish.members().fillName(membernameNew);
//        ish.members().fillUsername(memberUsernameNew);
//        ish.members().chooseGroup(memberGroup);
//        ish.members().save();
//        ish.members().clearSearchField();
//        ish.members().searchMember(membernameNew);
//        ish.members().edit();
//        ish.members().fillCode(editMemberCode);
//        ish.members().fillName(editMembername);
//        ish.members().fillUsername(editMemberUsername);
//        ish.members().chooseGroup(memberGroup);
//        ish.members().save();
//        ish.members().clearSearchField();
//        ish.members().searchMember(editMembername);
//        ish.logOut();
//    }
//
//
//    @DisplayName("Удаление участника")
//    @Test
//    public void t31DeleteMember(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().searchMember(deleteMemberName);
//        ish.members().delete();
//        ish.members().clearSearchField();
//        ish.members().checkMemberNotExist(deleteMemberName);
//        ish.members().clearSearchField();
//        ish.members().add();
//        ish.members().fillCode(memberCode);
//        ish.members().fillName(deleteMemberName);
//        ish.members().fillUsername(memberUsername);
//        ish.members().fillPasswordOfMember(memberPassword);
//        ish.members().chooseGroup(memberGroup);
//        ish.members().save();
//        ish.members().searchMember(deleteMemberName);
//        ish.logOut();
//    }
//
//    // Проверка создания пустой формы +++
//    @DisplayName("Проверка создания пустой формы")
//    @Test
//    public void t4CreateMemberRequiredFields(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().add();
//        ish.members().save();
//        ish.members().checkRequiredFields();
//        ish.members().cancel();
//        ish.logOut();
//    }
//
//    //Проверка сохранения пустой формы при редактировании++++++
//    @DisplayName("Проверка сохранения пустой формы при редактировании")
//    @Test
//    public void t5EditMemberRequiredFields(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().edit();
//        ish.members().clearFieldCode();
//        ish.members().clearFieldName();
//        ish.members().clearFieldUsername();
//        ish.members().clearfieldGroup();
//        ish.members().save();
//        ish.members().checkRequiredFieldsEdit();
//        ish.members().cancel();
//        confirm();
//        ish.logOut();
//
//    }
//
//    @DisplayName("Проверка уникальности кода, наименования и имени пользователя")
//    @Test
//    public void t6CheckUniqueNamesCreate(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().add();
//        ish.members().fillCode(editMemberCode);
//        ish.members().fillName(membername);
//        ish.members().fillUsername(memberUsername);
//        ish.members().fillPasswordOfMember(memberPassword);
//        ish.members().chooseGroup(memberGroup);
//        ish.members().save();
//        ish.members().checkUniqueCode();
//        ish.members().fillCode(memberCode);
//        ish.members().fillName(editMembername);
//        ish.members().save();
//        ish.members().checkUniqueName();
//        ish.members().fillName(membername);
//        ish.members().fillUsername(editMemberUsername);
//        ish.members().save();
//        ish.members().checkUniqueUsername();
//        ish.members().cancel();
//        confirm();
//        ish.logOut();
//
//    }
//
//    @DisplayName("Поиск участника")
//    @Test
//    public void t7SearchMember(){
//        Ish ish = new Ish();
//        ish.logIn(login, password);
//        ish.members().open();
//        ish.members().searchMemberNotExist("wrongmember343434");
//        ish.members().clearSearchField();
//        ish.members().searchMember(existMember);
//        ish.logOut();
//    }
//}
