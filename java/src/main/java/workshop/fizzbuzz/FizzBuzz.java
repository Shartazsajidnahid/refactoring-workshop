package workshop.fizzbuzz;



import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
    private List<PatternMatcher> patternMatchers;
    private PatternMatcher nullObjectPattern;
    public FizzBuzz(List<PatternMatcher> patternMatchers) {
        super();
        this.patternMatchers = patternMatchers;
    }

    public String say(int number) {
        String strReturn = "";
        for (PatternMatcher patternMatcher : patternMatchers) {
            if (patternMatcher.matches(number)) strReturn+=(patternMatcher.generateRresponse());
        }

        return strReturn.isEmpty()? String.valueOf(number) : strReturn;
    }
}

