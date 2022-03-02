package workshop.texttoHtml;

public class newline implements patternmatcher{
    @Override
    public boolean match(char character) {
        return (character=='\n');
    }

    @Override
    public String generateResponse(char input) {
        return "\n";
    }
}
