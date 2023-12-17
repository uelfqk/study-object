package chapter_01;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        System.out.println("관중 입장 시작");
        ticketSeller.sellTo(audience);
    }
}
