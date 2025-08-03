import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import BasicRoutes.MyCamelRoute;

public class CamelTrial {
    public static void main(String[] args) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        
        //context.addRoutes(new MyCamelRoute());
        context.addRoutes(new ExceptionHandlingRoute());

        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
