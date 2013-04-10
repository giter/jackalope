package giter.jackalope.model;

import java.util.HashMap;

public class Attributes extends HashMap<String,Object> {

  private static final long serialVersionUID = 1L;

  public Attributes(String id){
    put("id",id);
  }

  public Attributes attr(String key,Object val){
    put(key,val);
    return this;
  }
}
