package simple.stringcalc;

public class StringCalculator {

  private static final String DEFAULT_DELIMITERS = ",|\n";

  public int add(final String stringToAdd) {

    String numbers = stringToAdd;
    String delimiters = findDelimiters(stringToAdd);

    if (firstLineIsDelimiterLine(stringToAdd)) {
      numbers = stringToAdd.substring(stringToAdd.indexOf('\n') + 1);
    }

    String[] arrayOfNumbers = numbers.split(delimiters);
    return addUp(arrayOfNumbers);
  }

  private String findDelimiters(final String numbers) {

    if (!firstLineIsDelimiterLine(numbers)) {
      return DEFAULT_DELIMITERS;
    }

    return numbers.split("//|\n")[1];
  }

  private boolean firstLineIsDelimiterLine(final String numbers) {

    return numbers.startsWith("//");
  }

  private int addUp(final String[] arrayOfNumbers) {
    int result = 0;
    for (String number : arrayOfNumbers) {
      result += toInteger(number);
    }
    return result;
  }

  private int toInteger(final String number) {
    if (isNotEmpty(number)) {
      Integer result = Integer.valueOf(number);
      validate(result);
      return result;
    }
    return 0;
  }

  private void validate(final Integer result) {

    if (result < 0) {
      throw new IllegalArgumentException("Negative numbers are not allowed!");
    }
  }

  private boolean isNotEmpty(final String number) {

    return !isEmpty(number);
  }

  private boolean isEmpty(final String number) {

    return "".equals(number);
  }


}
