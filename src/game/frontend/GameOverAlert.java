package game.frontend;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class GameOverAlert extends Alert {

    public GameOverAlert(String state, Stage stage, Scene scene) {
        super(AlertType.CONFIRMATION);
        setTitle("Game over!");
        setHeaderText(state);
        setContentText("¿Volver al menú principal?");
        Optional<ButtonType> result = showAndWait();
        if(result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                stage.setScene(scene);
            } else {
                Platform.exit();
            }
        }

    }
}
