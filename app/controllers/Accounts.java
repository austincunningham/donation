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
	    index();
	  }

	  public static void index()
	  {
	    render();
	  }
	  public static void register(String firstName, String lastName, String email, String password)
	  {
	    Logger.info(firstName + " " + lastName + " " + email + " " + password);

	    User user = new User (firstName, lastName, email, password);
	    user.save();

	    index();
	  }
	  public static void authenticate(String email, String password)
	  {
		  Logger.info("Attempting to authenticate with " + email + ":" + password);
		  Home.index();
	  }
	  
}