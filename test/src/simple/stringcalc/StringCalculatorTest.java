package simple.stringcalc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class StringCalculatorTest {

  StringCalculator calculator = new StringCalculator();

  @Test
  public void emptyStringShouldReturnZero() {

    assertThat(calculator.add(""), is(0));
  }

  @Test
  public void oneNumberShouldReturnTheNumber() {

    assertThat(calculator.add("1"), is(1));
    assertThat(calculator.add("23"), is(23));
  }

  @Test
  public void aListOfNumbersShouldBeAddedUp() {

    assertThat(calculator.add("1,2"), is(3));
    assertThat(calculator.add("1,2,3,4"), is(10));

  }

  @Test
  public void delimitersShouldBeConfigurable() {

    assertThat(calculator.add("//;|,\n1;2,3,4"), is(10));

  }

  @Test(expected = IllegalArgumentException.class)
  public void negativNumbersShouldNotBeAllowed() {
    calculator.add("-1");
  }

  @Ignore
  @Test
  public void exceptionMessageShouldContainAllNegativeNumbers() {
    try {
      calculator.add("-1,-2");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Negative numbers are not allowed!"));
      assertThat(e.getMessage(), containsString("'-1', '-2'"));
    }

  }

}
