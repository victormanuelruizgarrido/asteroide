/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 1DAW02
 */
public class Asteroids extends Application {
    
    int velocidadNaveY = 3;
    int velocidadNaveX = 3;
    int direcionNaveY = 0;
    int direcionNaveX = 0;
    int posicionNaveY =500;
    int posicionNaveX =400;
    int giroNave;
    int centroNave;
    int anchoNave = 15;
    int velocidadGiro = 0;
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    Group nave;
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
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
        nave.setLayoutX(posicionNaveX);
        nave.setLayoutY(posicionNaveY);
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
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
                
                if(posicionNaveY<0){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    posicionNaveY = anchoPantalla;
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(posicionNaveY>anchoPantalla){
                        posicionNaveY = 0;
                    }
                }
                nave.setLayoutY(posicionNaveY);
                
                if(posicionNaveX<0-anchoNave){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    posicionNaveX = 800;
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(posicionNaveX>anchoPantalla-anchoNave*3){
                        posicionNaveX = 0;
                    }
                }
                nave.setLayoutX(posicionNaveX);  
            }
            
        };
        animacionAsteroide.start();
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case UP:
                    
                    //Cuando pulsamos tecla arriba.
                    if(giroNave==0){
                        direcionNaveX=0;
                        direcionNaveY=-1;
                        posicionNaveY+=(direcionNaveY * velocidadNaveY);
                        nave.setLayoutY(posicionNaveY);
                    }
                    if(giroNave==90){
                        direcionNaveY=0;
                        direcionNaveX=1;
                        posicionNaveX+=(direcionNaveX * velocidadNaveX);
                        nave.setLayoutX(posicionNaveX);
                    }
                    if(giroNave==180){
                        direcionNaveX=0;
                        direcionNaveY=1;
                        posicionNaveY+=(direcionNaveY * velocidadNaveY);
                        nave.setLayoutY(posicionNaveY);
                    }
                    if(giroNave==270){
                        direcionNaveY=0;
                        direcionNaveX =-1;
                        posicionNaveX+=(direcionNaveX * velocidadNaveX);
                        nave.setLayoutX(posicionNaveX);
                    }
                    
                    
                    break;
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    giroNave = giroNave-90;
                    if(giroNave==-90){
                        giroNave=270;
                        posicionNaveX--;
                        nave.setLayoutY(posicionNaveX);
                    }
                    break;
                case RIGHT:
                    //Cuando pulsamos la tecla abajo
                    giroNave = giroNave+90;
                    if(giroNave>=360){
                        giroNave=0;
                        nave.setLayoutY(posicionNaveY);
                    }
                    break;    
            }
        nave.setRotate(giroNave);
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            
        });
         
    }
    
                
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
