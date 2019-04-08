package Json;

public class UserBean {
  private int userId;
  private String userName;
  private String password;
  private String email;
  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  @Override
  public String toString() {
    return "UserBean [userId=" + userId + ", userName=" + userName
      + ", password=" + password + ", email=" + email + "]";
  }
  public UserBean(int userId, String userName, String password, String email) {
    super();
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.email = email;
  }
  public UserBean() {
    super();
  }


}

