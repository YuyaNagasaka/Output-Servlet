package model;

public class User {

  private int id;
  private String name;
  private String password;
  private int output_times; 

  public int getId() {return id ;}
  public String getName() {return name;}
  public String getPassword() {return password;}
  public int getOutputTimes() {return output_times;}

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setOutputTimes(int output_times) {
    this.output_times = output_times;
  }
}