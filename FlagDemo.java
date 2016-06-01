/*
Application to sort an array of randomized threads into a flag approximation
*/
package dutchflag;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FlagDemo extends Application 
{
    private static final Insets DEFAULT_INSETS = new Insets(10, 10, 10, 10);
    @Override
    public void start(Stage primaryStage) 
    {   
        Flag flag = new Flag();  //Pane to hold threads
        HBox hbFlag = new HBox();
        hbFlag.setAlignment(Pos.CENTER);
        hbFlag.setPadding(DEFAULT_INSETS);
        hbFlag.getChildren().add(flag);
        
        Button btnSort = new Button("Sort");
        btnSort.setOnMouseClicked(e ->
        {           
            flag.sort();
        });
        Button btnReset = new Button("Reset");
        btnReset.setOnMouseClicked(e ->
        {
            flag.reset();
        });
        
        HBox hbButtons = new HBox(10);
        hbButtons.setAlignment(Pos.CENTER);
        hbButtons.setPadding(DEFAULT_INSETS);
        hbButtons.getChildren().addAll(btnSort, btnReset);
        
        BorderPane root = new BorderPane();
        root.setCenter(hbFlag);
        root.setBottom(hbButtons);
        
        Scene scene = new Scene(root, Flag.WIDTH + 50, Flag.HEIGHT + 50);
        primaryStage.setTitle("Dutch Flag");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
