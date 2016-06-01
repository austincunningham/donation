package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

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
//      String prog = getPrecentTargetArchieved();
//      String progress =prog + "%";
//      Logger.info("Donation controller : % target achieved "+progress);
//      render(user,progress);
        render(user, 100);
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
  
//  public static String getPrecentTargetArchieved()
//  {
//    List<Donation> allDonations = Donation.findAll();
//    long total = 0;
//    for(Donation donation : allDonations)
//    {
//      total +=donation.recieved;
//    }
//    long target = getDonationTarget();
//    long percentachieved = (total * 100/target);
//    String progress = String.valueOf(percentachieved);
//    return progress;
//  }
   
  public static void renderReport()
  {
    List<Donation> donations = Donation.findAll();
    render(donations);
  }
  
}