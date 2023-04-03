package racingcar.domain;

import java.util.Objects;

/**
 * @author 우가
 * @version 1.0.0
 * @since by 우가 on 2023/04/03
 */
public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 음수가 될 수 없습니다");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public Position increase() {
        return new Position(position + 1);
    }
}
