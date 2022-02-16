package workshop.fizzbuzz;

public class FizzPatternMatcher implements PatternMatcher{

    @Override
    public boolean matches(int number) {
        return number % 3 == 0;
    }

    @Override
    public String generateRresponse() {

        return "fizz";
    }


}
