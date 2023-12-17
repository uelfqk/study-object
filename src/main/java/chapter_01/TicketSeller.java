package chapter_01;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        System.out.println("관중 입장 시작");
        System.out.println("--- 초대장 확인 중");

        if(audience.getBag().hasInvitation()) {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
            System.out.println("초대장 확인 - 표 발급");
            return;
        }

        Ticket ticket = ticketOffice.getTicket();
        audience.getBag().minusAmount(ticket.getFee());
        ticketOffice.plusAmount(ticket.getFee());
        audience.getBag().setTicket(ticket);

        System.out.println("표 발급");
    }
}
