
package asteroids;

import javafx.scene.shape.Polygon;

public class Bala {
    
    private double posicionBalaY = 50;
    private double posicionBalaX = 50;
    private double velocidadAbsolutaBala =1;
    private double velocidadBalaX = 0;
    private double velocidadBalaY = 0;
    private double giroBala;
    private double giroBalaRadianes;
    private Polygon bala = new Polygon();
    
    
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
    public void posicionBala(){
        bala.setLayoutX(posicionBalaX);
        bala.setLayoutY(posicionBalaY);
    }
    public void velocidadBala(){
        posicionBalaX+=velocidadBalaX;
        posicionBalaY+=velocidadBalaY;
        giroBalaRadianes=Math.toRadians(giroBala);
        velocidadBalaX=Math.cos(giroBalaRadianes)*velocidadAbsolutaBala;
        velocidadBalaY=Math.sin(giroBalaRadianes)*velocidadAbsolutaBala;
    }
    
    
}
