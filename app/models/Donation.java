package models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.Logger;
import play.db.jpa.Model;

@Entity
public class Donation extends Model
{
  
  public long amountDonated;
  public String methodDonated;
  
  @ManyToOne
  public User from;
  public Date createdOn;

  public Donation(User from, long amountDonated, String methodDonated)
  {
    this.from = from;
    this.amountDonated = amountDonated;
    this.methodDonated = methodDonated;
    Date createOn= new Date();
	createdOn = new Timestamp(createOn.getTime());
	Logger.info("createdOn "+createdOn);	
  }
  

}