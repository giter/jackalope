package giter.jackalope.cms;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public abstract class DBLayer {

  private static final Class<Topic> TOPIC_CLASS = Topic.class;
  private static final String HOST = "127.0.0.1";
  private static final String DB = "data";
  private static final String TOPIC_COLL = "topic";

  static final DB db;
  static final DBCollection coll;

  static {

    try {
      db = new MongoClient(HOST).getDB(DB);
    } catch (UnknownHostException e) {
      throw new RuntimeException();
    }

    coll = db.getCollection(TOPIC_COLL);
    coll.setObjectClass(TOPIC_CLASS);

    indexes();
  }

  public static void indexes() {
    System.err.print("Running MongoFactory.indexes()...");
  }

  public static DBCollection topic() {
    return coll;
  }
}
