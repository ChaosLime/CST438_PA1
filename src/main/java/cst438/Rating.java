package cst438;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Rating {

  @Id
  @GeneratedValue
  private long id;
  
  @NotNull
  @Size(min = 3, max = 25)
  private String title;
  
  @NotNull
  @Min(value = 1)
  @Max(value = 5)
  private int rating;
  
  @NotNull
  @Size(min=3, max=25)
  private String name;
  
  @NotNull
  private String date;
   
  public Rating() {
    title = null;
    name = null;
    date = null;
  }
  
  public Rating(long id, String title, int rating, String name, String date) {
    super();
    this.id = id;
    this.title = title;
    this.rating = rating;
    this.name = name;
    this.date = date;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    date = new Date().toString();
    this.date = date;
  }  
}