
package asteroids;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Asteroide {
    
    private Polygon asteroide = new Polygon();
    
    
    public Asteroide(){
        asteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        asteroide.setFill(Color.BROWN);
        asteroide.setLayoutX(100);
        asteroide.setLayoutY(300);
    }
    public void asteroideInvisible(){
        asteroide.setVisible(false);
    }
    
    
    
}
