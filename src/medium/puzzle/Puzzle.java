package medium.puzzle;

import java.util.Arrays;
import java.util.List;

public class Puzzle {

  private List<Card> cards;


  public Puzzle(Card... card) {
    cards = Arrays.asList(card);
  }

  public int solutions() {
    if (cards.size() == 1) {
      return 4;
    }
    return 2;

  }
}

