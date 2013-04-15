package giter.jackalope.cms;

import com.mongodb.BasicDBObject;

public class User extends BasicDBObject {

  private static final long serialVersionUID = 1L;

  public User() {
  }

  public User(String name, String password) {
    setName(name);
    setPassword(password);
  }

  public String getName() {
    return getString("_id");
  }

  public void setName(String name) {
    put("_id", name);
  }

  public String getPassword() {
    return getString("password");
  }

  public void setPassword(String password) {
    put("password", password);
  }
}
