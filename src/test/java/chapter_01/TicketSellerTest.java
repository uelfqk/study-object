package chapter_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketSellerTest {

    @Test
    @DisplayName("초대장 없는 관람객의 티켓 판매 성공 테스트")
    void 초대장_없는_관람객의_티켓_판매_성공_테스트() {
        // given
        TicketOffice ticketOffice = new TicketOffice(5000L, new Ticket(1000L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Bag bag = new Bag(1000L, null);
        Audience audience = new Audience(bag);

        // when
        ticketSeller.sellTo(audience);

        // then
        Assertions.assertThat(audience.getBag().hasTicket()).isTrue();
        Assertions.assertThat(audience.getBag().getAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("초대장 없는 관람객의 티켓 판매 소지금액 부족 실패 테스트")
    void 초대장_없는_관람객의_티켓_판매_소지금액_부족_실패_테스트() {
        // given
        TicketOffice ticketOffice = new TicketOffice(5000L, new Ticket(1000L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Bag bag = new Bag(0L, null);
        Audience audience = new Audience(bag);

        // when then
        Assertions.assertThatThrownBy(() -> ticketSeller.sellTo(audience))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("초대장 없는 관람객의 티켓 판매 티켓 부족 실패 테스트")
    void 초대장_없는_관람객의_티켓_판매_티켓_부족_실패_테스트() {
        // given
        TicketOffice ticketOffice = new TicketOffice(5000L);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Bag bag = new Bag(0L, null);
        Audience audience = new Audience(bag);

        // when then
        Assertions.assertThatThrownBy(() -> ticketSeller.sellTo(audience))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("초대장 가진 관람객의 티켓 판매 성공 테스트")
    void 초대장_가진_관람객의_티켓_판매_성공_테스트() {
        // given
        TicketOffice ticketOffice = new TicketOffice(5000L, new Ticket(1000L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Bag bag = new Bag(1000L, new Invitation());
        Audience audience = new Audience(bag);

        // when
        ticketSeller.sellTo(audience);

        // then
        Assertions.assertThat(audience.getBag().hasTicket()).isTrue();
        Assertions.assertThat(audience.getBag().getAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("초대장 가진 관람객의 티켓 판매 실패 테스트")
    void 초대장_가진_관람객의_티켓_판매_실패_테스트() {
        // given
        TicketOffice ticketOffice = new TicketOffice(5000L);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Bag bag = new Bag(1000L, new Invitation());
        Audience audience = new Audience(bag);

        // when then
        Assertions.assertThatThrownBy(() -> ticketSeller.sellTo(audience))
                .isInstanceOf(IllegalArgumentException.class);
    }
}