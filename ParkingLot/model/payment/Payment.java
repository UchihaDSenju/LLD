package model.payment;
import model.*;
import java.time.LocalDateTime;

abstract class Payment{
    abstract int calculatePayment(Ticket t);
}
