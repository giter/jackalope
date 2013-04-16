package giter.jackalope.pages;

import giter.jackalope.cms.Topic;
import giter.jackalope.model.Block;

public class BTopic {

  public static Block main(Topic topic) {
    return Block.of(Block.MAIN, "topic-main").param("topic", topic);
  }

  public static Block creation() {
    return Block.of(Block.MAIN, "topic-creation");
  }
}
