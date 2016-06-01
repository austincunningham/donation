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
        	Home.index();
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
		      Home.index();
		    }
		    else
		    {
		      Logger.info("Authentication failed");
		      Login();  
		    }
	  }
	  
}
