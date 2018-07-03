package pl.b2bnetwork;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class YaMDAppTest extends TestCase {

    public YaMDAppTest(String testName) {
    super(testName);
  }

  public static Test suite() {
      return new TestSuite(YaMDAppTest.class);
  }

  public void testApp() {
    assertTrue(true);
  }
}
