package BasicRoutes;

//the Camel doc for SFTP component leaves out that filterFile won't work without encoding the Simple expression. Using the Simple expression as is, I've gotten the error that "<" can't be parsed.

import org.apache.camel.builder.RouteBuilder;

public class CamelMailRoute extends RouteBuilder {
  String desktopPath = "/Users/username/Desktop";
  String sftpPath = "sftp://localhost:22";
  String privateKey = "src/main/resources/privateKey";
  String sftpParams = "username=user&privateKey="+privateKey;

  String filterPath = URLEncoder.encode("&filterFile={file:size}<500");
  
  @Override
  public void configure() throws Exception {
    from("file:"+desktopPath+"Start?noop=true")
      .log("JSON file detected.")
      .to(sftpPath+"?"+sftpParams);

    from(sftpPath+"?"+sftpParams+filterPath)
      .to("file:"+desktopPath+"End");
  }
}
