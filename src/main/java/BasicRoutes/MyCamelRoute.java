package BasicRoutes;

import org.apache.camel.builder.RouteBuilder;

public class MyCamelRoute extends RouteBuilder {

  //change according to local settings
  private String desktopPath = "/Users/username/Desktop/";

    @Override public void configure() throws Exception
    {
        from("file:"+desktopPath+"Start?noop=true")
                .to("file:"+desktopPath+"End");
    }
}
