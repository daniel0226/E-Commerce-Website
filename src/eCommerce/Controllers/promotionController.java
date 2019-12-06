package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.email;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;

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
		Database.validateDatabase(Database.getDatabase());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String add = request.getParameter("add");
		String update = request.getParameter("update");
		String delete = request.getParameter("delete");
		
		if(add != null && !add.equals(""))
		{
			addPromotion(request, response);
		}else if(update != null && !update.equals(""))
		{
			updatePromotion(request, response, update);
		}else if(delete != null && !delete.equals(""))
		{
			deletePromotion(request, response, delete);
		}else
		{
			return;
		}
		Database.resetDatabase();
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		request.setAttribute("js", generateHTMLController.navigateDiv("proBtn","Promotions"));
		loadHtml.setAdminPage(request, response, sessionData.getCurrentSessionUser());
	}
	public void addPromotion(HttpServletRequest request, HttpServletResponse response)
	{
		String date = request.getParameter("date");
		Double discount = Double.parseDouble(request.getParameter("discount"));
		if(!Validator.dateIsPassedToday(date))
		{
			request.setAttribute("addMsg","<p style=\"text-align:center; color: red;\">Expiration Date must be greater than today.</p>");
			return;
		}
		if(!Validator.promotionIsUnique(discount))
		{
			request.setAttribute("addMsg","<p style=\"text-align:center; color: red;\">Discount already exists in system.</p>");
			return;
		}
		EmailController sendEmail = new EmailController();
		sendEmail.updateUsers(email.newPromotion, email.promotionMsg);
		request.setAttribute("addMsg", "<p style=\"text-align:center; color: white;\">Successfully added Promotion</p>");
		System.out.println(date);
		Database.addPromotion(date, discount);
	}
	public void updatePromotion(HttpServletRequest request, HttpServletResponse response, String id)
	{
		String date = request.getParameter("date");
		Double discount = Double.parseDouble(request.getParameter("discount"));
		if(!Validator.dateIsPassedToday(date))
		{
			request.setAttribute("errorMsg","<p style=\"text-align:center; color: red;\">Expiration Date must be greater than today.</p>");
			return;
		}
		if(!Validator.promotionIsUnique(discount))
		{
			request.setAttribute("errorMsg","<p style=\"text-align:center; color: red;\">Discount already exists in system.</p>");
			return;
		}
		EmailController sendEmail = new EmailController();
		sendEmail.updateUsers(email.newPromotion, email.promotionMsg);
		Database.updatePromotion(date, discount, id);
		request.setAttribute("errorMsg", "<p style=\"text-align:center; color: white;\">Successfully updated Promotion</p>");
	}
	public void deletePromotion(HttpServletRequest request, HttpServletResponse response, String id)
	{
		request.setAttribute("errorMsg", "<p style=\"text-align:center; color: white;\">Successfully deleted Promotion</p>");
		Database.deletePromotion(id);
	}
	
}