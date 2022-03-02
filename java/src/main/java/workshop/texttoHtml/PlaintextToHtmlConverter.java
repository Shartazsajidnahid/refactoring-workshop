package workshop.texttoHtml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlaintextToHtmlConverter {
    private List<patternmatcher> patternmatcherList;

    public PlaintextToHtmlConverter(List<patternmatcher> patternmatcherList) {
        this.patternmatcherList = patternmatcherList;
    }

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }
    private String read() throws IOException {
    	Path filePath = Paths.get("sample.txt");
    	byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        String converted = initial_convert(source);

        FinalSplit finalSplit = new FinalSplit();
        List<String> initial_split = finalSplit.newLineSplit(converted);

        String finalResult = String.join("<br />", initial_split);
        return finalResult;
    }

    private String initial_convert(String source ) {
        StringBuilder convertedLine= new StringBuilder();
        String response;

        for (char characterToConvert : source.toCharArray()) {
            response = Character.toString(characterToConvert);
            for (patternmatcher patternmatch : patternmatcherList ){
                if(patternmatch.match(characterToConvert)){
                     response = patternmatch.generateResponse();
                     break;
                }
            }
            convertedLine.append(response);
        }
        return convertedLine.toString();
    }
}

