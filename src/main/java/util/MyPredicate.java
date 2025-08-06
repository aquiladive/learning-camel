package util;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

public class MyPredicate implements Predicate {

  @Override
  public boolean matches(Exchange exchange) {
    //checks if the letter "a" is present in a message that also has "To: " in it
    if(exchange.getIn().getBody(String.class).contains("To: "))
      return exchange.getIn().getBody(String.class).contains("a");
    return false;
  }
}
