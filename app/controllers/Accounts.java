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
}
