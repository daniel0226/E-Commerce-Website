package eCommerce.UserData;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import eCommerce.users.WebUser;

public class sessionData{
	
	private static HttpServletRequest req = null;
	private static WebUser s_user = null;
	private static HttpSession session = null;
			
	public sessionData(HttpServletRequest request, WebUser user)
	{
		super();
		System.out.println("Created new session for: " + user.getFullName());
		req = request;
		s_user = user;
		session = req.getSession();
	}

	public static HttpSession createSession()
	{
	    session = req.getSession();
	    session.setAttribute("email", s_user.getEmail());
	    System.out.println("Successfully created new session for: " + s_user.getFullName());
	    return (HttpSession)session;
	}
	public static boolean logout()
	{
		System.out.println("Logging out user: " + s_user.getFullName());
		session = req.getSession();
		if(session != null)
		{
			session.invalidate();
			resetData();
			return true;
		}
		else{
			return false;
		}
		
	}
	public static WebUser getCurrentSessionUser()
	{
		return s_user;
	}
	public static HttpSession getCurrentSession()
	{
		return session;
	}
	public static void resetData()
	{
		req = null;
		s_user = null;
		session = null;
	}
}
