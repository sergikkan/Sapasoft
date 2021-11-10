package sapasoft.adm.pages;

public class Adm {
    public void logIn(String login, String password){
        new Auth().logIn(login, password);
    }

    public void logOut(){
        new Auth().logOut();
    }

    public RightsManagment rightsManagment(){
        RightsManagment rightsManagment = new RightsManagment();
        return rightsManagment;
    }

    public RolesManagment rolesManagment(){
        RolesManagment rolesManagment = new RolesManagment();
        return rolesManagment;
    }

//
    public RolesGroupsManagmentPage rolesGroupsManagment() {
        RolesGroupsManagmentPage rolesGroupsMangmentPage =new RolesGroupsManagmentPage();
        return rolesGroupsMangmentPage;
    }

    public UsersManagmentPage usersManagment(){
        UsersManagmentPage usersManagmentPage = new UsersManagmentPage();
        return usersManagmentPage;
    }

    public ApplicationManagementPage applicationManagement(){
        ApplicationManagementPage applicationManagementPage = new ApplicationManagementPage();
        return applicationManagementPage;
    }
}
