package chapter_01;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        System.out.println("--- 초대장을 확인합니다.");
        Ticket ticket = ticketOffice.getTicket();
        Long amount = audience.buy(ticket);
        ticketOffice.plusAmount(amount);
    }
}
