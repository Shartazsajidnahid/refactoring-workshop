package workshop.triviagame;

import java.util.List;

public class QuestionManager {

    private List<QuestionTypes> questions;

    public QuestionManager(List<QuestionTypes> questions) {
        this.questions = questions;

        for (int i = 0; i < 50; i++) {
            for (QuestionTypes questionTypes : questions) {
                questionTypes.addString(i);
            }
        }
    }

    public void askQuestion(int number) {
        System.out.println(announce_question(number));
    }

    private String announce_question(int number) {
        String category = currentCategory(number);
        StringBuilder returnQuestion = new StringBuilder();

        for (QuestionTypes questionTypes : questions) {
            if(questionTypes.match(category)){
                returnQuestion.append(questionTypes.remove());
            }
        }
        return returnQuestion.toString();
    }

    public String currentCategory(int number) {
        return switch (number % 4) {
            case 0 -> "Pop";
            case 1 -> "Science";
            case 2 -> "Sports";
            default -> "Rock";
        };
    }
}

