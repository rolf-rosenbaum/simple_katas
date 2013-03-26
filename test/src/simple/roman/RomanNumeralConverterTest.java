package simple.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Test;

public class RomanNumeralConverterTest {

  @Test
  public void aSingleLiteralShouldBeComputedCorrectly() {
    assertThat(new RomanNumeralConverter("I").asDecimal(), is(1));
    assertThat(new RomanNumeralConverter("V").asDecimal(), is(5));
    assertThat(new RomanNumeralConverter("X").asDecimal(), is(10));
    assertThat(new RomanNumeralConverter("L").asDecimal(), is(50));
    assertThat(new RomanNumeralConverter("M").asDecimal(), is(1000));
  }

  @Test
  public void II_shouldComputeToTwo() {

    assertThat(new RomanNumeralConverter("II").asDecimal(), is(2));
  }

  @Test
  public void III_shouldComputeToThree() {
    assertThat(new RomanNumeralConverter("III").asDecimal(), is(3));
  }


  @Test
  public void IV_shouldComputeToFour() {
    assertThat(new RomanNumeralConverter("IV").asDecimal(), is(4));
  }

  @Test
  public void testAFewConversions() {
    assertThat(new RomanNumeralConverter("IX").asDecimal(), is(9));
    assertThat(new RomanNumeralConverter("XIX").asDecimal(), is(19));
    assertThat(new RomanNumeralConverter("XXIV").asDecimal(), is(24));
    assertThat(new RomanNumeralConverter("XC").asDecimal(), is(90));
    assertThat(new RomanNumeralConverter("XCIX").asDecimal(), is(99));
    assertThat(new RomanNumeralConverter("MCMXCIX").asDecimal(), is(1999));
    assertThat(new RomanNumeralConverter("MMCDLXXVII").asDecimal(), is(2477));

  }


  @Test
  public void oneShouldBeConvertedToI() {
    assertThat(new RomanNumeralConverter(1).asRoman(), is("I"));
  }

  @Test
  public void twoShouldBeConvertedToII() {
    assertThat(new RomanNumeralConverter(2).asRoman(), is("II"));
  }

  @Test
  public void fiveShouldBeConvertedToV() {
    assertThat(new RomanNumeralConverter(5).asRoman(), is("V"));
  }

  @Test
  public void eightShouldBeConvertedToVIII() {
    assertThat(new RomanNumeralConverter(8).asRoman(), is("VIII"));
  }

  @Test
  public void tenShouldBeConvertedToX() {
    assertThat(new RomanNumeralConverter(10).asRoman(), is("X"));
  }

  @Test
  public void sixteenHundredSixtySixShouldBeConvertedToMDCLXVI() {
    assertThat(new RomanNumeralConverter(1666).asRoman(), is("MDCLXVI"));
  }

  @Test
  public void fourShouldBeConvertedToIV() {
    assertThat(new RomanNumeralConverter(4).asRoman(), is("IV"));
  }

  @Test
  public void testBackAndForthConversionOfRandomNumber() {

    int value = new Random(System.currentTimeMillis()).nextInt(4000);
    assertThat(new RomanNumeralConverter(new RomanNumeralConverter(value).asRoman()).asDecimal(), is(value));
  }
}
