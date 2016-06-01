package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Accounts extends Controller {

	 public static void Signup()
	  {
	    render();
	  }

	  public static void Login()
	  {
	    render();
	  }

	  public static void Logout()
	  {
		session.clear();
	    index();
	  }

	  public static void index()
	  {
	    render();
	  }
	  public static void register(boolean usCitizen ,String firstName, String lastName, String email, String password)
	  {
	    Logger.info(usCitizen +" "+firstName + " " + lastName + " " + email + " " + password);
        if(usCitizen)
        {
	      User user = new User (usCitizen, firstName, lastName, email, password);
	      user.save();

	      index();
        }
        else
        {
        	Logger.info("Not a US Citizen ,usCitizen set to : "+usCitizen);
        	Welcome.index();
        }
	  }
	  public static void authenticate(String email, String password)
	  {
		  Logger.info("Attempting to authenticate with " + email + ":" + password);
		  User user = User.findByEmail(email);
		    if ((user != null) && (user.checkPassword(password) == true))
		    {
		      Logger.info("Authentication successful");
		      session.put("logged_in_userid", user.id);
		      DonationCtrl.index();
		    }
		    else
		    {
		      Logger.info("Authentication failed");
		      Login();  
		    }
	  }
	  public static User getCurrentUser()
	  {
		  String userId = session.get("logged_in_userid");
		  if (userId == null)
		  {
			  return null;
		  }
		  User logged_in_user = User.findById(Long.parseLong(userId));
		  Logger.info("Logged in User: "+logged_in_user.firstName);
		  return logged_in_user;
	  }
	  
}
