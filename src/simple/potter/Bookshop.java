package simple.potter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Bookshop {

  static final BigDecimal PRICE_OF_ONE_BOOK = new BigDecimal(8.0);
  static final BigDecimal TWO_BOOK_DISCOUNT_RATE = new BigDecimal(0.95);
  static final BigDecimal THREE_BOOK_DISCOUNT_RATE = new BigDecimal(0.90);
  static final BigDecimal FOUR_BOOK_DISCOUNT_RATE = new BigDecimal(0.80);
  static final BigDecimal FIVE_BOOK_DISCOUNT_RATE = new BigDecimal(0.75);


  public BigDecimal priceOf(String bookList) {
    if (bookList.trim().isEmpty())
      return new BigDecimal(0);

    String[] books = bookList.split(",");
    int number = numberOfDifferentBooksIn(books);
    switch (number) {
      case 1:
        return PRICE_OF_ONE_BOOK.multiply(new BigDecimal(books.length));
      case 2:
        return PRICE_OF_ONE_BOOK.multiply(new BigDecimal(books.length)).multiply(TWO_BOOK_DISCOUNT_RATE);
      case 3:
        return PRICE_OF_ONE_BOOK.multiply(new BigDecimal(books.length)).multiply(THREE_BOOK_DISCOUNT_RATE);
      case 4:
        return PRICE_OF_ONE_BOOK.multiply(new BigDecimal(books.length)).multiply(FOUR_BOOK_DISCOUNT_RATE);
      case 5:
        return PRICE_OF_ONE_BOOK.multiply(new BigDecimal(books.length)).multiply(FIVE_BOOK_DISCOUNT_RATE);
      default:
        throw new IllegalArgumentException("Unexpected number of books in list");
    }

  }

  private int numberOfDifferentBooksIn(String[] books) {
    Set<String> bookSet = new HashSet<String>(books.length);

    for (String book : books) {
      bookSet.add(book);
    }
    return bookSet.size();
  }

}
