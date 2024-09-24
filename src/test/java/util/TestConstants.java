package util;

import static javax.swing.UIManager.getString;

/**
 * @author Mohammed Hmeidan
 */
@SuppressWarnings("WeakerAccess")
public final class TestConstants {

  public static String PRACTICE_PORTAL_BASE_URL;


  static {

    PRACTICE_PORTAL_BASE_URL = System.getProperty("portal_url");

  }

  private TestConstants() {
  }
}
