package giter.jackalope.cms;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class Topic extends BasicDBObject {

  private static final long serialVersionUID = 1L;

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
    put("_id", new ObjectId(_id));
  }

}
