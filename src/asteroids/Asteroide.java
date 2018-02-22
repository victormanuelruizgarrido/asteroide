
package asteroids;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Asteroide {
    
    private Polygon asteroide = new Polygon();
    private double posAsteroideX=50;
    private double posAsteroideY=50;
    private int anchoPantalla = 600;
    private int largoPantalla = 800;
    
    public Asteroide(){
        asteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        asteroide.setFill(Color.BROWN);
        asteroide.setLayoutX(posAsteroideX);
        asteroide.setLayoutX(posAsteroideY);
    }
    public double getPosAsterX(){
        return posAsteroideX;
    }
    public double getPosAsterY(){
        return posAsteroideY;
    }
    public double posAsteroideX(){
        posAsteroideX = largoPantalla*0.2;
        return posAsteroideX;
    }
    public double posAsteroideY(){
        posAsteroideY=largoPantalla*0.2;
        return posAsteroideY;
    }
    public void asteroideInvisible(){
        asteroide.setVisible(false);
    }
    public Polygon mostrarAsteroide(){
        return asteroide;
    }
    
    
    
}
