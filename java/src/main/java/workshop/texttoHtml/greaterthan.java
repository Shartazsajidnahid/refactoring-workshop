package workshop.texttoHtml;

public class greaterthan implements patternmatcher{

    @Override
    public boolean matches(char character) {
        return (character=='>');
    }

    @Override
    public String generateResponse(char character) {
        return "&gt;";
    }
}
