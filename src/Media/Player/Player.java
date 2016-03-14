package Media.Player;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane{
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBAr bar;
    public Player(String file){
        media=new Media(file);
        player=new MediaPlayer(media);
        view=new MediaView(player);
        mpane=new Pane();
        
        mpane.getChildren().add(view);
        
        setCenter(mpane);
        bar=new MediaBAr(player);
        setBottom(bar);
      
        player.play();       
    }
}
