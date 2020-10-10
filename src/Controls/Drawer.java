package Controls;

import Vehicle.Vehicle;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;

import java.awt.Color;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static javafx.scene.paint.Color.BLUE;

public class Drawer {
    private Canvas canvas;
    private Color color;
    private double x;
    private double y;
    private double w=20;
    private double h=20;


    public Drawer(double x, double y, Color color, Canvas c){
        this.x=x;
        this.y=y;
        this.color = color;
        this.canvas = c;


    }
    // setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
public void draw_car(){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.fillRect(x,canvas.getHeight()-y-11,20,9);
    gc.fillRect(x+5,canvas.getHeight()-y-15,10,5);
    gc.fillOval(x+2,canvas.getHeight()-y-5,6,6);
    gc.fillOval(x+14,canvas.getHeight()-y-5,6,6);
}
public void draw_plane(){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.fillPolygon(new double[]{x,x, x+4, x+8,x+10.5,x+13,x+17,x+20,x+13,x+10.5,x+8},
            new double[]{canvas.getHeight()-y-6,canvas.getHeight()-y-17,canvas.getHeight()-y-14,canvas.getHeight()-y-14,canvas.getHeight()-y-20,canvas.getHeight()-y-14,canvas.getHeight()-y-14,canvas.getHeight()-y-6,canvas.getHeight()-y-6,canvas.getHeight()-y,canvas.getHeight()-y-6}, 11);
}
public void draw_bicycle(){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setStroke(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.strokeOval(x,canvas.getHeight()-y-8,8,8);
    gc.strokeOval(x+12,canvas.getHeight()-y-8,8,8);
    gc.strokePolyline(new double[]{x+4,x+10,x+5,x+15,x+16},new double[]{canvas.getHeight()-y-4,canvas.getHeight()-y-4,canvas.getHeight()-y-13,canvas.getHeight()-y-13,canvas.getHeight()-y-4},5);
    gc.strokePolyline(new double[]{x+4,x+5,x+4,x+6},new double[]{canvas.getHeight()-y-4,canvas.getHeight()-y-13,canvas.getHeight()-y-15,canvas.getHeight()-y-15},4);
    gc.strokePolyline(new double[]{x+10,x+15,x+14,x+11},new double[]{canvas.getHeight()-y-4,canvas.getHeight()-y-13,canvas.getHeight()-y-17,canvas.getHeight()-y-17},3);
}
public void draw_motorcycle(){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setStroke(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.strokeOval(x,canvas.getHeight()-y-9,9,9);
    gc.strokeOval(x+12,canvas.getHeight()-y-9,9,9);
    gc.setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.fillPolygon(new double[]{x+4.5,x+10,x+15,x+6},new double[]{canvas.getHeight()-y-4.5,canvas.getHeight()-y-4.5,canvas.getHeight()-y-14,canvas.getHeight()-y-13},4);
    gc.strokePolyline(new double[]{x+15.5,x+13,x+12,x+10},new double[]{canvas.getHeight()-y-4.5,canvas.getHeight()-y-16,canvas.getHeight()-y-18,canvas.getHeight()-y-19},3);
}
public void draw_hoverboard(){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
    gc.fillOval(x,canvas.getHeight()-y-20,7,20);
    gc.fillOval(x+13,canvas.getHeight()-y-20,7,20);
    gc.fillRect(x+4,canvas.getHeight()-y-14,11,8);
}


    public void draw(){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(new javafx.scene.paint.Color((double)color.getRed()/256, (double)color.getGreen()/256, (double)color.getBlue()/256, 1));
        gc.fillRect(x,canvas.getHeight()-y-20,w,h);
        //gc.fillOval(getCenterX()-getRadius(), getCenterY()-getRadius(), getRadius()*2, getRadius()*2);


    }

}
