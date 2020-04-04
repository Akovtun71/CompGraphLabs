package sample;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        Color rectColor = Color.rgb(128, 0, 0);

        //top blocks
        Rectangle r = new Rectangle(25, 20, 120, 60);
        root.getChildren().add(r);
        r.setFill(rectColor);

        r = new Rectangle(150, 20, 120, 60);
        root.getChildren().add(r);
        r.setFill(rectColor);

        //middle blocks
        r = new Rectangle(25, 85, 60, 75);
        root.getChildren().add(r);
        r.setFill(rectColor);

        r = new Rectangle(90, 85, 115, 75);
        root.getChildren().add(r);
        r.setFill(rectColor);

        r = new Rectangle(210, 85, 60, 75);
        root.getChildren().add(r);
        r.setFill(rectColor);

        //bottom blocks
        r = new Rectangle(25, 165, 120, 60);
        root.getChildren().add(r);
        r.setFill(rectColor);

        r = new Rectangle(150, 165, 120, 60);
        root.getChildren().add(r);
        r.setFill(rectColor);

        //horizontal yellow lines
        r = new Rectangle(25, 80, 245, 5);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        r = new Rectangle(25, 160, 245, 5);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        //vertical yellow lines
        r = new Rectangle(145, 20, 5, 60);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        r = new Rectangle(145, 165, 5, 60);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        r = new Rectangle(85, 85, 5, 75);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        r = new Rectangle(205, 85, 5, 75);
        root.getChildren().add(r);
        r.setFill(Color.YELLOW);

        scene.setFill(Color.rgb(128, 128, 0));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}