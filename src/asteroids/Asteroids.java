
package asteroids;

import java.util.ArrayList;
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
                ArrayList<Asteroide> listaAsteroide = new ArrayList();
                for(int i=0; i<3; i++){
                    Asteroide asteroide = new Asteroide();
                    listaAsteroide.add(asteroide);
                }
                Asteroide asteroide1 = listaAsteroide.get(1);
                listaAsteroide.remove(5);
                
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
                root.getChildren().add(nave.mostrarNave());
            }
            
        };
        animacionAsteroide.start();
        
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case UP:
                    nave.acereraNave();
                    break;
                case DOWN:
                    nave.reducirNave();
                     break;       
                case RIGHT:
                    //Cuando pulsamos la tecla abajo
                    nave.giroNaveDerecha();
                    nave.getNavePosX();
                    bala.getBalaX();
                    break;
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    nave.giroNaveIzquierda();
                    nave.cambiaPosicionX();
                    bala.getBalaX();
                    break;
                case SPACE:
                    Bala bala = new Bala();
                    bala.getBalaX();
                    bala.getBalaY();
                    bala.rotateBala();
                    bala.velocidadBalaAbsoluta();
                    break;
                }
                nave.rotateNave();
                bala.rotateBala();
                
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
                
                
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
