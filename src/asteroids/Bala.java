
package asteroids;

import java.util.ArrayList;
import javafx.scene.shape.Polygon;

public class Bala {
    
    private double posicionBalaY = 50;
    private double posicionBalaX = 50;
    private double velocidadAbsolutaBala =1;
    private double velocidadBalaX = 0;
    private double velocidadBalaY = 0;
    private double giroBala;
    private double giroBalaRadianes;
    Polygon bala = new Polygon();
    
    
    public Bala(){
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
    }    
    public void getBalaX(){
        posicionBalaX+=velocidadBalaX;
        bala.setLayoutX(posicionBalaX);
    }
    public void getBalaY(){
        posicionBalaY+=velocidadBalaY;
        bala.setLayoutY(posicionBalaY);
    }
    public void rotateBala(){
        bala.setRotate(90);
    }
    public void disparoBala(){
        giroBalaRadianes=Math.toRadians(giroBala);
        velocidadBalaX=Math.cos(giroBalaRadianes)*velocidadAbsolutaBala;
        velocidadBalaY=Math.sin(giroBalaRadianes)*velocidadAbsolutaBala;
    }
    public void velocidadBalaX(){
        
    }
    public void velocidadBalaY(){
        
    }
    public double velocidadBalaAbsoluta(){
        return velocidadAbsolutaBala+=5;
    }
    
    
}
