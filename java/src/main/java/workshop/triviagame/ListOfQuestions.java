package workshop.triviagame;

import java.util.LinkedList;

public class ListOfQuestions{
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public ListOfQuestions(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void askQuestion(int number) {
        System.out.println(announce_question(number));
    }

    private String announce_question(int number) {
        if (currentCategory(number) == "Pop")
            return  (String) popQuestions.removeFirst();
        else if (currentCategory(number) == "Science")
            return (String) scienceQuestions.removeFirst();
        else if (currentCategory(number) == "Sports")
            return  (String) sportsQuestions.removeFirst();
        else if (currentCategory(number) == "Rock")
            return  (String) rockQuestions.removeFirst();

    }


    public String currentCategory(int number) {
        String[] category_check = new String[]{"Pop","Science","Sports","Rock"};
        return category_check[number % 4];
    }

}
