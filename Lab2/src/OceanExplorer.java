import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	 Stage stage = new Stage();
	 Pane anchorPane;
	 final int dimensions =10;
	 final int islandCount =10;
	 Scene scene;
	 Image shipImage;
	 ImageView shipImageView;
	 OceanMap oceanMap;
	 Ship ship;
	 int scale =50;
	 int xcor =6;
	 int ycor =6;
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		anchorPane = new AnchorPane(); 
		oceanMap = new OceanMap();
		oceanMap.getMap(anchorPane);
		scene = new Scene(anchorPane,500,500); 
		ship = new Ship();
		LoadShipImage();
	    oceanStage.setTitle("Columbus Ship");
	    oceanStage.setScene(scene);
	    oceanStage.show();	
	    startSailing();
		
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			 @Override
			 public void handle(KeyEvent ke) {
			switch(ke.getCode()){
			case RIGHT:
				ship.goEast(oceanMap.getShipLocation().x*scale, oceanMap.getShipLocation().y*scale);
			break;  
			case LEFT:
				ship.goWest(oceanMap.getShipLocation().x*scale, oceanMap.getShipLocation().y*scale);

			break;
			case UP:
				ship.goNorth(oceanMap.getShipLocation().x*scale, oceanMap.getShipLocation().y*scale);

			break;
			case DOWN:
				ship.goSouth(oceanMap.getShipLocation().x*scale, oceanMap.getShipLocation().y*scale);
 			break;
			default:
			break;
			}
			shipImageView.setX(ship.getShipLocation().x);
			shipImageView.setY(ship.getShipLocation().y);
			oceanMap.setFinal(ship.getShipLocation().x/50,ship.getShipLocation().y/50);
			}
			 });
			}

	private void LoadShipImage() {
		Image shipImage = new Image("\\ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(xcor * scale);
		shipImageView.setY(ycor * scale);
		anchorPane.getChildren().add(shipImageView);
		
	}

	
	
}
