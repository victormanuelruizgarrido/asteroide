/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author 1DAW02
 */
public class Asteroids extends Application {
    
    int velocidadNave = 0;
    boolean posicionNave = false;
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    Group nave;
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();
        Scene scene = new Scene(root, largoPantalla, anchoPantalla);
        primaryStage.setTitle("vamosPracticando");
        primaryStage.setScene(scene);
        primaryStage.show();
        nave = new Group();
        Polygon poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        poligono.setFill(Color.BLUE);
        nave.setLayoutX(400);
        nave.setLayoutY(200);
        Rectangle rect1 = new Rectangle(7, 5);
        Rectangle rect2 = new Rectangle(7, 5);
        rect1.setLayoutX(-13);
        rect2.setLayoutX(6);
        rect1.setLayoutY(20);
        rect2.setLayoutY(20);
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        nave.getChildren().addAll(poligono, rect1,rect2);
        root.getChildren().add(nave);
           
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case UP:
                    //Cuando pulsamos tecla arriba.
                    velocidadNave = 6;
                    break;
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    nave.getTransforms().add(new Rotate(270,0,0));
                    break;
                case RIGHT:
                    //Cuando pulsamos la tecla abajo
                    nave.getTransforms().add(new Rotate(90,0,0));
                    break;    
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            velocidadNave = 0;
        }); 
    }
    public void act() { 
        if(posicionNave==true){ 
            (double)nave.setLayoutY(nave.setLayoutY()-6);
        }
    }; 
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
