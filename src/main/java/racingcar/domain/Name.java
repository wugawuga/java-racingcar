package racingcar.domain;

import java.util.Objects;

/**
 * @author 우가
 * @version 1.0.0
 * @since by 우가 on 2023/04/03
 */
public class Name {

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name == null || (name.length() < 1 || name.length() > 5)) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자만 가능합니다");
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
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
