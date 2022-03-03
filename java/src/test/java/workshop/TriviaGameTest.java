package workshop;

import org.junit.Test;
import workshop.texttoHtml.*;
import workshop.triviagame.QuestionManager;
import workshop.triviagame.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriviaGameTest {
    private QuestionManager Questions;

    private QuestionTypes matcher1 = new popQuestions();
    private QuestionTypes matcher2 = new sportsQuestions();
    private QuestionTypes matcher3 = new scienceQuestions();
    private QuestionTypes matcher4 = new rockQuesions();
    List<QuestionTypes> matcherList = new ArrayList<>();

    private void addtolist(){
        matcherList.add(matcher1);
        matcherList.add(matcher2);
        matcherList.add(matcher3);
        matcherList.add(matcher4);

        Questions = new QuestionManager(matcherList);

    }
    FakeTriviaGame game = new FakeTriviaGame(Questions);

    @Test
    public void correctlyAnswered() {
        game.add("Chet");
        game.add("Pat");
        game.roll(2);
        game.wasCorrectlyAnswered();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 2",
                "Chet's new location is 2",
                "The category is Sports",
                "Sports Question 0",
                "Answer was correct!!!!",
                "Chet now has 1 Gold Coins."), game.getMessages());
    }

    @Test
    public void wronglyAnswered() {
        game.add("Chet");
        game.add("Pat");
        game.roll(1);
        game.wrongAnswer();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 1",
                "Chet's new location is 1",
                "The category is Science",
                "Science Question 0",
                "Question was incorrectly answered",
                "Chet was sent to the penalty box"), game.getMessages());
    }

    class FakeTriviaGame extends TriviaGame {
        List<String> messages = new ArrayList<>();

        public FakeTriviaGame(QuestionManager Questions) {
            super(Questions);
        }

        protected void announce(Object message) {
            messages.add(String.valueOf(message));
        }

        protected List<String> getMessages() {
            return messages;
        }
    }
}
