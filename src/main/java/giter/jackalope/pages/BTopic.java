package giter.jackalope.pages;

import giter.jackalope.cms.Topic;
import giter.jackalope.model.Block;

import java.util.List;

public class BTopic {

  public static Block main(Topic topic) {
    return Block.of(Block.MAIN, "topic-main").param("topic", topic);
  }

  public static Block list(List<Topic> topic) {
    return Block.of(Block.MAIN, "topic-list").param("topics", topic);
  }

  public static Block breadcrumbs(Topic topic) {
    return Block.of(Block.MAIN, "topic-breadcrumbs").param("topic", topic);
  }

  public static Block creation() {
    return Block.of(Block.MAIN, "topic-creation");
  }
}
