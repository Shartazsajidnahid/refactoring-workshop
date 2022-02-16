package workshop.texttoHtml;

public class ampersand implements patternmatcher{
    @Override
    public boolean match(char character) {
        return (character=='&');
    }

    @Override
    public String generateResponse(char character) {
        return "&amp;";
    }
}
