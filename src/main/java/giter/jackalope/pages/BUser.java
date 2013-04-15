package giter.jackalope.pages;

import giter.jackalope.model.Block;

public abstract class BUser {

  public static Block login() {
    return Block.of(Block.HD, "user-login");
  }
}
