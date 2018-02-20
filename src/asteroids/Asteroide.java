
package asteroids;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Asteroide {
    
    private Polygon asteroide = new Polygon();
    private double posAsteroide1X=300;
    private double posAsteroide1Y=100;
    private double posAsteroide2X=600;
    private double posAsteroide2Y=200;
    private double posAsteroide3X=500;
    private double posAsteroide3Y=300;
    public Asteroide(){
        asteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        asteroide.setFill(Color.BROWN);
    }
    public void getPosAsteroide1X(){
        asteroide.setLayoutX(posAsteroide1X);
    }
    public void getPosAsteroide1Y(){
        asteroide.setLayoutX(posAsteroide1Y);
    }
    public void getPosAsteroide2X(){
        asteroide.setLayoutX(posAsteroide2X);
    }
    public void getPosAsteroide2Y(){
        asteroide.setLayoutX(posAsteroide2Y);
    }
    public void getPosAsteroide3X(){
        asteroide.setLayoutX(posAsteroide3X);
    }
    public void getPosAsteroide3Y(){
        asteroide.setLayoutX(posAsteroide3Y);
    }
    public void asteroideInvisible(){
        asteroide.setVisible(false);
    }
    public Polygon mostrarAsteroide(){
        return asteroide;
    }
    
    
    
}
