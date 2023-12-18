package chapter_01;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        System.out.println("--- 초대장 확인 중");

        if(bag.hasInvitation()) {
            bag.setTicket(ticket);
            System.out.println("--- 초대장 확인 완료 - 티켓 교환");
            return 0L;
        }

        System.out.println("--- 초대장 없음으로 티켓 구매 중");

        bag.minusAmount(ticket.getFee());
        bag.setTicket(ticket);

        return ticket.getFee();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }
}
