package game.frontend;

import game.backend.CandyGame;
import game.backend.level.LevelGenerator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LevelButton extends Button {

    private final Class<? extends LevelGenerator> level;

    public LevelButton(String text, Class<? extends LevelGenerator> level, Stage stage) {
        super();
        setText(text);
        this.level = level;
        setOnAction(event ->{
            CandyGame game = new CandyGame(level);
            CandyFrame frame = new CandyFrame(game);
            Scene scene = new Scene(frame);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        });
    }

}
