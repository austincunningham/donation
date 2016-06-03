package models;

import java.sql.Timestamp;
import java.text.DateFormat;
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
  //public Date createdOn;
  public String formatDate;

  @ManyToOne
  public User from;
  
  public Donation(User from, long amountDonated, String methodDonated)
  {
    this.from = from;
    this.amountDonated = amountDonated;
    this.methodDonated = methodDonated;
    Date createOn= new Date();
    formatDate = dateFormatter();
//	createdOn = new Timestamp(createOn.getTime());
//		
//	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//	formatDate = df.format(createdOn);
//	Logger.info("createdOn "+createdOn+" formatDate "+formatDate);
  }
  public String dateFormatter()
  {
	Date createOn= new Date();
	createOn = new Timestamp(createOn.getTime());
	DateFormat df = new SimpleDateFormat("E dd/MM/yy - KK:mm a");
	Logger.info("createdOn "+createOn+" formatDate "+df.format(createOn));
	return df.format(createOn);
	
  }
  

}