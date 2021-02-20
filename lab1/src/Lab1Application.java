import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Lab1Application extends Application {
       
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	int width = 300;
    	int height = 250;
    	
        primaryStage.setTitle("Lab1 JavaFX");
        
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
   
        //
        scene.setFill(Color.web("#da70d6"));
        
        Rectangle r_green = new Rectangle((width/2)-75, ((height/2)-25)-75, 150, 50);
        root.getChildren().add(r_green);
        r_green.setFill(Color.web("#008000"));
      
        Ellipse ellipse_yellow = new Ellipse((width/2)+50, (height/2)-25, 25, 75);
        root.getChildren().add(ellipse_yellow);
        ellipse_yellow.setFill(Color.web("#ffff00"));
        
        Rectangle r_red = new Rectangle((width/2)-75, ((height/2)+50)-50, 150, 50);
        root.getChildren().add(r_red);
        r_red.setFill(Color.web("#f00"));
        
        Ellipse ellipse_blue = new Ellipse((width/2)-50, (height/2)-25, 25, 75);
        root.getChildren().add(ellipse_blue);
        ellipse_blue.setFill(Color.web("#00f"));

        Rectangle r_green_half = new Rectangle((width/2)-75, ((height/2)-25)-75, 75, 50);
        root.getChildren().add(r_green_half);
        r_green_half.setFill(Color.web("#008000"));
        
        
     
    
  
       
        /*
        r_green.setViewOrder(3.0);
        r_red.setViewOrder(2.0);
        ellipse_yellow.setViewOrder(3.0);
        ellipse_blue.setViewOrder(2.0);
        r_green_half.setViewOrder(1.0);
        */
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
