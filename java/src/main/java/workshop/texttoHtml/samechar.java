package workshop.texttoHtml;

public class samechar implements patternmatcher{
    @Override
    public boolean matches(char character) {
        return true;
    }

    @Override
    public String generateResponse(char character) {
        return String.valueOf(character);
    }
}
