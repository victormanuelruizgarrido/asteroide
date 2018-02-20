
package asteroids;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Nave {
    private double velocidadNaveY = 0;
    private double velocidadNaveX = 0;
    private double posicionNaveY =500;
    private double posicionNaveX =400;
    private double velocidadAbsoluta =0.3;
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
    
    public void mover(){
        grupoNave.setLayoutX(posicionNaveX);
        posicionNaveX+=velocidadNaveX;
        grupoNave.setLayoutY(posicionNaveY);
        posicionNaveY+=velocidadNaveY;
        grupoNave.setRotate(giroNave+90);
        giroNaveRadianes=Math.toRadians(giroNave); 
        if(posicionNaveX<=0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setLayoutX(posicionNaveX=largoPantalla);
            }else{
                //Para no sobrepasar el vorde inferior
                if(posicionNaveX>=largoPantalla){
                    grupoNave.setLayoutX(posicionNaveX=0);
                }
        }
        if(posicionNaveY <= 0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setLayoutY(posicionNaveY=anchoPantalla);
            }else{
                        //Para no sobrepasar el vorde inferior
                if(posicionNaveY>=anchoPantalla){
                    grupoNave.setLayoutY(posicionNaveY=0);
               }
        }
        grupoNave.setLayoutY(posicionNaveY);
    }
    
    public double getNavePosX(){
        return posicionNaveX;
    }
    public double getNavePosY(){
        return posicionNaveY;      
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
    
    public void naveInvisible(){
        grupoNave.setVisible(false);
    }
    public void acereraNave(){
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        giroNaveRadianes=Math.toRadians(giroNave);
        velocidadNaveX+=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY+=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    public void reducirNave(){
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        giroNaveRadianes=Math.toRadians(giroNave);
        velocidadNaveX-=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY-=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    public double giroNave(){
        return giroNave;
    }
    public double giroNaveRadianes(){
        return giroNaveRadianes;
    }
    public double giroNaveDerecha(){
        giroNave+=5;
        giroNave=giroNave%360;
        return giroNave;
    }
    
    public double giroNaveIzquierda(){
        giroNave-=5;
        giroNave=giroNave%360;
        return giroNave;
        
    }
    public double getVelocidadNaveX(){
       return velocidadNaveX;
    }
    public double getVelocidadNaveY(){
       return velocidadNaveX;
    }
  
    public Group getGrupoNave(){
        return grupoNave;
    }
    
                
                
    
    
}
