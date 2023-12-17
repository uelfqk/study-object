package ticket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfficeTest {

    @Test
    void getTicketTest() throws Exception {
        // given
        TicketOffice ticketOffice = new TicketOffice(50000L, new Ticket(1000L), new Ticket(2000L));

        // when
        Ticket ticket = ticketOffice.getTicket();

        //then
    }

    @Test
    void minusAmount() throws Exception {
    }

    @Test
    void plusAmount() throws Exception {
    }
}