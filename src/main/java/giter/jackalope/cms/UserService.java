package giter.jackalope.cms;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public abstract class UserService {

  static final DBCollection USERS = DBLayer.users();

  public static User get(String id) {
    return (User) USERS.findOne(new BasicDBObject("_id", id));
  }

  public static User login(String id, String password) {
    User u = get(id);
    return u != null && u.getPassword().equals(password) ? u : null;
  }

  public static void save(User user) {
    USERS.save(user);
  }

}
