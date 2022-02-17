package workshop.triviagame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;


public class ListOfQuestions{

    //TODO: implement a list-of-linkedlist or Map or something to replace 4 linkedlists

    private HashMap<String,LinkedList<String>> question_list = new HashMap<>();
    String[] category = new String[]{"Pop","Science","Sports","Rock"};

/*
    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();

 */

    public ListOfQuestions(){
        for (String type : category) {
            question_list.put(type, new LinkedList<String>());
        }

        for (int i = 0; i < 50; i++) {
            question_list.get("Pop").addLast("Pop Question " + i);
            question_list.get("Science").addLast("Science Question " + i);
            question_list.get("Sports").addLast("Science Question " + i);
            question_list.get("Rock").addLast("Rock Question " + i);
        }
    }

    public void askQuestion(int number) {
        System.out.println(announce_question(number));
    }

    private String announce_question(int number) {

        for (Map.Entry<String,LinkedList<String >> entry : question_list.entrySet()) {
            if(entry.getKey()==currentCategory(number)) return entry.getValue().removeFirst();
        }
/*
        if (currentCategory(number) == "Pop")  return  (String) popQuestions.removeFirst();
        else if (currentCategory(number) == "Science") return (String) scienceQuestions.removeFirst();
        else if (currentCategory(number) == "Sports")  return  (String) sportsQuestions.removeFirst();
        else if (currentCategory(number) == "Rock") return  (String) rockQuestions.removeFirst();
 */
    }


    public String currentCategory(int number) {
        return category[number % 4];
    }

}
