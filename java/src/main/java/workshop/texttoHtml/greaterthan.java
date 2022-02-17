package workshop.texttoHtml;

public class greaterthan implements patternmatcher{

    @Override
    public boolean match(char character) {
        return (character=='>');
    }

    @Override
    public String generateResponse() {
        return "&gt;";
    }
}
