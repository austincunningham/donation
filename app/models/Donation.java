package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Donation extends Model
{
  User user;
  long amountDonated;
  String methodDonated;

  public Donation(User user, long amountDonated, String methodDonated)
  {
    this.user = user;
    this.amountDonated = amountDonated;
    this.methodDonated = methodDonated;
  }
}