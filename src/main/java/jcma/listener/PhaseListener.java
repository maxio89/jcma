package jcma.listener;

import jcma.view.RegistrationView;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 16.10.12
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */


public class PhaseListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started");
        RegistrationView reg = (RegistrationView) FacesContext.getCurrentInstance().
                getExternalContext().getApplicationMap().get("registrationView");

        try {
            //reg.addMembers();
        }
        catch (Exception e)   {
            System.out.println(e);
        }
    }

}
