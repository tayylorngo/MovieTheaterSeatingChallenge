import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(args[0].equals("test")){
            runTests();
            return;
        }
        System.out.println(writeToFile(assignSeats(readFile(args[0])), "output.txt"));
    }

    public static ArrayList<Reservation> readFile(String fileName){
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(" ");
                Reservation reservation = new Reservation(line[0], Integer.parseInt(line[1]));
                reservations.add(reservation);
            }
            reservations.sort(new Comparator<Reservation>() {
                @Override
                public int compare(Reservation o1, Reservation o2) {
                    return Integer.compare(o2.getSeats(), o1.getSeats());
                }
            });
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return reservations;
    }

    public static ArrayList<Reservation> assignSeats(ArrayList<Reservation> reservations) {
        ArrayList<Reservation> results = new ArrayList<Reservation>();
        TheaterRow[] theater = new TheaterRow[10];
        for (int i = 0; i < theater.length; i++) {
            theater[i] = new TheaterRow((char) (i + 65), 20);
        }
        for (Reservation reservation : reservations) {
            boolean found = false;
            for (int i = theater.length - 1; i >= 0; i--) {
                if (reservation.getSeats() <= theater[i].getNumSeats()) {
                    for (int j = 0; j < reservation.getSeats(); j++) {
                        String ticket = "" + ((char) (i + 65)) + (20 - theater[i].getNumSeats() + 1);
                        reservation.addResult(ticket);
                        theater[i].removeSeats(1);
                    }
                    theater[i].removeSeats(3);
                    found = true;
                    break;
                }
            }
            if(!found){
                int seats = reservation.getSeats();
                for(int i = theater.length - 1; i >= 0; i--) {
                    boolean seating = false;
                    while(theater[i].getNumSeats() > 0 && seats > 0){
                        String ticket = "" + ((char) (i + 65)) + (20 - theater[i].getNumSeats() + 1);
                        reservation.addResult(ticket);
                        theater[i].removeSeats(1);
                        seats--;
                        seating = true;
                    }
                    if(seating){
                        theater[i].removeSeats(3);
                    }
                }
            }
            results.add(reservation);
        }
        results.sort(new Comparator<Reservation>() {
            @Override
            public int compare(Reservation o1, Reservation o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return results;
    }

    public static String writeToFile(ArrayList<Reservation> reservations, String outputFileName) {
        try {
            File newFile = new File(outputFileName);
            FileWriter fw = new FileWriter(newFile);
            PrintWriter pw = new PrintWriter(fw);
            for(Reservation reservation : reservations){
                pw.println(reservation.resultsFormat());
            }
            fw.close();
            pw.close();
            return newFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void runTests(){
        MovieTheaterSeatingTests movieTheaterSeatingTests = new MovieTheaterSeatingTests();
        movieTheaterSeatingTests.zeroTicketReservation();
        movieTheaterSeatingTests.fullTheaterReservation();
        movieTheaterSeatingTests.bufferTesting();
        movieTheaterSeatingTests.testDividingTickets();
        movieTheaterSeatingTests.testNormalCase();
    }
}
