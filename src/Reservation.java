import java.util.ArrayList;

public class Reservation{
    private final String name;
    private final int seats;
    private final ArrayList<String> results;

    public Reservation(String name, int seats){
        this.name = name;
        this.seats = seats;
        results = new ArrayList<String>();
    }

    public void addResult(String ticket){
        results.add(ticket);
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public int getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Name: " + this.name + "\nSeats: " + this.seats;
    }

    public String resultsFormat(){
        StringBuilder s = new StringBuilder(name + " ");
        for(int i = 0; i < results.size(); i++){
            s.append(results.get(i));
            if(i != results.size() - 1){
                s.append(", ");
            }
        }
        return s.toString();
    }

}
