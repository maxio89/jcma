package jcma;

import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 15.10.12
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginView {

    private String password;
    private String userName;
    private String buttonText = "login";
    private int cnt = 0;
    private boolean session = false;


    // --------------------- GETTER / SETTER METHODS ---------------------
//    public String getResponse() {
//        return response;
//    }
//
//    public void setResponse(String response) {
//        this.response = response;
//    }

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
    public void checkMe() {


        if (!session) {

            if (userName.equals("user") && password.equals("hasl0")) {
                buttonText = "logout";
                cnt++;
                //response = "Welcome " + username + "!";
                session = true;
            } else {
                //response = "Wrong username or password!!!";
            }

        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            //response = "Logout!";
            session = false;
        }

    }
}
