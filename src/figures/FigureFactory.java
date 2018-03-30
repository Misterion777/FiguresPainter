package figures;

import javafx.scene.canvas.GraphicsContext;
import java.awt.geom.Point2D;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FigureFactory {

    public Figure getFigure(String figureType, GraphicsContext gc, Point2D.Double fPoint, Point2D.Double sPoint) {

        figureType = "figures." + figureType;

        Constructor c;
        try {
            c = Class.forName(figureType).getConstructor(GraphicsContext.class, Point2D.Double.class,Point2D.Double.class);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Figure figure;
        try {
            figure = (Figure) c.newInstance(gc, fPoint, sPoint);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        return figure;
    }
}
