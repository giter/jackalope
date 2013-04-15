package giter.jackalope.cms;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public abstract class DBLayer {

  private static final String HOST = "127.0.0.1";
  private static final String DB = "data";

  static final DB db;

  static Map<String, DBCollection> colls = new TreeMap<>();

  static {

    try {
      db = new MongoClient(HOST).getDB(DB);
    } catch (UnknownHostException e) {
      throw new RuntimeException();
    }

    add("topics", Topic.class);
    add("users", User.class);

    indexes();
  }

  static void add(String name, Class<? extends DBObject> clazz) {
    colls.put(name, db.getCollection(name));
    colls.get(name).setObjectClass(clazz);
  }

  public static void indexes() {
    System.err.print("Running MongoFactory.indexes()...");
  }

  public static DBCollection topics() {
    return colls.get("topics");
  }

  public static DBCollection users() {
    return colls.get("users");
  }
}
