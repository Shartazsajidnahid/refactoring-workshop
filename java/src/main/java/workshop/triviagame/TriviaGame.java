package workshop.triviagame;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    ListOfQuestions listofquestions;

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame(ListOfQuestions listOfQuestions) {
        this.listofquestions = listOfQuestions;
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

        System.out.println(playerName + " was added");
        System.out.println( "They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    private boolean check_not_gettingout(int roll) {
        return inPenaltyBox[currentPlayer] && (roll % 2 == 0);
    }

    public void roll(int roll) {
        System.out.println( players.get(currentPlayer) + " is the current player");
        System.out.println( "They have rolled a " + roll);
        roll_process(roll);
    }

    private void roll_process(int roll) {
        if(check_not_gettingout(roll)){
            System.out.println( players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
        else {
            if(inPenaltyBox[currentPlayer]) {
                isGettingOutOfPenaltyBox = true;
                System.out.println( players.get(currentPlayer) + " is getting out of the penalty box");
            }
            update_location(roll);
        }
    }

    private void update_location(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)  + "'s new location is "    + places[currentPlayer]);
        System.out.println( ("The category is " + listofquestions.currentCategory(places[currentPlayer])));
        listofquestions.askQuestion(places[currentPlayer]));
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
        else return answer_was_correct();
    }

    private boolean answer_was_correct() {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println( players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println((players.get(currentPlayer) + " was sent to the penalty box"));
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

}