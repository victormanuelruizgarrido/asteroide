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
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author 1DAW02
 */
public class Asteroids extends Application {
    
    int velocidadNaveTurboX=0;
    int velocidadNaveTurboY=0;
    int posicionBalaY = 50;
    int posicionBalaX = 50;
    double velocidadNaveY = 0;
    double velocidadNaveX = 0;
    double velocidadAbsoluta =1;
    double velocidadAbsolutaBala =1;
    double velocidadBalaX = 0;
    double velocidadBalaY = 0;
    double direcionNaveY = 0;
    double direcionNaveX = 0;
    int posicionNaveY =500;
    int posicionNaveX =400;
    double giroBala;
    double giroBalaRadianes;
    double giroNave;
    double giroNaveRadianes;
    int centroNave;
    int anchoNave = 15;
    int velocidadGiro = 0;
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    Group nave;
    Polygon bala = new Polygon();
    
    
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
        Polygon asteroide = new Polygon();
        asteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            -15.0, 40.0,
            15.0, 20.0,
            30.0, 0.0 
        });
        asteroide.setFill(Color.BROWN);
        asteroide.setLayoutX(30);
        asteroide.setLayoutY(30);
        nave.setLayoutX(posicionNaveX);
        nave.setLayoutY(posicionNaveY);
        nave.getTransforms().add(new Rotate (90,00,0));
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
        root.getChildren().add(asteroide);
        
        
        
        
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
                posicionNaveX+=velocidadNaveX + velocidadNaveTurboX;
                nave.setLayoutX(posicionNaveX);
                posicionNaveY+=velocidadNaveY + velocidadNaveTurboY;
                nave.setLayoutY(posicionNaveY);
                
                posicionBalaX+=velocidadBalaX;
                bala.setLayoutX(posicionBalaX);
                posicionBalaY+=velocidadBalaY;
                bala.setLayoutY(posicionBalaY);
                
                
                giroNaveRadianes=Math.toRadians(giroNave);
                velocidadNaveX=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
                velocidadNaveY=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
                velocidadBalaX=Math.cos(giroNaveRadianes)*velocidadAbsolutaBala;
                velocidadBalaY=Math.sin(giroNaveRadianes)*velocidadAbsolutaBala;
                
                
                if(posicionNaveY<=0){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    posicionNaveY = anchoPantalla;
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(posicionNaveY>=anchoPantalla){
                        posicionNaveY = 0;
                    }
                }
                nave.setLayoutY(posicionNaveY);
                
                if(posicionNaveX<=0){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    posicionNaveX = largoPantalla;
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(posicionNaveX>=largoPantalla){
                        posicionNaveX = 0;
                    }
                }
                nave.setLayoutX(posicionNaveX);
                int collisionZone = getStickCollisionZone(asteroide , bala);
                Shape.intersect(asteroide, bala);
                Shape shapeColision = Shape.intersect(asteroide, bala);
                boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                
            }

            private int getStickCollisionZone(Polygon asteroide, Polygon bala) {
                if(colisionVacia==true){
                    
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void calculateBallSpeed(int collisionZone) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        animacionAsteroide.start();
        
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case UP:
                    velocidadAbsoluta+=3;
                    break;
                case DOWN:
                    velocidadAbsoluta-=3;
                     break;       
                case RIGHT:
                    //Cuando pulsamos la tecla abajo
                    giroNave = giroNave+10;
                    if(giroNave>=360){
                        giroNave=0;
                        nave.setLayoutX(posicionNaveX);
                        bala.setLayoutX(posicionBalaX);
                    }
                    break;
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    giroNave = giroNave-10;
                    if(giroNave==-90){
                        giroNave=270;
                        nave.setLayoutX(posicionNaveX);
                        bala.setLayoutX(posicionBalaX);
                    }
                    break;
                
                case SPACE: 
                    velocidadNaveTurboX=5;
                    velocidadNaveTurboY=5;
                    break;
                case ENTER:
                    bala = new Polygon();
                    bala.getPoints().addAll(new Double[]{
                        0.0, -2.0,
                        -3.0, 10.0,
                        -2.0, 10.0,
                        -2.0, 15.0,
                        2.0, 15.0,
                        2.0, 10.0,
                        3.0, 10.0,
                        0.0, -2.0
                    });
                    bala.setFill(Color.ORANGE);
                    root.getChildren().add(bala);
                    posicionBalaX=posicionNaveX;
                    posicionBalaY=posicionNaveY;
                    bala.getTransforms().add(new Rotate (90,00,0));
                    velocidadAbsolutaBala+=5;
                    velocidadAbsolutaBala+=5;        
                    break;
                }
            nave.setRotate(giroNave);
            bala.setRotate(giroNave);
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
            case SPACE:
                velocidadNaveTurboX=0;
                velocidadNaveTurboY=0;
                break;
            }
        });
         
    }
    /*static void anguloCal(double giroNave ){
        //Primer punto, pasa "a" a radianes.
        Math.sin();
        double b = Math.toRadians(giroNave);
        System.out.println("Seno de " + giroNave + " es: " + Math.sin(b) );
        System.out.println("Coseno de " + giroNave + " es: " + Math.cos(b) );
        System.out.println("Tangente de " + giroNave + " es: " + Math.tan(b) );
    }*/
                
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
