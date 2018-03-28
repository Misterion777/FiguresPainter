package figures;
import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;
import java.util.*;

public class FiguresList {
    private List<Figure> list = new ArrayList<>();

    public FiguresList(GraphicsContext gc){
        list.add(new Line(gc, new Point2D.Double(20, 20), new Point2D.Double(70,70)));
        list.add(new Rectangle(gc, new Point2D.Double(80, 20), new Point2D.Double(130,70)));
        list.add(new Oval(gc, new Point2D.Double(140, 20), new Point2D.Double(190,70)));
        list.add(new Triangle(gc, new Point2D.Double(200, 20), new Point2D.Double(250,70)));
        list.add(new Star(gc, new Point2D.Double(260, 20), new Point2D.Double(310,70)));
    }

    public void DrawAll(){
        if (list.isEmpty()){
            System.out.println("List is empty!");
        }
        else {
            for (Figure fig : list) {
                fig.Draw();
            }
        }
    }



}
