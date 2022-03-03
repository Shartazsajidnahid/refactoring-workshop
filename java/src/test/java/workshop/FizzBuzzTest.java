package workshop;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.Test;
import workshop.fizzbuzz.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    private PatternMatcher matcher1 = new FizzPatternMatcher();
    private PatternMatcher matcher2 = new BuzzPatternMatcher();
    private List<PatternMatcher> matcherList = new ArrayList<>();;



    public void addtolist(){
        matcherList = new ArrayList<>();
        matcherList.add(matcher1);
        matcherList.add(matcher2);
    }


    private FizzBuzz fizzbuzz = new FizzBuzz(matcherList);

    @Test
    public void returnsANumber() {
        assertEquals("1", fizzbuzz.say(1));
        assertEquals("4", fizzbuzz.say(4));
        assertEquals("7", fizzbuzz.say(7));
    }

    @Test
    public void factorOf3() {
        assertEquals("Fizz", fizzbuzz.say(3));
        assertEquals("Fizz", fizzbuzz.say(6));
        assertEquals("Fizz", fizzbuzz.say(9));
    }

    @Test
    public void factorOf5() {
        assertEquals("Buzz", fizzbuzz.say(5));
        assertEquals("Buzz", fizzbuzz.say(10));
        assertEquals("Buzz", fizzbuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        assertEquals("FizzBuzz", fizzbuzz.say(15));
        assertEquals("FizzBuzz", fizzbuzz.say(30));
        assertEquals("FizzBuzz", fizzbuzz.say(60));
    }
}
