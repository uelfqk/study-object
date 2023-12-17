package chapter_01;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TicketOffice ticketOffice = new TicketOffice(50000L, new Ticket(1000L), new Ticket(1000L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Theater theater = new Theater(ticketSeller);

        Bag bag = new Bag(10000L, new Invitation());
        Audience audience = new Audience(bag);

        theater.enter(audience);
    }
}
