
package asteroids;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Asteroids extends Application {
    
    Nave nave = new Nave();
    ArrayList<Asteroide> listaAsteroide = new ArrayList();
    Bala bala1;
    Text finPartida = new Text("Fin del juego as derrotado al numero total de asteroides.");
    
    boolean finPar = false; 
    boolean finPar2 = false; 
    double giroBalaRadianes;
    int velocidadGiro;
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    double posicionAstX;
    double posicionAstY;
    ArrayList <Bala> listaBalas = new ArrayList();
    Asteroide asteroide;
    String TEXT_SIZE = null;
    Text textScore;
    int score;
    Asteroide asteroideEliminar=null;
    Bala balaEliminar=null;
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, largoPantalla, anchoPantalla);
        primaryStage.setTitle("vamosPracticando");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("resource/css/estilos.css").toExternalForm());
        root.getChildren().add(nave.getGrupoNave());
        Random posAst = new Random();
        for(int i=0; i<3; i++){
                    asteroide = new Asteroide( posicionAstX, posicionAstY);
                    listaAsteroide.add(asteroide);
                    asteroide.posAsteroideX=posAst.nextInt(largoPantalla);
                    asteroide.posAsteroideY=posAst.nextInt(anchoPantalla);
                    //asteroide.posAsteroideX = posAst.nextInt(largoPantalla>0.2*largoPantalla);
                    root.getChildren().add(asteroide.mostrarAsteroide());
                    
                }
        //Layout principal
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(largoPantalla);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        root.getChildren().add(paneScores);
        //Layout puntuacion actual
        HBox paneActualScores = new HBox();
        paneActualScores.setSpacing(10);
        paneScores.getChildren().add(paneActualScores);
        //Layout puntuacion maxima
        HBox paneMaximaScores = new HBox();
        paneMaximaScores.setSpacing(10);
        paneScores.getChildren().add(paneMaximaScores);
        //Texto de etiqueta para puntuacion
        Text textoTituloPuntuacion = new Text("Score");
        
        textoTituloPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoTituloPuntuacion.setFill(Color.BLUE);
        //Texto para puntuacion
        textScore = new Text("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.BLUE);
        //Texto de etiqueta para puntuacion
        Text textoTituloMaximaPuntuacion = new Text("Max.Score");
        textoTituloMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoTituloMaximaPuntuacion.setFill(Color.BLUE);
        //Texto para puntuacion
        Text textoMaximaPuntuacion = new Text("0");
        textoMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoMaximaPuntuacion.setFill(Color.BLUE);
        //Añadir los textos a los layaut reservados
        paneActualScores.getChildren().add(textoTituloPuntuacion);
        paneActualScores.getChildren().add(textScore);
        paneMaximaScores.getChildren().add(textoTituloMaximaPuntuacion);
        paneMaximaScores.getChildren().add(textoMaximaPuntuacion);
        
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(finPar==true){
                    finPartida.setLayoutX(250);
                    finPartida.setLayoutY(250);
                    asteroide.asteroideInvisible();
                    bala1.balaInvisible();
                    nave.naveInvisible();
                    finPartida.setFill(Color.BLUE);
                    finPartida.setFont(Font.font(TEXT_SIZE));
                    this.stop();
                    root.getChildren().add(finPartida);
                }
                if(finPar2==true){
                    finPartida.setLayoutX(300);
                    finPartida.setLayoutY(250);
                    asteroide.asteroideInvisible();
                    nave.naveInvisible();
                    this.stop();
                    root.getChildren().add(finPartida);
                }
                
                
                for(int i=0; i<listaAsteroide.size(); i++){
                    asteroide = listaAsteroide.get(i);
                    asteroide.moverAsteroide();
                }
                for(int i=0; i<listaBalas.size(); i++){
                    Bala bala1= listaBalas.get(i);
                    bala1.moverBala();
                }
                boolean asteroideInv=false;
                for(int i=0; i<listaAsteroide.size(); i++){
                    asteroide=listaAsteroide.get(i);
                    if(getColision(asteroide.mostrarAsteroide(), nave.getPolNave())){
                        nave.naveInvisible();
                        asteroideInv=true;
                    }
                }
                if(asteroideInv==true){
                    for(int i=0; i<listaAsteroide.size(); i++){
                        listaAsteroide.get(i).asteroideInvisible();
                    }
                    listaAsteroide.removeAll(listaAsteroide);
                    finPar2=true;
                }; 
                
                for(int i=0; i<listaBalas.size(); i++){
                    bala1=listaBalas.get(i);
                    for(int e=0; e<listaAsteroide.size(); e++){
                        asteroide=listaAsteroide.get(e);
                        if (getColision(asteroide.mostrarAsteroide(),bala1.mostrarBala())){
                            balaEliminar=bala1;
                            balaEliminar.balaInvisible();
                            asteroideEliminar=asteroide;
                            asteroideEliminar.asteroideInvisible();
                            score++;
                            textScore.setText(String.valueOf(score));
                            System.out.println("Colision acertada");
                        }
                    }
                    listaAsteroide.remove(asteroideEliminar);
                    if(listaAsteroide.isEmpty()){
                        finPar=true;
                    }
                }
                listaBalas.remove(balaEliminar);
                for(int i=0; i<listaAsteroide.size(); i++){
                    asteroide=listaAsteroide.get(i);
                    if(asteroide.posAsteroideX<=0){
                        asteroide.mostrarAsteroide().setTranslateX(largoPantalla);
                        }else{
                            if(asteroide.posAsteroideX>=largoPantalla){
                                asteroide.mostrarAsteroide().setTranslateX(0);
                            }
                    }
                    if(asteroide.posAsteroideY <=0){
                        asteroide.mostrarAsteroide().setTranslateY(anchoPantalla);
                        }else{
                                    //Para no sobrepasar el vorde inferior
                            if(asteroide.posAsteroideY>=anchoPantalla){
                                asteroide.mostrarAsteroide().setTranslateY(0);
                           }
                    }
                }
                nave.mover();
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
                    break;
                    
                case LEFT:
                    //Cuando pulsamos la tecla abajo
                    nave.giroNaveIzquierda();
                    break;
                case SPACE:
                    bala1 = new Bala(nave.getNavePosX(),nave.getNavePosY(),nave.giroNave());
                    listaBalas.add(bala1);
                    bala1.dispararBala();
                    root.getChildren().add(bala1.mostrarBala());
                    break;
                }
                
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
