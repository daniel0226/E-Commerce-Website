package eCommerce.UserData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eCommerce.users.WebUser;

public class sessionData{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HttpServletRequest req = null;
	private static WebUser _user = null;
	private static HttpSession session = null;
	
	public sessionData(HttpServletRequest request, WebUser user)
	{
		super();
		System.out.println("Created new session for: " + user.getFullName());
		req = request;
		_user = user;
		session = req.getSession();
	}

	public static HttpSession createSession()
	{
	    session = req.getSession();
	    session.setAttribute("email", _user.getEmail());
	    System.out.println("Successfully created new session for: " + _user.getFullName());
	    return (HttpSession)session;
	}
	public static boolean logout()
	{
		System.out.println("Logging out user: " + _user.getFullName());
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
		return _user;
	}
	public static HttpSession getCurrentSession()
	{
		return session;
	}
	public static void resetData()
	{
		req = null;
		_user = null;
		session = null;
	}
}
