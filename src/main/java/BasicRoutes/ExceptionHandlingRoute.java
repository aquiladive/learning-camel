package BasicRoutes;

import org.apache.camel.builder.RouteBuilder;

public class ExceptionHandlingRoute extends RouteBuilder {

  //change according to local settings
  private String desktopPath = "/Users/username/Desktop/";

  @Override
  public void configure() throws Exception {
        onException(Exception.class)
                .log("Exception has occurred.")
                .to("file:"+desktopPath+"Error");

        from("file:"+desktopPath+"Start?noop=true")
                .choice()
                .when(header("CamelFileName").isEqualTo("hello.txt"))
                .to("file:"+desktopPath+"End")
                .otherwise()
                .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                          throw new IllegalArgumentException();
                });
    }
}
