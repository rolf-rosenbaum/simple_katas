package simple.potter;

import static java.math.MathContext.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static simple.potter.Bookshop.FIVE_BOOK_DISCOUNT_RATE;
import static simple.potter.Bookshop.FOUR_BOOK_DISCOUNT_RATE;
import static simple.potter.Bookshop.PRICE_OF_ONE_BOOK;
import static simple.potter.Bookshop.THREE_BOOK_DISCOUNT_RATE;
import static simple.potter.Bookshop.TWO_BOOK_DISCOUNT_RATE;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Test;

public class BookshopTest {

  static final BigDecimal TWO = new BigDecimal((2.0));
  static final BigDecimal THREE = new BigDecimal(3.0);
  static final BigDecimal FOUR = new BigDecimal(4.0);
  static final BigDecimal FIVE = new BigDecimal(5.0);


  Bookshop bookshop = new Bookshop();

  @Test
  public void emptyBasketIsForFree() {
    assertThat(bookshop.priceOf("").doubleValue(), is(0.00));
  }

  @Test
  public void anySingleBookCostsEightEUR() {
    assertThat(bookshop.priceOf("1"), is(PRICE_OF_ONE_BOOK));
    assertThat(bookshop.priceOf("2"), is(PRICE_OF_ONE_BOOK));
    assertThat(bookshop.priceOf("3"), is(PRICE_OF_ONE_BOOK));
    assertThat(bookshop.priceOf("4"), is(PRICE_OF_ONE_BOOK));
    assertThat(bookshop.priceOf("5"), is(PRICE_OF_ONE_BOOK));
  }

  @Test
  public void severalBooksOfTheSameTypeGetNoDiscount() {
    assertThat(bookshop.priceOf("1,1"), is(PRICE_OF_ONE_BOOK.multiply(TWO)));
  }

  @Test
  public void twoDifferentBooksResultInFivePercentDiscount() {
    assertThat(bookshop.priceOf("1,2"), is(PRICE_OF_ONE_BOOK.multiply(TWO).multiply(TWO_BOOK_DISCOUNT_RATE)));
  }

  @Test
  public void threeDifferentBooksResultInTenPercentDiscount() {
    assertThat(bookshop.priceOf("1,2,3").round(DECIMAL32), is(
        PRICE_OF_ONE_BOOK.multiply(THREE).multiply(THREE_BOOK_DISCOUNT_RATE).round(DECIMAL32)));
  }

  @Test
  public void fourDifferentBooksResultInTwentyPercentDiscount() {
    assertThat(bookshop.priceOf("1,2,3,4").round(DECIMAL32), is(
        PRICE_OF_ONE_BOOK.multiply(FOUR).multiply(FOUR_BOOK_DISCOUNT_RATE).round(DECIMAL32)));
  }

  @Test
  public void fiveDifferentBooksResultInTwentyFivePercentDiscount() {
    assertThat(bookshop.priceOf("1,2,3,4,5").round(DECIMAL32), is(
        PRICE_OF_ONE_BOOK.multiply(FIVE).multiply(FIVE_BOOK_DISCOUNT_RATE).round(DECIMAL32)));
  }



}
