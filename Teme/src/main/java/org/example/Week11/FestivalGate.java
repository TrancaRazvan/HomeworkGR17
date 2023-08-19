package org.example.Week11;
import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate{
   static Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(TicketType ticket) throws InterruptedException {
        ticketQueue.add(ticket);
        System.out.println("added : " + ticket);
        notifyAll();
    }
    public synchronized TicketType readData() throws InterruptedException {
        return ticketQueue.poll();
    }
}
