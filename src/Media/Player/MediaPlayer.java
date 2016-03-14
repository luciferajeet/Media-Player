package Media.Player;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MediaPlayer extends Application {
    
    Player player;
    FileChooser fileChooser;
    public void start(final Stage primaryStage){
        
        MenuItem open=new MenuItem("Open");
        Menu file=new Menu("File");
        MenuBar menu=new MenuBar();
        
        file.getItems().add(open);
        menu.getMenus().add(file);
        
        fileChooser=new FileChooser();
        
        open.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                player.player.pause();
                File file=fileChooser.showOpenDialog(primaryStage);
                if(file!=null){
                    try {
                        player=new Player(file.toURI().toURL().toExternalForm());
                        Scene scene=new Scene(player,1080,680,Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(MediaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        player=new Player("file:///F:/ab.mp4");
        player.setTop(menu);
        Scene scene=new Scene(player,1080,680,Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
