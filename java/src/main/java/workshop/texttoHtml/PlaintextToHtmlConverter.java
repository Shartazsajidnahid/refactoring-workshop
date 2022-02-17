package workshop.texttoHtml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        String[] initial_encode = initial_convert(source).split("\n");
        String finalResult = String.join("<br />", initial_encode);
        return finalResult;
    }

    private String initial_convert(String source ) {
        String convertedLine="", response="";
        for (char characterToConvert : source.toCharArray()) {
            response = Character.toString(characterToConvert);
            for (patternmatcher patternmatch : patternmatcherList ){
                if(patternmatch.match(characterToConvert)){
                     response = patternmatch.generateResponse(); break;
                }
            }
            convertedLine += response;
        }
        return convertedLine;
    }
}