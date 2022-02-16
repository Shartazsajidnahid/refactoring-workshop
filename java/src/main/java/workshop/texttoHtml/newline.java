package workshop.texttoHtml;

public class newline implements patternmatcher{
    @Override
    public boolean matches(char character) {
        return (character=='\n');
    }

    @Override
    public String generateResponse(char character) {
        return "\n";
    }
}
