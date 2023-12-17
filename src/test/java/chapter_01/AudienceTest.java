package chapter_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudienceTest {

    @Test
    @DisplayName("초대장 없음 - 구매 성공 테스트")
    void 초대장_없음_구매_성공_테스트() throws Exception {
        // given
        Bag bag = new Bag(1000L);
        Audience audience = new Audience(bag);

        // when
        Long amount = audience.buy(new Ticket(1000L));

        // then
        Assertions.assertThat(amount).isEqualTo(1000L);
        Assertions.assertThat(audience.hasTicket()).isTrue();
    }

    @Test
    @DisplayName("초대장 소지 - 구매 성공 테스트")
    void 초대장_소지_구매_성공_테스트() throws Exception {
        // given
        Bag bag = new Bag(1000L, new Invitation());
        Audience audience = new Audience(bag);

        // when
        Long amount = audience.buy(new Ticket(1000L));

        // then
        Assertions.assertThat(amount).isEqualTo(0L);
        Assertions.assertThat(audience.hasTicket()).isTrue();
    }

    @Test
    @DisplayName("소지금 부족 - 구매 실패 테스트")
    void 구매_실패_테스트_소지금_부족() throws Exception {
        // given
        Bag bag = new Bag(0L);
        Audience audience = new Audience(bag);

        // when then
        Assertions.assertThatThrownBy(() -> audience.buy(new Ticket(1000L)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}