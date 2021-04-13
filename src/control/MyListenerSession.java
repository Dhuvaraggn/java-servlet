package control;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

/**
 * Application Lifecycle Listener implementation class MyListenerSession
 *
 */
public class MyListenerSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.print("sess created");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session=se.getSession();
        String name= session.getAttribute("username").toString();
        LoginServiceImpl login=LoginServiceImpl.getLoginService();
        try {
			login.setUserDAO(UserDAOImpl.getUserDAOImpl());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        login.updateFlag(name, 0);
        
    	System.out.print("session destroyed");      // TODO Auto-generated method stub
    }
	
}
