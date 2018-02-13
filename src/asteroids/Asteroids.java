
package asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Asteroids extends Application {
    
    Nave nave = new Nave();
    Asteroide asteroide = new Asteroide();
    Bala bala = new Bala();
    double giroBalaRadianes;
    int velocidadGiro = 0;
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, largoPantalla, anchoPantalla);
        primaryStage.setTitle("vamosPracticando");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("resource/css/estilos.css").toExternalForm());
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
            
                if(nave.getNavePosX() <= 0){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    nave.setNavePosX();
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(nave.getNavePosY()>=anchoPantalla){
                        nave.setNavePosY();
                    }
                }
                nave.getNavePosY();
                
                if(nave.getNavePosX()<=0){
                    //Ponemos la barra en la posicion 0 para que no se nos valla
                    nave.setNavePosX();
                }else{
                    //Para no sobrepasar el vorde inferior
                    if(nave.getNavePosX()>=largoPantalla){
                        nave.setNavePosX();
                    }
                }
                nave.getNavePosX();
                
                if(getColision(asteroide, nave)){
                    nave.naveInvisible();
                }
                if (getColision(asteroide,bala)){
                        asteroide.asteroideInvisible();
                } 
            }
            
        };
        animacionAsteroide.start();
        
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case UP:
                    velocidadAbsoluta+=velocidadNaveX+2.0;
                    velocidadAbsoluta+=velocidadNaveY+2.0;
                    break;
                case DOWN:
                    velocidadAbsoluta-=3;
                     break;       
                case RIGHT:
                    //Cuando pulsamos la tecla abajo
                    giroNave +=5;
                    if(giroNave>=360){
                        giroNave=0;
                        nave.setLayoutX(posicionNaveX);
                        bala.setLayoutX(posicionBalaX);
                    }
                    break;
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    giroNave -=5;
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
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private boolean getColision(Polygon obj1, Polygon obj2){
        return !Shape.intersect(obj1, obj2).getBoundsInLocal().isEmpty();
    }
    
}
