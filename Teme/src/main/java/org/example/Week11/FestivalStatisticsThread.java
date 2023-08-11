package org.example.Week11;



public class FestivalStatisticsThread extends Thread {
    FestivalGate gate;


    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                sleep(5000);
                while (true) {
                    TicketType ticketType = gate.readData();
                    if (ticketType == null) {
                        break;
                    }
                    System.out.println("consumer : " + ticketType);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
