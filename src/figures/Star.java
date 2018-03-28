package figures;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class Star extends Triangle {

    Star(GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint){
        super(gc, fPoint, sPoint);
    }

    public void Draw(){

        double w = secondPoint.x - firstPoint.x;
        double h = secondPoint.y - firstPoint.y;

        gc.strokePolygon(new double[]{
                        firstPoint.x,firstPoint.x+w,
                        firstPoint.x-w,firstPoint.x+w,
                        firstPoint.x-w},
                new double[]{
                        firstPoint.y, firstPoint.y+h,
                        firstPoint.y+h/2, firstPoint.y+h/2,
                        firstPoint.y+h}, 5);

    }
}
