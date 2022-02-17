package workshop.triviagame;


public class playerDetails{
    private int places;


    private int purses;
    private String playerName;

    public playerDetails(String playerName){
        this.playerName = playerName;
    }
    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
    public void incrementPlaces(int number){
        this.places += number;
        if (this.places > 11) this.places -= 12;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public void incrementPurses(int number){
        this.purses += number;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }




}