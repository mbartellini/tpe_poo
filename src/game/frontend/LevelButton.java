package game.frontend;

import game.backend.CandyGame;
import game.backend.level.LevelGenerator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LevelButton extends Button {

    public LevelButton(String text, Class<? extends LevelGenerator> level, Stage parentStage) {
        setText(text);
        setOnAction(event -> {
            Stage levelStage = new Stage();
            CandyGame levelGame = new CandyGame(level);
            CandyFrame levelFrame = new CandyFrame(levelGame, levelStage);
            Scene levelScene = new Scene(levelFrame);

            levelStage.setResizable(false);
            levelStage.setScene(levelScene);
            levelStage.initModality(Modality.WINDOW_MODAL);
            levelStage.initOwner(parentStage);
            levelStage.show();
        });
    }

}
