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

	private char move;

    //#################################
    private Player user;
    private Gamemap1 gamemap = new Gamemap1();

    //#################################

    public String bagOfCoins = "https://i.gyazo.com/d2b097f96fbcca37008ebfac4bb0c121.png";
    Image coinsSprite = new Image(bagOfCoins);
        public Node coins1 = new ImageView(coinsSprite);

    private TextField tf;

    //player sprite link and sets it up
    public String playerSpriteLocation = "https://i.gyazo.com/12f04f301ecc6634b9bfa58a2b05364a.png";
    Image playerSprite = new Image(playerSpriteLocation);
		public Node player1 = new ImageView(playerSprite);

	// direction Direction
	Direction whichDirection;
	//initializes second gamestage
	private Stage gameStage = new Stage();
    // CONSTRUCTORS
    public demo2() {}

    public static void main(String[] args) {
    	launch(args);
        }
    public void setPlayerSprite(Image ps){
    	player1 = new ImageView(ps);
    }
    public void start (Stage stage) {
        BorderPane pane = new BorderPane();

        VBox vb = new VBox();
        Label label1 = new Label("Welcome to the Game");
         //"Recover the treasure! It's our only hope of escaping the life of poor students everywhere! "
        vb.getChildren().add(label1);
        vb.setAlignment(Pos.CENTER);
        pane.setTop(vb);

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
        stage.setTitle("Demo 2");
        stage.setScene(scene);
        stage.show();
    }

    // stage that will have actual game in it, created by b1.setOnAction

   public void actualGame(Stage gameStage){
		 setLocations();
	   Group gamePane = new Group(player1, coins1);
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


	   gameStage.setTitle("Demo 2");
	   gameStage.setScene(gameScene);
	   gameStage.show();

	   //determines speed of player
	   AnimationTimer timer = new AnimationTimer() {
           @Override
           public void handle(long now) {
   		/*	int speedx = 0;
   			int speedy = 0;

   			   	if(whichDirection == Direction.UP){
							speedy = speedy - 85;
   			   	}
   			   	if(whichDirection == Direction.LEFT){
   			   		speedx = speedx - 46;
   			   	}
   			   	if(whichDirection == Direction.RIGHT){
   			   		speedx = speedx + 46;
   			   	}
   			   	if(whichDirection == Direction.DOWN){
   			   		speedy = speedy + 85;
   			   	}*/
						int x = 0;
						int y = 0;
						int isItValid = gamemap.isValid(gamemap.getPlayer().getLocation(), whichDirection);
						if (isItValid == 2) {
							gamemap.moving(whichDirection);
							x = gamemap.getPlayer().getLocation().getX();
							y = gamemap.getPlayer().getLocation().getY();
							player1.relocate(x*46 - 46, y*85 - 85);

						} /*else if (isItValid == 1) {
							isItValid = 2;
							System.out.println("Congratulations you found a bag of gold!");
							actualGame(gameStage);
						}*/

           }
       };
       timer.start();
   }

	public void setLocations() {
		player1.relocate(0 - 46,0 - 85);
		gamemap.getPlayer().getLocation().setX(0);
		gamemap.getPlayer().getLocation().setY(0);
		Random randomObj = new Random();
		int randomX = randomObj.nextInt((20) + 1);
		int randomY = randomObj.nextInt((10) + 1);
		coins1.relocate(randomX*46, randomY*85);
		gamemap.setLootLocation(randomX, randomY);
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
