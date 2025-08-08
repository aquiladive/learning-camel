package util;

import java.util.concurrent.atomic.AtomicInteger;

public class FileNameGenerator {
  private AtomicInteger counter = new AtomicInteger(1);
  public String generateFileName() { return "combined" + counter.getAndIncrement() + ".txt"; }
}
