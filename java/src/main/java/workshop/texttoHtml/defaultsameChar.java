package workshop.texttoHtml;

public class defaultsameChar implements patternmatcher{
    @Override
    public boolean match(char character) {
        return (character != '<' && character != '>' && character != '&' && character != '\n');
    }

    @Override
    public String generateResponse(char input) {
        return String.valueOf(input);
    }
}
