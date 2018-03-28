package sample;

import figures.Rectangle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import figures.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Controller {

    public Canvas mainCanvas;
    public ComboBox<String> figuresComboBox;
    public Label tipLabel;
    public Button clearButton;
    public Button drawListButton;

    private GraphicsContext gc;
    private boolean figurePicked = false;
    private boolean firstPointPicked = false;
    private Point2D.Double firstPoint = new Point2D.Double();
    

    public void initialize(){
        gc = mainCanvas.getGraphicsContext2D();
        DrawBorder();
        SetupComboBox();
    }

    private void DrawBorder(){
        gc.strokeRect(0,0,mainCanvas.getWidth(), mainCanvas.getHeight());
    }
    private void SetupComboBox(){
        ArrayList<String> figuresList = new ArrayList<>();
        figuresList.add("Line");
        figuresList.add("Rectangle");
        figuresList.add("Oval");
        figuresList.add("Triangle");
        figuresList.add("Star");

        ObservableList<String> observableListOfObjects = FXCollections.observableList(figuresList);
        figuresComboBox.setItems(observableListOfObjects);

    }

    public void pick_figure(ActionEvent actionEvent) {
        if (figuresComboBox.getValue() != null){
            figurePicked = true;
            tipLabel.setText("Figure picked! Pick first point!");
        }
    }

    public void click_canvas(MouseEvent mouseEvent) {
        if (figurePicked && !firstPointPicked){
            firstPoint.setLocation(mouseEvent.getX(),mouseEvent.getY());
            firstPointPicked = true;
            tipLabel.setText("First point picked! Pick second point!");
        }else
        if (firstPointPicked){
            firstPointPicked = false;
            tipLabel.setText("Current figure: " + figuresComboBox.getValue());
            Point2D.Double secondPoint = new Point2D.Double(mouseEvent.getX(),mouseEvent.getY());

            FigureFactory factory = new FigureFactory();
            Figure figure = factory.getFigure(figuresComboBox.getValue(),gc,firstPoint,secondPoint);
            figure.Draw();
        }

    }

    public void click_clear(ActionEvent actionEvent) {
        gc.clearRect(0,0,mainCanvas.getWidth(), mainCanvas.getHeight());
        DrawBorder();
    }

    public void click_draw_list(ActionEvent actionEvent) {
        FiguresList list = new FiguresList(gc);

        list.DrawAll();
    }
}
