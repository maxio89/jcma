package jcma.view;

import jcma.UserDAO;
import jcma.data.UserListProducer;
import jcma.model.User;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 15.10.12
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */

@SessionScoped
@ManagedBean
public class LoginView implements Serializable {

    @Inject
    private UserDAO userDAO;


    private String password;
    private String userName;
    private String buttonText = "login";
    private int cnt = 0;
    private boolean logged = false;
    private String include = "login.xhtml";
    private String response = "Welcome Unknown!";
    @ManagedProperty(value="#{registrationView}")
    private RegistrationView reg;

    private String filterUserName = "";
    private String filterName = "e";
    private String filterLastName;
    private int filterGreater = 0;
    private int filterLess = 50;
    private String filterGender;
    List<String> genders = new ArrayList();
     @Inject
     private UserListProducer ulp;
    private List<User> users;


    public List<User> getUsers() {

        users = ulp.getUsers();
        return users;
    }
    // --------------------- GETTER / SETTER METHODS ---------------------
//    public String getResponse() {
//        return response;
//    }
//
//    public void setResponse(String response) {
//        this.response = response;
//    }


    public List<String> getGenders() {

        genders.add("male");
        genders.add("female");
        return genders;
    }

    public String getFilterGender() {
        return filterGender;
    }

    public void setFilterGender(String filterGender) {
        this.filterGender = filterGender;
    }

    public int getFilterLess() {
        return filterLess;
    }

    public void setFilterLess(int filterLess) {
        this.filterLess = filterLess;
    }

    public int getFilterGreater() {
        return filterGreater;
    }

    public void setFilterGreater(int filterGreater) {
        this.filterGreater = filterGreater;
    }

    public String getFilterLastName() {
        return filterLastName;
    }

    public void setFilterLastName(String filterLastName) {
        this.filterLastName = filterLastName;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterUserName() {
        return filterUserName;
    }

    public void setFilterUserName(String filterUserName) {
        this.filterUserName = filterUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // -------------------------- OTHER METHODS --------------------------

    public void setFilter() {

        //UserListProducer ulp = new UserListProducer();
        //ulp.retrieveAllMembersOrderedByName();
        //users = ulp.getUsers();
        //System.out.println("$$$$$$$$$$$" + filterUserName);
        //System.out.println("$$$$$$$$$$$" + FacesContext.getCurrentInstance().getExternalContext().toString());
        //System.out.println("$$$$$$$$$$$" + this.toString());
    }

    public void login() {

        try {
            userDAO.addMembers();
        }
        catch (Exception e) {
            System.out.println("##################" + e);
        }

        if (!logged) {


            if (userName.equals("admin") && password.equals("admin")) {
                buttonText = "logout";
                include = "admin.xhtml";
                response = "Welcome " + userName + "!";
                logged = true;
            } else if (userName.equals("user") && password.equals("user")) {
                buttonText = "logout";
                include = "user.xhtml";
                response = "Welcome " + userName + "!";
                logged = true;
            }
            else {
                response = "Wrong username or password!!!";
            }

        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            //response = "Logout!";
            logged = false;
        }

    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }


    public void setInclude(String include) {
        this.include = include;
    }

    public String getInclude() {
        return include;
    }

    public void foo(String value) {

        include = value;

    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setReg(RegistrationView reg) {
        this.reg = reg;
    }
}
