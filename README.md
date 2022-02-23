# Movie Theater Seating Challenge

## Language: Java

## Description
The program takes a path to an input file from the command line argument, and reads
it line by line to process user requests for reserving seats in a movie theater.

The algorithm works as follows:
1. The algorithm will first sort all the reservations from the most seats requested to least to achieve maximum customer
satisfaction.
   
2. Go through each of the reservations starting from the highest number of seats to the lowest and loop through each of the rows (starting from the last row) until there
is a row that can fit the requested number of seats.
    1. Process the seats, and add the seat numbers to the results of the reservation object. 
    2. Update the array representing the theater rows and subtract three seats for the buffer.
    3. Add the reservation ticket to the results array
    4. If there are no rows that satisfy the request, go through each row and fill the maximum number of seats available until the reservation 
       is fulfilled.

3. When the priority queue is empty, that means all the reservations have been fulfilled.
    1. Sort the results array by the reservation name i.e R001, R002, ...
    2. Write the formatted results to output.txt file and return the absolute path of the file.
    
## Assumptions
1. The order of the reservations does not matter.
    1. Customers will be seated together and then the buffer will be created for following reservations.
    2. In order to satisfy the maximum number of customers, those with the higher number 
    of seats per reservation will be seated first to avoid fragmentation and to fill up the
       maximum number of seats per row.
       
2. The seats at the back of the theater are of higher priority in terms of customer satisfaction
    1. Row J will be seated first, while Row A will be prioritized last.
    
3. The seating will not exceed the current capacity of the theater.
    1. There will not exist a reservation that is greater than the 
    capacity of the theater. 
       i.e If the current capacity is 50 seats, there will be no reservation that will be greater than 50 seats.
       
## Customer Satisfaction
1. By seating the highest number of seat tickets first, it will maximize the number of satisfied 
   customers which will get to sit in the back. Furthermore, because of public safety, it limits the buffer that can affect seating.
   <br /> <br />
   O - Empty Seat <br /> X - Filled Seat <br /> # - Buffer
   <br /> <br />
   Take this row for example: [O O O O O O O O O O]
   <br /> <br />
   If two people are seated in one reservation:
   <br />
    [X X # # # O O O O O] - Five Seats Left
   <br /> <br />
   If two people sit on different reservations:
   <br />
   [X # # # X # # # O O] - Two Seats Left
   <br /> <br />
2. Customer Satisfaction is achieved by placing the most people at the back of the theater and then working 
towards the front of the theater.
3. Being seated together is the first priority, which is followed by seat position (which row).

## How To Run
1. Download the files in the src directory and save to same location.
2. Navigate to the location of the files in the command line. <br/> <br/>   
3. Compile all the files using: <br/> javac Main.java <br/> <br/>
4. Run the program with: <br/> java Main [location of input.txt]
   <br/> <br/>
5. The program will create a new file output.txt and print the absolute path of output.txt

## Run Test Cases
1. Download the files in the src directory and save to same location.
2. Navigate to the location of the files in the command line. <br/> <br/>
3. Compile all the files using: <br/> javac Main.java <br/> <br/>
4. Run the program with: <br/> java Main tests
   <br/> <br/>
5. The program will run the test files and print the paths of the output files. 