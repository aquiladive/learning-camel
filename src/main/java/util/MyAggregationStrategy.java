public class MyAggregationStrategy implements AggregationStrategy {
  @Override
  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    if(oldExchange==null)
      return newExchange;
    String message = oldExchange.getIn().getBody(String.class) + " " + newExchange.getIn().getBody(String.class);
    oldExchange.getIn().setBody(message);
    return oldExchange;
  }
}
