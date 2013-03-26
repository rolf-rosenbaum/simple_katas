package simple.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static simple.roman.RomanNumeralConverter.RomanNumeral.C;
import static simple.roman.RomanNumeralConverter.RomanNumeral.D;
import static simple.roman.RomanNumeralConverter.RomanNumeral.I;
import static simple.roman.RomanNumeralConverter.RomanNumeral.L;
import static simple.roman.RomanNumeralConverter.RomanNumeral.M;
import static simple.roman.RomanNumeralConverter.RomanNumeral.V;
import static simple.roman.RomanNumeralConverter.RomanNumeral.X;

import org.junit.Test;

public class RomanNumeralTest {
  @Test
  public void testIntValue() throws Exception {

    assertThat(I.intValue(), is(1));
    assertThat(X.intValue(), is(10));
  }

  @Test
  public void testIsGreaterThan() throws Exception {
    assertTrue(V.isGreaterThan(I));
    assertTrue(X.isGreaterThan(V));
    assertTrue(L.isGreaterThan(X));
    assertTrue(C.isGreaterThan(L));
    assertTrue(D.isGreaterThan(C));
    assertTrue(M.isGreaterThan(D));

    assertFalse(I.isGreaterThan(I));
  }
}
