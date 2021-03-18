package optional.interfaces;

/**
 * Interface that implements the price for a ticket
 **/
public interface Payable {
    double getTicketPrice();

    void setTicketPrice(double ticketPrice);
}
