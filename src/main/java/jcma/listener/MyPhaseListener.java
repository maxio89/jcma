package jcma.listener;

import jcma.view.LoginView;
import jcma.view.RegistrationView;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 16.10.12
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */


public class MyPhaseListener implements PhaseListener {


    ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
    Object obj = ex.getSessionMap().get("loginView");
    LoginView bean = (LoginView)obj;
    public void afterPhase(PhaseEvent event)
    {
        if (bean != null) {
        if (!bean.getLogged())  {
            HttpServletResponse response = (HttpServletResponse)ex.getResponse();
            try {
                response.sendError(503);//send 503 Unauthorized
            } catch (IOException ex) {
                Logger.getLogger(MyPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }

    public void beforePhase(PhaseEvent event)
    {

    }

    public PhaseId getPhaseId()
    {
        return PhaseId.ANY_PHASE;
    }

}
