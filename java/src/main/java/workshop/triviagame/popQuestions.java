package workshop.triviagame;

import java.util.LinkedList;

public class popQuestions implements QuestionTypes{

    private LinkedList<String> question = new LinkedList<String>();
    @Override
    public void addString(int i) {
        question.addLast("Pop Question " + i);
    }

    @Override
    public String remove() {
        return (String) question.removeFirst();
    }

    public boolean match(String category){
        return (category.equals("Pop"));
    }
}
