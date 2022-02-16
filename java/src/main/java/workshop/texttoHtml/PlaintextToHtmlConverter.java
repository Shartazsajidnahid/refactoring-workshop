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
        List<String> result = new ArrayList<>();
        String convertedLine="";
        samechar samecharacter = new samechar();
        patternmatcherList.add(samecharacter);
        for (char characterToConvert : source.toCharArray()) {
            for (patternmatcher patternmatch : patternmatcherList ){
                if(patternmatch.match(characterToConvert)){
                    convertedLine+=(patternmatch.generateResponse(characterToConvert)); break;
                }
            }
        }
        String[] finalr = convertedLine.toString().split("\n");
       // result = convertedLine.split("\n");
        String finalResult = String.join("<br />", finalr);
        return finalResult;
    }
}