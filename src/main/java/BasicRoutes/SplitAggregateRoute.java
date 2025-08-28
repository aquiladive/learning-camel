package BasicRoutes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.StringAggregationStrategy;

public class SplitAggregateRoute extends RouteBuilder {

  //change according to local settings
  private String desktopPath = "/Users/username/Desktop/";

    @Override
  public void configure() throws Exception {
        from("file:"+desktopPath+"Start?noop=true")
                .split().tokenize("\n") //splitting by newline
                .aggregate(simple("${body} contains 'London'"), new StringAggregationStrategy())
                .completionSize(4) //aggregate after 4 messages
                .log(header("CamelFileName") + ": Aggregation complete.")
                .to("file:"+desktopPath+"End");
    }
}
