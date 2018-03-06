
package asteroids;

import javafx.scene.shape.Polygon;

public class Bala {
    
    private double posicionBalaY = 0;
    private double posicionBalaX = 0;
    private double velocidadAbsolutaBala = 10;
    private double velocidadBalaX = 0;
    private double velocidadBalaY = 0;
    private double giroBala;
    private double giroBalaRadianes;
    Polygon bala = new Polygon();
    Nave nave = new Nave();
    
    public Bala(double navePosX, double navePosY,double giroNave) {
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
        bala.setLayoutX(navePosX);
        posicionBalaX=navePosX;
        bala.setLayoutY(navePosY);
        posicionBalaY=navePosY;
        bala.setRotate(giroNave+90);
        giroBala=giroNave;
    }
    /*
    public void setBalaX(){
        bala.setLayoutX(nave.getNavePosX());
    }
    public void setBalaY(){
        bala.setLayoutY(nave.getNavePosY());
    }
    public void rotateBala(){
        bala.setRotate(90);
    }*/
    public void moverBala(){
        bala.setLayoutX(posicionBalaX);
        posicionBalaX+=velocidadBalaX;
        bala.setLayoutY(posicionBalaY);
        posicionBalaY+=velocidadBalaY;
        giroBalaRadianes=Math.toRadians(giroBala);
        
    }
    public void dispararBala(){
        giroBalaRadianes=Math.toRadians(giroBala);
        velocidadBalaX=Math.cos(giroBalaRadianes)*velocidadAbsolutaBala;
        bala.setLayoutX(posicionBalaX);
        posicionBalaX+=velocidadBalaX;
        velocidadBalaY=Math.sin(giroBalaRadianes)*velocidadAbsolutaBala;
        bala.setLayoutY(posicionBalaY);
        posicionBalaY+=velocidadBalaY;
    }
    public void balaInvisible(){
        bala.setVisible(false);
    }
    public Polygon mostrarBala(){
        return bala;
    }
    
    
}
