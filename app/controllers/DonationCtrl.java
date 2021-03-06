package controllers;

import play.*;
import play.mvc.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONObject;

import models.*;


public class DonationCtrl extends Controller
{
  public static void index()
  {
    User user = Accounts.getCurrentUser();
    if (user == null)
    {
      Logger.info("Donation class : Unable to getCurrentuser");
      Accounts.Login();
    }
    else 
    {
      String prog = getPrecentTargetArchieved();
      String progress = prog + "%";
      Logger.info("Donation controller : % target achieved "+progress);
      render(user, progress);
    }
  }
  public static void donate(long amountDonated, String methodDonated)
  {
    Logger.info("ammount donated "+ amountDonated+ " " +"method donated "+methodDonated);
    User user = Accounts.getCurrentUser();
    if (user == null)
    {
      Logger.info("Donation class : Unable to getCurrentuser");
      Accounts.Login();
    }
    else
    {
      addDonation(user, amountDonated, methodDonated);
      JSONObject obj = new JSONObject();
      obj.put("progress", getPrecentTargetArchieved());
      renderJSON(obj);
    }
    index();
  }
  private static void addDonation(User user, long amountDonated, String methodDonated)
  {
    Donation bal = new Donation(user, amountDonated, methodDonated);
    bal.save();
  }

  private static long getDonationTarget()
  {
    return 20000;
  }
  
  public static String getPrecentTargetArchieved()
  {
    List<Donation> allDonations = Donation.findAll();
    long total = 0;
    for(Donation donation : allDonations)
    {
      total += donation.amountDonated;
    }
    long target = getDonationTarget();
    long percentachieved = (total * 100/target);
    String progress = String.valueOf(percentachieved);
    return progress;
  }
   
  public static void reports()
  {
    List<Donation> donations = Donation.findAll();
    render(donations);
  }
}