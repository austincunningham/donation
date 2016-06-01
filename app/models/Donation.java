package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Donation extends Model
{
  
  public long amountDonated;
  public String methodDonated;
  
  @ManyToOne
  public User from;

  public Donation(User from, long amountDonated, String methodDonated)
  {
    this.from = from;
    this.amountDonated = amountDonated;
    this.methodDonated = methodDonated;
  }
}