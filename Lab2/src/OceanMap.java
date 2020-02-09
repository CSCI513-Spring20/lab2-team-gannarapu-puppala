import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.awt.Point;

public class OceanMap {
	int xCell =6;
	int yCell =6;
	private int  dimensions=10;
	final int scale = 50;
	


	
	public void getMap(Pane root){
		for(int x = 0; x < dimensions; x++){
			 for(int y = 0; y < dimensions; y++){
				 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); // We want the black outline
			rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
			root.getChildren().add(rect); // Add to the node tree in the pane
			}
			}
		 }
	public Point getShipLocation() {

		return new Point(xCell,yCell);
	}
	
	public void setFinal(int a, int b) {
		xCell =a;
		yCell =b;
	}


}
