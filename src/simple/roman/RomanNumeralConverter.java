package simple.roman;

import java.util.EnumSet;

public class RomanNumeralConverter {

  private RomanNumeral[] numerals;

  private int currentValue;

  public RomanNumeralConverter(final String literal) {

    makeNumeralArrayFromLiteral(literal);
  }

  public RomanNumeralConverter(final int value) {

    currentValue = value;
  }

  public int asDecimal() {
    int sum = 0;
    for (int i = 0; i < numerals.length; i++) {
      sum += getActualValueInContext(i);
    }
    return sum;
  }

  private int getActualValueInContext(final int index) {

    if (isFollowingLiteralGreater(index)) {
      return (-1) * numerals[index].intValue();
    } else {
      return numerals[index].intValue();
    }
  }

  private boolean isFollowingLiteralGreater(final int index) {

    return index < numerals.length - 1 && numerals[index + 1].isGreaterThan(numerals[index]);
  }

  private void makeNumeralArrayFromLiteral(String literal) {

    int length = literal.length();
    numerals = new RomanNumeral[length];
    for (int i = 0; i < length; i++) {
      numerals[i] = RomanNumeral.valueOf(String.valueOf(literal.charAt(i)));
    }
  }

  public String asRoman() {

    String roman = "";
    for (RomanNumeral numeral : goThroughAllPossibleRomanNumeralsInDescendingOrder()) {
      roman += addAppropriateNumberOf(numeral);
    }
    return roman;
  }

  private EnumSet<RomanNumeral> goThroughAllPossibleRomanNumeralsInDescendingOrder() {
    return EnumSet.allOf(RomanNumeral.class);
  }

  private String addAppropriateNumberOf(RomanNumeral numeral) {

    String result = "";
    for (int i = 0; i < numberOfNumeralsInCurrentValue(numeral); i++) {
      result += numeral.stringValue();
    }
    currentValue -= numberOfNumeralsInCurrentValue(numeral) * numeral.intValue();
    return result;
  }

  private int numberOfNumeralsInCurrentValue(RomanNumeral numeral) {
    return currentValue / numeral.intValue();
  }

  static enum RomanNumeral {
    M("M", 1000), CM("CM", 900), D("D", 500), CD("CD", 400), C("C", 100), XC("XC", 90), L("L", 50), XL("XL", 40), X("X",
        10), IX("IX", 9), V("V", 5), IV("IV", 4), I("I", 1);

    private int intValue;

    private String stringValue;

    private RomanNumeral(String stringValue, int intValue) {

      this.stringValue = stringValue;
      this.intValue = intValue;
    }

    public int intValue() {

      return intValue;
    }

    public String stringValue() {

      return stringValue;
    }

    public boolean isGreaterThan(RomanNumeral other) {

      return intValue > other.intValue;
    }

  }
}
