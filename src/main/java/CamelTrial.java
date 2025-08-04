import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import BasicRoutes.*;

public class CamelTrial {
    public static void main(String[] args) throws Exception
    {
        CamelContext context = new DefaultCamelContext();

        /* uncomment the route to test each */
        //context.addRoutes(new MyCamelRoute());
        //context.addRoutes(new ExceptionHandlingRoute());
        context.addRoutes(new SplitAggregateRoute());

        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
