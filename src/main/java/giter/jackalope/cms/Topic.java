package giter.jackalope.cms;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class Topic extends BasicDBObject {

  private static final long serialVersionUID = 1L;

  public Topic() {
  }

  public Topic(String user, String title, String category, String content) {

    setUser(user);
    setTitle(title);
    setCategory(category);
    setContent(content);

    setCreated(System.currentTimeMillis());
    setUpdated(System.currentTimeMillis());

  }

  public void setUser(String user) {
    put("user", user);
  }

  public String getUser() {
    return getString("user");
  }

  public String getTitle() {
    return getString("title");
  }

  public void setTitle(String title) {
    put("title", title);
  }

  public String getContent() {
    return getString("content");
  }

  public void setContent(String content) {
    put("content", content);
  }

  public Long getCreated() {
    return getLong("created");
  }

  public void setCreated(Long created) {
    put("created", created);
  }

  public Date getCrdate() {
    return new Date(getLong("created", 0));
  }

  public Long getUpdated() {
    return getLong("updated");
  }

  public void setUpdated(Long updated) {
    put("updated", updated);
  }

  @SuppressWarnings("unchecked")
  public List<String> getTags() {
    return (List<String>) get("tags");
  }

  public void setTags(List<String> tags) {
    put("tags", tags);
  }

  public String getCategory() {
    return getString("category");
  }

  public void setCategory(String category) {
    put("category", category);
  }

  public ObjectId get_id() {
    return getObjectId("_id");
  }

  public void set_id(String _id) {
    if (_id != null) put("_id", new ObjectId(_id));
  }

  public int getD() {
    return 1;
  }

}
