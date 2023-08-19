package org.example.Week11;
public class FestivalAttendeeThread extends Thread{
    TicketType ticketType;
    FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
            gate.addTicket(ticketType);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
