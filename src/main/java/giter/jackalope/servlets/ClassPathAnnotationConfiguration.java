package giter.jackalope.servlets;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.AnnotationParser;
import org.eclipse.jetty.annotations.ClassNameResolver;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class ClassPathAnnotationConfiguration extends AnnotationConfiguration {

  String baseClassPath;

  public ClassPathAnnotationConfiguration(String baseClassPath) {
    this.baseClassPath = baseClassPath;
  }

  @Override
  public void parseContainerPath(WebAppContext context, AnnotationParser parser) throws Exception {
    super.parseContainerPath(context, parser);
    parseAnnotationsInClassPath(context, parser);
  }

  @Override
  public void parseWebInfClasses(WebAppContext context, AnnotationParser parser) throws Exception {
    // dummy now
  }

  @Override
  public void parseWebInfLib(WebAppContext context, AnnotationParser parser) throws Exception {
    // dummy now
  }

  public void parseAnnotationsInClassPath(final WebAppContext context, final AnnotationParser parser) throws Exception {

    parser.parse(Resource.newClassPathResource(baseClassPath), new ClassNameResolver() {

      public boolean isExcluded(String name) {
        return false;
      }

      public boolean shouldOverride(String name) {
        return true;
      }
    });
  }
}
