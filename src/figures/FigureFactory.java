package figures;

import javafx.scene.canvas.GraphicsContext;
import java.awt.geom.Point2D;

public class FigureFactory {

    public Figure getFigure(String figureType, GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint){
        if (figureType == null){
            return null;
        }
        switch (figureType) {
            case "Line":
                return new Line(gc, fPoint, sPoint);
            case "Rectangle":
                return new Rectangle(gc, fPoint, sPoint);
            case "Oval":
                return new Oval(gc, fPoint, sPoint);
            case "Triangle":
                return new Triangle(gc, fPoint, sPoint);
            case "Star":
                return new Star(gc, fPoint, sPoint);
        }
        return null;
    }
}
