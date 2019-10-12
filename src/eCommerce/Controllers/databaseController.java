package eCommerce.Controllers;

import eCommerce.users.Users;

public class databaseController {

	public void addUserToDatabase(Users user)
	{
		System.out.println(user.getFullName() + " added to database.");
	}
}
