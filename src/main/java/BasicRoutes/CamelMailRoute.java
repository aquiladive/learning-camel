package BasicRoutes;

import org.apache.camel.builder.RouteBuilder;

public class CamelMailRoute extends RouteBuilder {
  String desktopPath = "/Users/username/Desktop";
  String smtpPath = "smtp://localhost:3025";
  String smtpParams = "username=test@localhost&password=password";
  
  @Override public void configure() throws Exception {
    onException(Exception.class)
      .wiretap(smtpPath+"?"+smtpParams)
      .to("file:"+desktopPath+"Error");

    from("file:"+desktopPath+"Start?noop=true")
      .unmarshal().json()
      .marshal().json()
      .log("JSON file detected.")
      .to("file:"+desktopPath+"End");
  }
}
