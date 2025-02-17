package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarFactory;

class CarFactoryTest {

    @Test
    @DisplayName("입력값을 받아서 자동차 리스트 생성 확인")
    void makeCars() {
        List<Car> cars = CarFactory.makeCars(Arrays.asList("밀리", "우가"));

        assertThat(cars.get(0).getName()).isEqualTo("밀리");
        assertThat(cars.get(1).getName()).isEqualTo("우가");
    }
}
