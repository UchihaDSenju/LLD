package model.payment;

import java.time.LocalDateTime;
import java.time.Period;

import model.Ticket;

public class BikePayment extends Payment{

    @Override
    int calculatePayment(Ticket t) {
        int calc = 0;
        LocalDateTime entry = t.getEntryTime();
        LocalDateTime exit = LocalDateTime.now();
        int amountPayable = (exit.getMinute()*60 + exit.getSecond()) - (entry.getMinute()*60 + exit.getSecond());
        return amountPayable;
    }

}