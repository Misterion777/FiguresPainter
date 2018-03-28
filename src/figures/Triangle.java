package figures;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class Triangle extends Figure {

    Triangle(GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint){
        this.gc = gc;
        setPoints(fPoint, sPoint);
    }

    @Override
    public void setPoints(Point2D.Double firstPoint, Point2D.Double secondPoint) {

        if (firstPoint.x > secondPoint.x){
            double temp = firstPoint.x;
            firstPoint.x = (firstPoint.x + secondPoint.x) / 2;
            secondPoint.x = temp;
        }
        else {
            firstPoint.x = (firstPoint.x + secondPoint.x) / 2;
        }

        if (firstPoint.y > secondPoint.y){
            double temp = firstPoint.y;
            firstPoint.y = secondPoint.y;
            secondPoint.y = temp;
        }

        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }



    public void Draw(){
        double w = secondPoint.x - firstPoint.x;
        double h = secondPoint.y - firstPoint.y;

        gc.strokePolygon(new double[]{firstPoint.x, firstPoint.x+w, firstPoint.x-w},
                new double[]{firstPoint.y, firstPoint.y+h, firstPoint.y + h}, 3);

    }


}
