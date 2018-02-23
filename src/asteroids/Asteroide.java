
package asteroids;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Asteroide {
    
    private Polygon asteroide = new Polygon();
    private int anchoPantalla = 600;
    private int largoPantalla = 800;
    double posAsteroideX;
    double posAsteroideY;
    private double velAsteroideX=0;
    private double velAsteroideY=1;
    
    public Asteroide(double posAsteroideX,double posAsteroideY){
        asteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        asteroide.setFill(Color.BROWN);
        Random velAst = new Random();
        velAsteroideX=velAst.nextDouble();
        
        velAsteroideY=velAst.nextDouble();
        asteroide.setLayoutX(posAsteroideX);
        asteroide.setLayoutX(posAsteroideY);
        
    }
    public void moverAsteroide(){
        posAsteroideX+=velAsteroideX;
        System.out.println(posAsteroideX);
        System.out.println(velAsteroideX);
        asteroide.setLayoutX(posAsteroideX);
        posAsteroideY+=velAsteroideY;
        asteroide.setLayoutY(posAsteroideY);
        
        
    }
    public void asteroideInvisible(){
        asteroide.setVisible(false);
    }
    public Polygon mostrarAsteroide(){
        return asteroide;
    }
    
    
    
}
