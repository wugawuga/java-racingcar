package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author 우가
 * @version 1.0.0
 * @since by 우가 on 2023/04/03
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @Test
    void 음수값일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("포지션은 음수가 될 수 없습니다");
    }

    @Test
    void 기본_생성시_포지션은_0이다() {
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    void 포지션은_1씩_증가할_수_있다() {
        Position position = new Position();

        assertThat(position.increase()).isEqualTo(new Position(1));
    }

}
