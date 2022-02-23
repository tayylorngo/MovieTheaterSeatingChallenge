
public class MovieTheaterSeatingTests {
    public MovieTheaterSeatingTests(){}

    /***
     * Test 1 - Reservation with 0 tickets
     */
    public void zeroTicketReservation(){
        System.out.println(Main.writeToFile(Main.assignSeats(Main.readFile("tests/test1.txt")), "outputTest1.txt"));
    }

    /***
     * Test 2 - Reservation when theater is full
     */
    public void fullTheaterReservation(){
        System.out.println(Main.writeToFile(Main.assignSeats(Main.readFile("tests/test2.txt")), "outputTest2.txt"));
    }

    /***
     * Test 3 - Reservations to test buffer seating
     */
    public void bufferTesting(){
        System.out.println(Main.writeToFile(Main.assignSeats(Main.readFile("tests/test3.txt")), "outputTest3.txt"));
    }

    /***
     * Test 4 - Reservations to test dividing tickets to fill any empty seating
     */
    public void testDividingTickets(){
        System.out.println(Main.writeToFile(Main.assignSeats(Main.readFile("tests/test4.txt")), "outputTest4.txt"));
    }

    /***
     * Test 5 - Reservations for a normal case
     */
    public void testNormalCase(){
        System.out.println(Main.writeToFile(Main.assignSeats(Main.readFile("tests/test5.txt")), "outputTest5.txt"));
    }
}
