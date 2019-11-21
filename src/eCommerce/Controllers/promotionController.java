package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import eCommerce.Strings.ERROR_DATA;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;
import eCommerce.Database.*;

@WebServlet("/promotionController")
public class promotionController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public promotionController()
	{
		super();
	}
	
	public void init()
	{
		try {
			if(Database.getDatabase() == null)
			{
				new Database();
			}
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
}