package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10)); // 设置内边距
        gridPane.setHgap(10); // 设置水平间距
        gridPane.setVgap(10); // 设置垂直间距

        // 创建按钮并将其放置在网格的特定位置
        Button button1 = new Button("Button 1");
        GridPane.setConstraints(button1, 0, 0); // 放置在第一行第一列

        Button button2 = new Button("Button 2");
        GridPane.setConstraints(button2, 1, 0); // 放置在第一行第二列

        Button button3 = new Button("Button 3");
        GridPane.setConstraints(button3, 0, 1); // 放置在第二行第一列

        Button button4 = new Button("Button 4");
        GridPane.setConstraints(button4, 1, 1); // 放置在第二行第二列

        // 将按钮添加到网格中
        gridPane.getChildren().addAll(button1, button2, button3, button4);

        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
