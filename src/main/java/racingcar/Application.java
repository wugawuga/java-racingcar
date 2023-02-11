package racingcar;

import java.util.List;
import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.startRacing();

        RacingcarService service = getService();
        RacingcarController controller = getController(service);

        int tryCount = getTryCount();

        controller.run(tryCount);
    }

    private static int getTryCount() {
        OutputView.tryCount();

        return InputView.tryCount();
    }

    private static RacingcarController getController(RacingcarService service) {
        return new RacingcarController(service);
    }

    private static RacingcarService getService() {
        try {
            List<String> carNames = InputView.carNames();

            return new RacingcarService(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return getService();
        }
    }
}
