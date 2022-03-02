package workshop.triviagame;

import java.util.LinkedList;

public class sportsQuestions implements QuestionTypes{
    LinkedList<String> question = new LinkedList<String>();
    @Override
    public void addString(int i) {
        question.addLast("Sports Question " + i);
    }

    @Override
    public String remove() {
        return (String) question.removeFirst();
    }

    public boolean match(String category){
        return (category.equals("Sports"));
    }
}
