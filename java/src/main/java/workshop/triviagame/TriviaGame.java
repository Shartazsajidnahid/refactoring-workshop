package workshop.triviagame;
import java.util.ArrayList;
import java.util.List;


public class TriviaGame {
    List<playerDetails> playerDetailsList;
    ListOfQuestions listofquestions;

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame(ListOfQuestions listOfQuestions, List<playerDetails> playerDetailsList) {
        this.listofquestions = listOfQuestions;
        this.playerDetailsList = playerDetailsList;
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {
       // players.add(playerName);
        playerDetailsList.add(new playerDetails(playerName));
        playerDetailsList.get(playerDetailsList.size()).setPlaces(0);
        playerDetailsList.get(playerDetailsList.size()).setPurses(0);
        playerDetailsList.get(playerDetailsList.size()).setInPenaltyBox(false);

        System.out.println(playerName + " was added");
        System.out.println( "They are player number " + playerDetailsList.size());
        return true;
    }

    private boolean check_not_gettingout(int roll) {
        return playerDetailsList.get(currentPlayer).isInPenaltyBox() && (roll % 2 == 0);
    }

    public void roll(int roll) {
        System.out.println( playerDetailsList.get(currentPlayer).getPlayerName()+ " is the current player");
        System.out.println( "They have rolled a " + roll);
        roll_process(roll);
    }

    private void roll_process(int roll) {
        if(check_not_gettingout(roll)){
            System.out.println( playerDetailsList.get(currentPlayer).getPlayerName()+ " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
        else {
            if(playerDetailsList.get(currentPlayer).isInPenaltyBox()) {
                isGettingOutOfPenaltyBox = true;
                System.out.println( playerDetailsList.get(currentPlayer).getPlayerName()+ " is getting out of the penalty box");
            }
            update_location(roll);
        }
    }

    private void update_location(int roll) {
        playerDetailsList.get(currentPlayer).incrementPlaces(roll);
        System.out.println(playerDetailsList.get(currentPlayer).getPlayerName() + "'s new location is "    + playerDetailsList.get(currentPlayer).getPlaces());
        System.out.println( "The category is " + listofquestions.currentCategory(playerDetailsList.get(currentPlayer).getPlaces()));
        listofquestions.askQuestion(playerDetailsList.get(currentPlayer).getPlaces());
    }

    private boolean check_not_correctanswer() {
        return playerDetailsList.get(currentPlayer).isInPenaltyBox() && !isGettingOutOfPenaltyBox;
    }

    public boolean wasCorrectlyAnswered() {
        if(check_not_correctanswer()){
            currentPlayer++;
            if (currentPlayer == playerDetailsList.size()) currentPlayer = 0;
            return true;
        }
        else return answer_was_correct();
    }

    private boolean answer_was_correct() {
        System.out.println("Answer was correct!!!!");
        playerDetailsList.get(currentPlayer).incrementPurses(1);
        System.out.println( playerDetailsList.get(currentPlayer).getPlayerName()+ " now has " + playerDetailsList.get(currentPlayer).getPurses() + " Gold Coins.");
        currentPlayer++;
        if (currentPlayer == playerDetailsList.size()) currentPlayer = 0;
        return didPlayerWin();
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println((playerDetailsList.get(currentPlayer).getPlayerName()+ " was sent to the penalty box"));
        playerDetailsList.get(currentPlayer).setInPenaltyBox(true);
        currentPlayer++;
        if (currentPlayer == playerDetailsList.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(playerDetailsList.get(currentPlayer).getPurses() == 6);
    }
}