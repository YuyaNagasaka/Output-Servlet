package model;

public class Output {

  private int id;
  private int user_id;
  private String title;
  private String description;
  private String keyword;
  
  public int getId() {return id;}
  public int getUserId() {return user_id;}
  public String getTitle() {return title;}
  public String getDescription() {return description;}
  public String getKeyword() {return keyword;}  
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setUserId(int user_id) {
    this.user_id = user_id;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
}