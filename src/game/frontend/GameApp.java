package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameApp extends Application {

	private static final String BG_IMAGE = "images/background.png";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		BorderPane borderPane = new BorderPane();

		// Tres botones de niveles horizontalmente dispuestos
		HBox hBox = new HBox();
		LevelButton level1 = new LevelButton("Level 1", Level1.class, stage);
		LevelButton level2 = new LevelButton("Level 2", Level2.class, stage);
		LevelButton level3 = new LevelButton("Level 3", Level3.class, stage);

		hBox.getChildren().addAll(level1, level2, level3);
		hBox.setSpacing(120);
		hBox.setAlignment(Pos.CENTER);
		BackgroundImage myBI = new BackgroundImage
				(new Image(BG_IMAGE),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
						BackgroundSize.DEFAULT);
		borderPane.setBottom(hBox);
		borderPane.setBackground(new Background(myBI));
		borderPane.setPadding(new Insets(10, 20, 50, 20));
		Scene scene = new Scene(borderPane, 600, 310);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
