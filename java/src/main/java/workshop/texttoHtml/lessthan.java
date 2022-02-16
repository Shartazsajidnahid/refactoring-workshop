package workshop.texttoHtml;

public class lessthan implements patternmatcher{

    @Override
    public boolean matches(char character) {
        return (character=='<');
    }

    @Override
    public String generateResponse(char character) {
        return "&lt;";
    }
}
