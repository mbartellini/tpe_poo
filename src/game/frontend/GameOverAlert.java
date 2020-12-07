package game.frontend;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class GameOverAlert extends Alert {

    public GameOverAlert(String state) {
        super(AlertType.CONFIRMATION);
        setTitle("Game over!");
        setHeaderText(state);
        setContentText("Back to main menu?");
    }
}
