package pl.com.it_crowd.tutorials;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean(name = "Login")
public class Bean implements Serializable {
// ------------------------------ FIELDS ------------------------------

    private String response;
    private String password;
    private String username;
    private String buttonText = "login";
    private int cnt = 0;
    private boolean session = false;

// --------------------- GETTER / SETTER METHODS ---------------------
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

// -------------------------- OTHER METHODS --------------------------
    public void checkMe() {


        if (!session) {
          
            if (username.equals("user") && password.equals("hasl0")) {
                buttonText = "logout";
                cnt++;
                response = "Welcome " + username + "!";
                session = true;
            } else {
                response = "Wrong username or password!!!";
            }
            
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            response = "Logout!";
            session = false;
        }

        /*
         FacesContext facesContext = FacesContext.getCurrentInstance();



         //HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

         String foo = (String) session.getAttribute("username");






         if (foo == null) {
         //session.setAttribute("UserName", request.getParameter("UserName"));%>
         response = "zalogowano:" + text;
         session = (HttpSession) facesContext.getExternalContext().getSession(false);

         session.setAttribute("username", text);

         } else {
         response = "zalogowano2:" + text;
         //session = request.getSession(true);

         }



         FacesContext facesContext = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
         Enumeration e = session.getAttributeNames();
         while (e.hasMoreElements()) {
         String attr = (String) e.nextElement();
         System.err.println("      attr  = " + attr);
         Object value = session.getValue(attr);
         System.err.println("      value = " + value);
         }*/
    }
}
