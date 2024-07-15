package model.payment;

import java.time.LocalDateTime;

abstract class Payment{
    abstract int calculatePayment(LocalDateTime dt);
}
