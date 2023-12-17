package ticket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

    @Test
    @DisplayName("티켓 생성 테스트")
    void createTicketTest() throws Exception {
        // given
        Ticket ticket = new Ticket(1000L);

        // when then
        Assertions.assertThat(ticket.getFee()).isEqualTo(1000);
    }
}
