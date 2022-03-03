package workshop.triviagame;
import java.util.List;


public class TriviaGame {
    private List<playerDetails> players;
    private QuestionManager Questions;

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    public TriviaGame(QuestionManager Questions) {
        this.Questions = Questions;
    }

    public boolean add(String playerName) {
        players.add(new playerDetails(playerName, 0, 0, false));

        announce(playerName + " was added");
        announce( "They are player number " + players.size());
        return true;
    }

    private playerDetails getCurrentplayer(){
        return players.get(currentPlayer);
    }

    private boolean check_not_gettingout(int roll) {
        return getCurrentplayer().isInPenaltyBox() && (roll % 2 == 0);
    }

    public void roll(int roll) {
        announce( getCurrentplayer().getPlayerName()+ " is the current player");
        announce( "They have rolled a " + roll);
        roll_process(roll);
    }

    private void roll_process(int roll) {
        if(check_not_gettingout(roll)){
            announce( getCurrentplayer().getPlayerName()+ " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
        else {
            if(getCurrentplayer().isInPenaltyBox()) {
                isGettingOutOfPenaltyBox = true;
                announce( getCurrentplayer().getPlayerName()+ " is getting out of the penalty box");
            }
            update_location(roll);
        }
    }

    private void update_location(int roll) {
        getCurrentplayer().incrementPlaces(roll);
        announce(getCurrentplayer().getPlayerName() + "'s new location is "    + getCurrentplayer().getPlaces());

        int player_place = getCurrentplayer().getPlaces();
        announce( "The category is " + Questions.currentCategory(player_place));
        Questions.askQuestion(getCurrentplayer().getPlaces());
    }

    private boolean check_not_correctanswer() {
        return getCurrentplayer().isInPenaltyBox() && !isGettingOutOfPenaltyBox;
    }

    public boolean wasCorrectlyAnswered() {
        if(check_not_correctanswer()){
            update_currentPlayer();
            return true;
        }
        else return answer_was_correct();
    }

    private boolean answer_was_correct() {
        announce("Answer was correct!!!!");
        getCurrentplayer().incrementPurses(1);
        announce( getCurrentplayer().getPlayerName()+ " now has " + getCurrentplayer().getPurses() + " Gold Coins.");
        update_currentPlayer();
        return didPlayerWin();
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(getCurrentplayer().getPlayerName()+ " was sent to the penalty box");
        getCurrentplayer().setInPenaltyBox(true);
        update_currentPlayer();
        return true;
    }

    private void update_currentPlayer(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    private boolean didPlayerWin() {
        return !(getCurrentplayer().getPurses() == 6);
    }
    protected void announce(Object message) {
        System.out.println(message);
    }
}