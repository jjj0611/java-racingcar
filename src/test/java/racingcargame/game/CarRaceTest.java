package racingcargame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceTest {

    private CarRace carRace;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        carRace = new CarRace(carList);
    }

    @Test
    @DisplayName("Cars 객체는 CarList로부터 생성")
    void createCarsFromCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        CarRace carRace = new CarRace(carList);
    }

    @Test
    @DisplayName("Cars객체는 중복된 리스트로 생성시 예외 발생")
    void createCarsWithDuplicateCarThrowingExrepsion() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("제이"));
        assertThatThrownBy(() -> new CarRace(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 경주게임이므로 자동차 개수가 2대 이하면 예외 발생")
    void createCarsWithLessThanTwoCarThrowingException() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        assertThatThrownBy(() -> new CarRace(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 경주는 시도 횟수를 받아서 실시")
    void runRounds() {
        carRace.run(5);
    }
}