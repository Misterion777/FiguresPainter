package figures;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public abstract class Figure {

    GraphicsContext gc;

    Point2D.Double firstPoint;
    Point2D.Double secondPoint;

    public abstract void setPoints(Point2D.Double firstPoint, Point2D.Double secondPoint);

    public abstract void Draw();

}
