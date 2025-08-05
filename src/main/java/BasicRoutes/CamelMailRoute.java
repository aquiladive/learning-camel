public class CamelMailRoute extends RouteBuilder {
  onException(Exception.class)
    .wiretap()
    .to("file:"+desktopPath+"Error");

  from("file:"+desktopPath+"Start?noop=true")
    .unmarshal().json()
    .marshal().json()
    .log("JSON file detected.")
    .to("file:"+desktopPath+"End");
}
