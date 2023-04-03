package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

/**
 * @author 우가
 * @version 1.0.0
 * @since by 우가 on 2023/04/03
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    void 최소_1글자_최대5글자만_생성이_가능하다(final String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 비어있는값과_null값인경우_예외가_발생한다(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자만 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void 최소_1글자_최대5글자가_아닌경우_예외가_발생한다(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자만 가능합니다");
    }

}
