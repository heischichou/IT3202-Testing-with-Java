package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class AppTest {
  @Test
  public void randomNumberDoesNotExceedCeiling(){
    int number = App.generateRand();

    assertTrue(number >= 0 && number <= 13);
  }
  
  @Test
  public void checkerFlagsTrueCorrectly(){
    int number = App.generateRand(), guess = number;

    assertEquals(1, App.check(number, guess));
  }

  @Test
  public void checkerFlagsFalseCorrectly(){
    int number = App.generateRand(), guess;
    while((guess = App.generateRand()) == number);

    assertEquals(0, App.check(number, guess));
  }

  @Test
  public void gameRunsCorrectly(){
    int number = App.generateRand(), guess = App.generateRand();
    while(guess != number){
      App.hint(number, guess);

      if(App.check(number, guess) == 0){
        number = App.generateRand();
      }
    }

    assertEquals(1, App.check(number, guess));
  }
}
