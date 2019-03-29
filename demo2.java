import javafx.application.Application;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.*;

public class demo2 extends Application {

	//initializes player speed
	public AnimationTimer atimer;
	private Label deadL = new Label("GAMEOVER");
	private Label moneycounter = new Label("$: ");
	private int counter = 0;
	private char move;
	boolean isItOverYet = false;

    //#################################
    private Player user;
    private Gamemap1 gamemap = new Gamemap1();
		private int isItValid = 0;
    //#################################

		public String enemySpriteLocation = "https://i.gyazo.com/dc7a81caa79fbae63b1f32e103d8bac0.png";
		Image enemySprite = new Image(enemySpriteLocation, 46, 85, false, false);
		public Node enemy1 = new ImageView(enemySprite);

    public String bagOfCoins = "https://i.gyazo.com/d2b097f96fbcca37008ebfac4bb0c121.png";
    Image coinsSprite = new Image(bagOfCoins, 46, 85, false, false);
    public Node coins1 = new ImageView(coinsSprite);

    private TextField tf;

    //player sprite link and sets it up
    public String playerSpriteLocation = "https://i.gyazo.com/12f04f301ecc6634b9bfa58a2b05364a.png";
    Image playerSprite = new Image(playerSpriteLocation);
		public Node player1 = new ImageView(playerSprite);

	// direction Direction
	Direction whichDirection = Direction.NONE;
	//initializes second gamestage
	private Stage deadStage = new Stage();
	private Stage gameStage = new Stage();
    // CONSTRUCTORS
    public demo2() {}

    public static void main(String[] args) {
    	launch(args);
        }

    public void start (Stage stage) {
        BorderPane pane = new BorderPane();

        VBox vb = new VBox();
        Label label1 = new Label("Welcome to the Game");
         //"Recover the treasure! It's our only hope of escaping the life of poor students everywhere! "
        vb.getChildren().add(label1);
        vb.setAlignment(Pos.CENTER);
        pane.setTop(vb);
				pane.setStyle("-fx-background-color: red");
				label1.setStyle("-fx-text-fill: black; -fx-font-size: 40px;");

        HBox hb = new HBox();
        Button b1 = new Button("Start");
        Button b2 = new Button("Settings");
        Button b3 = new Button("Exit");
        hb.getChildren().add(b1);
        hb.getChildren().add(b2);
        hb.getChildren().add(b3);
        hb.setAlignment(Pos.CENTER);
        pane.setCenter(hb);

        //on button press start uses gameStage here as parameter to in method
        //actualGame to start new stage
        b1.setOnAction(e -> {
        	stage.close();
        	actualGame(gameStage);
        });

				b3.setOnAction(e -> {
					stage.close();
				});


        Scene scene = new Scene(pane, 400, 200);
        stage.setTitle("Demo 3");
        stage.setScene(scene);
        stage.show();
    }

    // stage that will have actual game in it, created by b1.setOnAction

   public void actualGame(Stage gameStage){
		 setStartConditions();
		 Group gamePane = new Group(player1, coins1, enemy1, moneycounter);
	   Scene gameScene = new Scene(gamePane, 46*20, 85*10);


	   //starts moving player, added links to sprites of player facing different directions
	   //not sure how to implement them yet
	   gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		   public void handle(KeyEvent pressed){


			   if(pressed.getCode() == KeyCode.W){
				   whichDirection = Direction.UP;
			   }
			   else if(pressed.getCode() == KeyCode.A){
				   whichDirection = Direction.LEFT;
			   }
			   else if(pressed.getCode() == KeyCode.S){
				   whichDirection = Direction.DOWN;
			   }
			   else if(pressed.getCode() == KeyCode.D){
				   whichDirection = Direction.RIGHT;

			   }

		   }
	   }

   );

	   // stops the player once key is released
	   gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		   public void handle(KeyEvent lifted){
		   if(lifted.getCode()== KeyCode.W){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.A){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.S){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.D){
			   whichDirection = Direction.NONE;
		   }
		   else{
			   whichDirection = Direction.NONE;
		   }

	   }
	   });

		 moneycounter.setStyle("-fx-font-size: 40px;");
	   gameStage.setTitle("Demo 2");
	   gameStage.setScene(gameScene);
	   gameStage.show();

	   //determines speed of player
	   AnimationTimer timer = new AnimationTimer() {
			 			private long lastMapUpdate = 0;
           @Override
           public void handle(long now) {
						 if(now - lastMapUpdate >= 28_000_000){
						int x = 0;
						int y = 0;
						if (whichDirection != Direction.NONE) {

							Direction enemyMove = gamemap.getEnemy().getMove(gamemap.getPlayer());
							isItValid = gamemap.isValid(gamemap.getEnemy().getLocation(), enemyMove, false);
							if (isItValid == 2) {
								gamemap.moving(enemyMove, false);
								x = gamemap.getEnemy().getLocation().getX();
								y = gamemap.getEnemy().getLocation().getY();
								enemy1.relocate(x*46 - 46, y*85 - 85);

							} else if (isItValid == 3) {
								setStartConditions();
						 		gameStage.close();
								gameOver(deadStage);
								System.out.println("Awww you got caught, try again next time.");
							}

							int isItValid = gamemap.isValid(gamemap.getPlayer().getLocation(), whichDirection, true);
							if (isItValid == 2) {
								gamemap.moving(whichDirection, true);
								x = gamemap.getPlayer().getLocation().getX();
								y = gamemap.getPlayer().getLocation().getY();
								player1.relocate(x*46 - 46, y*85 - 85);



							} else if (isItValid == 1) {
								counter++;
                moneycounter.setText("$: " + Integer.toString(counter));
								System.out.println("Congratulations you found a bag of gold!");
								setStartConditions();
								isItValid = 0;
							}
						}



						lastMapUpdate = now;
						}
           }
       };
       timer.start();

   }

	 public void gameOver(Stage deadStage){
       deadL.setStyle("-fx-font-size: 80px;");
       BorderPane gamePane = new BorderPane(deadL);
       Scene gameScene = new Scene(gamePane, 800, 400);
       gamePane.setStyle("-fx-background-color: red");
       deadL.setAlignment(Pos.CENTER);
       deadStage.setTitle("Demo 2");
       deadStage.setScene(gameScene);
       deadStage.show();
   }
	 //multiple screens maybe, add more obstacles in new stages maybe, settings to fuck with AI
	public void setStartConditions() {
		player1.relocate(0, 0);
		gamemap.getPlayer().getLocation().setX(1);
		gamemap.getPlayer().getLocation().setY(1);
		gamemap.getEnemy().getLocation().setX(20);
		gamemap.getEnemy().getLocation().setY(10);
		//enemy1.relocate(gamemap.getEnemy().getLocation().getX()*46, gamemap.getEnemy().getLocation().getY()*85);
		enemy1.relocate(19*46, 9*85);
		Random randomObj = new Random();
		int randomX = randomObj.nextInt(20);
		int randomY = randomObj.nextInt(10);
		coins1.relocate(randomX*46, randomY*85);
		gamemap.setLootLocation(randomX + 1, randomY + 1);
	}
//moves the player by gettings its sizes and adding its dimensions to it by using java
//if the player moves out of the window the player respawns in a random grid on the gap
// method relocate
	public void movingGUI(int speedx, int speedy){
		double xcord = player1.getLayoutX() + speedx;
		double ycord = player1.getLayoutY() + speedy;
		if(xcord >= 0 && ycord>=0 && xcord<46*20 && ycord <= 85*10){
			player1.relocate(xcord,ycord);
		}
		else{
			Random randomObj = new Random();
			int randomX = randomObj.nextInt((20+1));
			int randomY = randomObj.nextInt((10+1));

			player1.relocate(randomX*46,randomY*10);


		}

	}
}
