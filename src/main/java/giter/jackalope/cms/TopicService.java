package giter.jackalope.cms;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public abstract class TopicService {

  static final DBCollection TOPICS = DBLayer.topics();

  public static void save(Topic topic) {
    TOPICS.save(topic);
  }

  public static Topic get(String id) {
    return (Topic) TOPICS.findOne(new ObjectId(id));
  }

  public static Topic findByTitle(String title) {
    return (Topic) TOPICS.findOne(new BasicDBObject("title", title));
  }

  public static void delete(String id) {
    TOPICS.remove(new BasicDBObject("_id", new ObjectId(id)));
  }

  public static void update(String id, BasicDBObject o) {
    if (id == null || o == null || o.size() == 0) return;
    TOPICS.update(new BasicDBObject("_id", new ObjectId(id)), o);
  }

}
