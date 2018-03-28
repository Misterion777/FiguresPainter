package figures;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class Oval extends Rectangle {

    Oval(GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint){
        super(gc, fPoint, sPoint);
    }

    public void Draw(){

        double w = secondPoint.x - firstPoint.x;
        double h = secondPoint.y - firstPoint.y;

        gc.strokeOval(firstPoint.x,firstPoint.y, w,h);

    }
}
