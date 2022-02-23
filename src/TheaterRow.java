public class TheaterRow {
    private final char letter;
    private int numSeats;

    public TheaterRow(char letter, int numSeats){
        this.letter = letter;
        this.numSeats = numSeats;
    }

    public int getNumSeats(){
        return this.numSeats;
    }

    public void removeSeats(int seats){
        this.numSeats -= seats;
    }

    public String toString(){
        return letter + ": " + numSeats;
    }


}
