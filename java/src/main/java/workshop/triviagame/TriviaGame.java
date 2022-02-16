package workshop.triviagame;

import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    private boolean check_not_gettingout(int roll) {
        return inPenaltyBox[currentPlayer] && (roll % 2 == 0);
    }

    public void roll(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if(check_not_gettingout(roll)){
            announce(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
        else {
            if(inPenaltyBox[currentPlayer]) {
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
            }
            update_location(roll);
        }
    }

    private void update_location(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        announce(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        announce("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion() {

        announce(announce_question());
    }

    private String announce_question() {
        if (currentCategory() == "Pop")
            return  (String) popQuestions.removeFirst();
        else if (currentCategory() == "Science")
            return (String) scienceQuestions.removeFirst();
        else if (currentCategory() == "Sports")
            return  (String) sportsQuestions.removeFirst();
        else if (currentCategory() == "Rock")
            return  (String) rockQuestions.removeFirst();

    }


    private String currentCategory() {
        String[] category_check = new String[]{"Pop","Science","Sports","Rock","Pop","Science","Sports","Rock","Pop","Science","Sports","Rock"};
        String strReturn = "";
        strReturn = category_check[places[currentPlayer]];
        return strReturn;
    }

    private boolean check_not_correctanswer() {
        return inPenaltyBox[currentPlayer] && !isGettingOutOfPenaltyBox;
    }

    public boolean wasCorrectlyAnswered() {
        if(check_not_correctanswer()){
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;
            return true;
        }
        else{
            return answer_was_correct();
        }
    }

    private boolean answer_was_correct() {
        announce("Answer was correct!!!!");
        purses[currentPlayer]++;
        announce(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}