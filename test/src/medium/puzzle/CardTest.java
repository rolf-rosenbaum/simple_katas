package medium.puzzle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {

  @Test
  public void testEquals() {
    assertThat(new Card(1, 2, 3, 4).equals(new Card(1, 2, 3, 4)), is(true));
    assertThat(new Card(2, 2, 3, 4).equals(new Card(1, 2, 3, 4)), is(false));
  }

  @Test
  public void testTurnRight() {
    assertThat(new Card(1, 2, 3, 4).turnRight().equals(new Card(4, 1, 2, 3)), is(true));
  }
}
