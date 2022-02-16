package workshop.texttoHtml;

public class ampersand implements patternmatcher{
    @Override
    public boolean matches(char character) {
        return (character=='&');
    }

    @Override
    public String generateResponse(char character) {
        return "&amp;";
    }
}
