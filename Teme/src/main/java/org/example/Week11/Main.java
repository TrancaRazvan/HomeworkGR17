package org.example.Week11;
import java.util.Random;

public class Main {
     static public void main(String[] args) throws InterruptedException {
         FestivalGate gate = new FestivalGate();
         FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
         statisticsThread.start();
         for (int i = 0; i < 15; i++) {
             TicketType ticketType = randomTicket();
             FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
             attendee.start();
             attendee.join();
         }

     }
    private static TicketType randomTicket(){
        int randomTicket = new Random().nextInt(TicketType.values().length);
        return TicketType.values()[randomTicket];
    }

}
