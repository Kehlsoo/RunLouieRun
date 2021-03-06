package application.main;

import java.io.IOException;

import application.game.AssetLoader;
import application.game.Game;
import application.game.SoundManager;
import application.game.StatsManager;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;

/**
 * This is the fx:controller class which links the scene builder members from
 * the MainMenuStyle.fxml file to code within this class.
 * 
 * @author Nabeel Vali
 * @author Khelsey Lewis
 * @author Andrew Freiman
 * @version Winter 2018
 */

public class MainMenuController {

	/** Buttons to start and exit the game. **/
	@FXML
	private Button startButton, exitButton, helpButton, storeButton;
	
	/** Starting louie character.**/
	@FXML
	private ImageView startCharImage;

	/** Sound manager to manage the start menu sound. **/
	private SoundManager soundManager;

	/** Asset Manager.**/
	private AssetLoader assetLoader;

	
	/******************************************************************
	 * This method is called after all @FXML annotated members have been
	 * injected.
	 *****************************************************************/
	@FXML
	private void initialize() {
		soundManager = new SoundManager();
		assetLoader = new AssetLoader();
		soundManager.playSound(SoundManager.Sounds.MainMenu);
		startCharImage.setImage(new Image(StatsManager.getEquippedItem().
				getImage() + "0.png"));

		//If the start button is hit will start new game
		startButton.setOnAction(e -> {
			
			Game game = new Game();
		
			Main.setScene(game.getGameScene());
			soundManager.stopSound();
		});

		//If the help button is hit will take to help menu
		helpButton.setOnAction(e -> {

			try {
				Parent root = FXMLLoader.load(
						getClass().
						getResource(
						"helpMenu.fxml"));

				Scene mainMenuScene = new Scene(root, 
						assetLoader.getWinWidth(), 
						assetLoader.getWinHeight());
				Main.setScene(mainMenuScene);
				soundManager.stopSound();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		storeButton.setOnAction(e -> {
			try {
				Parent root = FXMLLoader.load(
						getClass().
						getResource(
								"laker_store.fxml"));
				Scene mainMenuScene = new Scene(root,
						assetLoader.getWinWidth(),
						assetLoader.getWinHeight());
				Main.setScene(mainMenuScene);
				soundManager.stopSound();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
}
