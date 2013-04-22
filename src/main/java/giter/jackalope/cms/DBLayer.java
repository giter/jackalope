package giter.jackalope.cms;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;

import com.mongodb.BasicDBObject;
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

    add("topics", Topic.class, new BasicDBObject("created", -1), new BasicDBObject("category", 1).append("created", -1));
    add("users", User.class);

  }

  static void add(String name, Class<? extends DBObject> clazz, DBObject... indexes) {

    colls.put(name, db.getCollection(name));
    colls.get(name).setObjectClass(clazz);

    for (DBObject index : indexes) {

      System.err.println(String.format("EnsureIndex: %s(%s)...", name, index.toString()));

      colls.get(name).ensureIndex(index);
    }
  }

  public static DBCollection topics() {
    return colls.get("topics");
  }

  public static DBCollection users() {
    return colls.get("users");
  }
}
