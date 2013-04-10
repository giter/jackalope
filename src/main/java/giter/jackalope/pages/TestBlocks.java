package giter.jackalope.pages;

import giter.jackalope.model.Block;

public abstract class TestBlocks {

  public static Block main() {
    return new Block(Block.HD, "test-main");
  }
}
