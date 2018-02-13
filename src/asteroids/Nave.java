
package asteroids;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Nave {
    private double velocidadNaveY = 0;
    private double velocidadNaveX = 0;
    private int velocidadNaveTurboX=0;
    private int velocidadNaveTurboY=0;
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
    Group nave;
    
    
    public Nave(){
        nave = new Group();
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
        nave.getChildren().addAll(poligono, rect1,rect2);
    }
    public double getNavePosX(){
        nave.setLayoutX(posicionNaveX);
        return posicionNaveX;
    }
    public double getNavePosY(){
        nave.setLayoutX(posicionNaveY);
        return posicionNaveY;      
    }
    public double setNavePosX(){
        nave.setLayoutX(posicionNaveX=anchoPantalla);
        return posicionNaveX;
    }
    public double setNavePosY(){
        nave.setLayoutX(posicionNaveY=largoPantalla);
        return posicionNaveY;      
    }
    public void rotateNave(){
        nave.setRotate(90);       
    }
    public void naveInvisible(){
        nave.setVisible(false);
    }
    
    
    
        
    public void velocidadNave(){
        posicionNaveX+=velocidadNaveX + velocidadNaveTurboX;
        nave.setLayoutX(posicionNaveX);
        posicionNaveY+=velocidadNaveY + velocidadNaveTurboY;
        nave.setLayoutY(posicionNaveY);
        giroNaveRadianes=Math.toRadians(giroNave);
        velocidadNaveX=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    
}
