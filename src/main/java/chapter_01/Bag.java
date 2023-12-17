package chapter_01;

public class Bag {

    private Long amount;

    private Invitation invitation;

    private Ticket ticket;

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getAmount() {
        return amount;
    }

    public void minusAmount(Long amount) {
        if(isDontSell()) {
            throw new IllegalArgumentException("[ERROR] 소지금이 부족해 티켓을 구매할 수 없습니다.");
        }

        this.amount -= amount;
    }

    private boolean isDontSell() {
        return this.amount <= 0;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
