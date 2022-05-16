package com.example.lab_6_compulsory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Canvas canvas;

    @FXML
    private Button createBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Label gridSize;

    @FXML
    private Spinner<Integer> height;

    @FXML
    private Button loadBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Spinner<Integer> width;


    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(0);
        height.setValueFactory(valueFactory);

        SpinnerValueFactory<Integer> newValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        newValueFactory.setValue(0);
        width.setValueFactory(newValueFactory);

        createBtn.setOnAction(event -> {
            init();
            gc.clearRect(0, 0, canvasWidth, canvasHeight);
            drawGrid();
            paintSticks();
        });


    }

    public void init() {
        this.rows = height.getValue();
        this.cols = width.getValue();
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
    }

    private void drawGrid() {

        gc.setStroke(Color.GRAY);

        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            gc.strokeLine(x1, y1, x2, y2);
        }

        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            gc.strokeLine(x1, y1, x2, y2);
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                gc.setStroke(Color.GRAY);
                gc.strokeOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }


    private void paintSticks() {
        gc.setFill(Color.BLACK);
        double prob = 0.6;
        Random rand = new Random();

        gc.setLineWidth(7);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int dx = 0; dx <= 1; dx++) {
                    for (int dy = 0; dy <= 1; dy++) {
                        if ((dx == dy) || (row + dy >= rows) || (col + dx >= cols)) {
                            continue;
                        }
                        if (rand.nextDouble() < prob) {
                            int x1 = padX + col * cellWidth;
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + dx * cellWidth;
                            int y2 = y1 + dy * cellHeight;
                            gc.strokeLine(x1, y1, x2, y2);
                        }
                    }
                }
            }
        }
    }


}
