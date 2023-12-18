package chapter_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketOfficeTest {

    @Test
    @DisplayName("티켓 발급 성공 테스트")
    void 티켓_발급_성공_테스트() throws Exception {
        // given
        TicketOffice ticketOffice = new TicketOffice(50000L, new Ticket(1000L));

        // when
        Ticket ticket = ticketOffice.getTicket();

        // then
        Assertions.assertThat(ticket).isNotNull();
    }

    @Test
    @DisplayName("티켓 발급 실패 테스트 (티켓 부스에 남은 티켓 없음)")
    void 티켓_발급_실패_테스트() throws Exception {
        // given
        TicketOffice ticketOffice = new TicketOffice(50000L);

        // when then
        Assertions.assertThatThrownBy(() -> ticketOffice.getTicket())
                .isInstanceOf(IllegalArgumentException.class);
    }
}