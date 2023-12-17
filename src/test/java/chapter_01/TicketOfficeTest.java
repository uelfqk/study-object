package chapter_01;

import org.junit.jupiter.api.Test;

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