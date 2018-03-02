
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
    Polygon poligono;
    Rectangle rect2;
    Rectangle rect1;
    
    public Nave(){
        grupoNave = new Group();
        poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        poligono.setFill(Color.BLUE);
        rect1 = new Rectangle(7, 5);
        rect2 = new Rectangle(7, 5);
        rect1.setTranslateX(-13);
        rect2.setTranslateX(6);
        rect1.setTranslateY(20);
        rect2.setTranslateY(20);
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        grupoNave.getChildren().addAll(poligono, rect1,rect2);
        grupoNave.setTranslateX(posicionNaveX);
        grupoNave.setTranslateY(posicionNaveY);
    }
    
    public void mover(){
        grupoNave.setTranslateX(posicionNaveX);
        grupoNave.setTranslateY(posicionNaveY);
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        grupoNave.setRotate(giroNave+90);
        giroNaveRadianes=Math.toRadians(giroNave); 
        if(posicionNaveX<=0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setTranslateX(posicionNaveX=largoPantalla);
            }else{
                //Para no sobrepasar el vorde inferior
                if(posicionNaveX>=largoPantalla){
                    grupoNave.setTranslateX(posicionNaveX=0);
                }
        }
        if(posicionNaveY <= 0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setTranslateY(posicionNaveY=anchoPantalla);
            }else{
                        //Para no sobrepasar el vorde inferior
                if(posicionNaveY>=anchoPantalla){
                    grupoNave.setTranslateY(posicionNaveY=0);
               }
        }
        grupoNave.setTranslateY(posicionNaveY);
    }
    
    public double getNavePosX(){
        return posicionNaveX;
    }
    public double getNavePosY(){
        return posicionNaveY;      
    }
    public double setNavePosX(){
        posicionNaveX=anchoPantalla;
        grupoNave.setTranslateX(posicionNaveX);
        return posicionNaveX;
    }
    public double setNavePosY(){
        posicionNaveY=largoPantalla;
        grupoNave.setTranslateY(posicionNaveY);
        return posicionNaveY;      
    }
    
    public void naveInvisible(){
        poligono.setVisible(false);
        rect1.setVisible(false);
        rect2.setVisible(false);
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
    public Polygon getPolNave(){
        return poligono;
    }
    
                
                
    
    
}
