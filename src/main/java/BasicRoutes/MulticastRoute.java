package BasicRoutes;

import org.apache.camel.builder.RouteBuilder;

public class MulticastRoute extends RouteBuilder {
  private String desktopPath = "/Users/username/Desktop/";
  
  @Override
  public void configure() throws Exception {
    //sequential multicast - first sent to London folder then to the UK folder
    from("file:"+desktopPath+"Start?noop=true")
      .multicast()
      .to("file:"+desktopPath+"London", "file:"+desktopPath+"UK");

    //parallel multicast - sends to both folders at the same time
    //default thread size is 10, can be changed by using-
    //ExecutorService executorService = Executors.newFixedThreadPool(16);
    from("file:"+desktopPath+"London?noop=true")
      .multicast().parallelProcessing()
      .to("file:"+desktopPath+"London/President", "file:"+desktopPath+"London/WarCouncil");
    
    //by default, multicast will send to destinations even if one fails
    //to prevent that
    from("file:"+desktopPath+"London/WarCouncil")
      .multicast().stopOnException()
      .to("file:"+desktopPath+"London/Council1", "file:"+desktopPath+"London/Council2")
  }
}
