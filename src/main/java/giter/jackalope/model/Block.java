package giter.jackalope.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Block {

  public static final String HD = "hd";
  public static final String HEAD = "head";
  public static final String MAIN = "main";
  public static final String ASIDE = "aside";
  public static final String FOOT = "foot";
  public static final String FT = "ft";

  private static final Random r = new Random();

  private String uid;
  private String id;
  private String position;

  private Map<String, Object> params = new HashMap<>();

  public static Block of(String position, String id) {
    return new Block(position, id);
  }

  /**
   * @param position
   *          HEAD or MAIN or ASIDE or FOOT
   * @param id
   *          Id of block
   */
  public Block(String position, String id) {
    this.position = position;
    this.id = id;
    uid = position + "-" + id + "-" + r.nextInt();
  }

  public String getId() {
    return id;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public Block param(String key, Object val) {
    params.put(key, val);
    return this;
  }

  public String getPosition() {
    return position;
  }

  public String getUid() {
    return uid;
  }

}
