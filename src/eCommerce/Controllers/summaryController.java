package eCommerce.Controllers;

import java.io.IOException;

import eCommerce.Database.*;

@WebServlet("/summaryController")
public class summaryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private authenticatorController authenticator;
	private sessionController sc;

	public void init() {
		authenticator = new authenticatorController();
		if (Database.getDatabase() == null) {
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//if
	}//init()
	
	public summaryController()
	{
		super();
		authenticator = new authenticatorController();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException {
		response.setContentType("html;charset=UTF-8");
		sc = new sessionController();
		String requestType = request.getParameter("type");
		switch (requestType) {
			case "goToHome":
				sc.navigatePage(request, response, "/index.jsp");
				return;
				
		}//switch
	}//doGet
	
	
}//summaryController