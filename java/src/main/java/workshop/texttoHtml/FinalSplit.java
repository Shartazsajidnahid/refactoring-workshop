package workshop.texttoHtml;

import java.util.ArrayList;
import java.util.List;

public class FinalSplit {

    public List<String> newLineSplit(String to_split){

        List<String> response = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (char characterToConvert : to_split.toCharArray()) {

            if(characterToConvert == '\n'){
                String line = String.join("", response);
                result.add(line);
                response = new ArrayList<>();
            }
            else{
                response.add(String.valueOf(characterToConvert));
            }
        }
        return result;
    }
}
