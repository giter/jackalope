package giter.jackalope.pages;

import giter.jackalope.model.Block;

public abstract class BCommons {

  public static Block hd() {
    return Block.of("hd", "common-hd");
  }

  public static Block ft() {
    return Block.of("ft", "common-ft");
  }
}
