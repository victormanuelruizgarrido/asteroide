
package asteroids;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Nave {
    private double velocidadNaveY = 0;
    private double velocidadNaveX = 0;
    private double direcionNaveY = 0;
    private double direcionNaveX = 0;
    private double posicionNaveY =500;
    private double posicionNaveX =400;
    private double velocidadAbsoluta =1;
    private double giroNave;
    private double giroNaveRadianes;
    private int centroNave;
    private int anchoNave = 15;
    private int anchoPantalla = 600;
    private int largoPantalla = 800;
    Group grupoNave;
    
    
    public Nave(){
        grupoNave = new Group();
        Polygon poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        poligono.setFill(Color.BLUE);
        Rectangle rect1 = new Rectangle(7, 5);
        Rectangle rect2 = new Rectangle(7, 5);
        rect1.setLayoutX(-13);
        rect2.setLayoutX(6);
        rect1.setLayoutY(20);
        rect2.setLayoutY(20);
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        grupoNave.getChildren().addAll(poligono, rect1,rect2);
    }
    public Group mostrarNave(){
        return grupoNave;
    }
    public double getNavePosX(){
        grupoNave.setLayoutX(posicionNaveX);
        return posicionNaveX;
    }
    public double getNavePosY(){
        grupoNave.setLayoutX(posicionNaveY);
        return posicionNaveY;      
    }
    public void cambiaPosicionX(){
        posicionNaveX+=velocidadNaveX;
    }
    public void cambiaPosicionY(){
        posicionNaveY+=velocidadNaveY;
    }
    public double setNavePosX(){
        posicionNaveX=anchoPantalla;
        grupoNave.setLayoutX(posicionNaveX);
        return posicionNaveX;
    }
    public double setNavePosY(){
        posicionNaveY=largoPantalla;
        grupoNave.setLayoutX(posicionNaveY);
        return posicionNaveY;      
    }
    public void rotateNave(){
        grupoNave.setRotate(90);       
    }
    public void naveInvisible(){
        grupoNave.setVisible(false);
    }
    public void acereraNave(){
        giroNaveRadianes=Math.toRadians(giroNave);
        velocidadNaveX+=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY+=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    public void reducirNave(){
        giroNaveRadianes=Math.toRadians(giroNave);
        velocidadNaveX-=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY-=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    public void giroNaveDerecha(){
        giroNave+=5;
        giroNave=giroNave%360;
    }
    public void giroNaveIzquierda(){
        giroNave-=5;
        giroNave=giroNave%360;
    }
    public double getVelocidadNaveX(){
       return velocidadNaveX;
    }
    public double getVelocidadNaveY(){
       return velocidadNaveX;
    }
    public double incrementarVelocidadNaveX(){
       return velocidadNaveX+2;
    }
    public double incrementarVelocidadNaveY(){
       return velocidadNaveY+2;
    }
    
    
}
