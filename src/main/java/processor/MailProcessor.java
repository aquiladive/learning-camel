package processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import java.util.HashMap;
import java.util.Map;

public class MailProcessor implements Processor {

    @Override public void process(Exchange exchange) throws Exception
    {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("To", "user@localhost");
        headers.put("From", "test@localhost");
        headers.put("Subject", "Greetings");
        String body = "Hello, and welcome to mailing with Camel!";

        exchange.getIn().setBody(body);
        exchange.getIn().setHeaders(headers);
    }
}
