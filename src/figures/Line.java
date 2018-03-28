package figures;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class Line extends Figure {

    Line(GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint){
        this.gc = gc;
        setPoints(fPoint,sPoint);
    }

    @Override
    public void setPoints(Point2D.Double firstPoint, Point2D.Double secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public void Draw(){
        gc.strokeLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
    }

}
