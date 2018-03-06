
package asteroids;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Asteroide {
    
    private Polygon dibujoAsteroide = new Polygon();
    private int anchoPantalla = 600;
    private int largoPantalla = 800;
    double posAsteroideX;
    double posAsteroideY;
    private double velAsteroideX=0;
    private double velAsteroideY=1;
    
    public Asteroide(double posAsteroideX,double posAsteroideY){
        dibujoAsteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        dibujoAsteroide.setFill(Color.BROWN);
        Random velAst = new Random();
        velAsteroideX=velAst.nextDouble();
        
        velAsteroideY=velAst.nextDouble();
        dibujoAsteroide.setLayoutX(posAsteroideX);
        dibujoAsteroide.setLayoutY(posAsteroideY);
        
    }
    public void moverAsteroide(){
        posAsteroideX+=velAsteroideX;
        dibujoAsteroide.setLayoutX(posAsteroideX);
        posAsteroideY+=velAsteroideY;
        dibujoAsteroide.setLayoutY(posAsteroideY);
        
        
    }
    public void asteroideInvisible(){
        dibujoAsteroide.setVisible(false);
    }
    public Polygon mostrarAsteroide(){
        return dibujoAsteroide;
    }
    
    
    
}
