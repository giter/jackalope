package giter.jackalope.pages;

import giter.jackalope.model.Block;

public abstract class BIndex {

  public static Block main() {
    return Block.of(Block.HD, "index-main");
  }
}
