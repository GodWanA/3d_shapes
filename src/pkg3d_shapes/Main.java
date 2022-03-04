/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3d_shapes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author Csernay Attila
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 1068, 600);

        Sphere gomb = new Sphere(70);
        Cylinder henger = new Cylinder(50, 110);
        Box kocka = new Box(100, 100, 100);

        Camera camera = new PerspectiveCamera();
        camera.setFarClip(500);
        //camera.setTranslateX(-50);
        //camera.setFieldOfView(45);
        //camera.setVerticalFieldOfView(true);

        scene.setCamera(camera);

        HBox objects = new HBox();
        objects.getChildren().addAll(gomb, kocka, henger);

        MenuBar menubar = new MenuBar();
        Menu menu = new Menu("Fájl");
        MenuItem menuitem_s = new MenuItem("Gömb");
        menuitem_s.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                root.getChildren().remove(kocka);
            }
            if (root.getChildren().contains(henger)) {
                root.getChildren().remove(henger);
            }
            if (!root.getChildren().contains(gomb)) {
                root.getChildren().add(gomb);
            }
        });
        MenuItem menuitem_b = new MenuItem("Kocka");
        menuitem_b.setOnAction((e) -> {
            if (!root.getChildren().contains(kocka)) {
                root.getChildren().add(kocka);
            }
            if (root.getChildren().contains(henger)) {
                root.getChildren().remove(henger);
            }
            if (root.getChildren().contains(gomb)) {
                root.getChildren().remove(gomb);
            }
        });
        MenuItem menuitem_c = new MenuItem("Henger");
        menuitem_c.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                root.getChildren().remove(kocka);
            }
            if (!root.getChildren().contains(henger)) {
                root.getChildren().add(henger);
            }
            if (root.getChildren().contains(gomb)) {
                root.getChildren().remove(gomb);
            }
        });

        HBox hbox = new HBox();
        VBox vbox1 = new VBox(menubar, hbox);

        menu.getItems().addAll(menuitem_s, menuitem_b, menuitem_c);

        menubar.getMenus().add(menu);

        root.getChildren().addAll(vbox1, gomb);

        Button button_balra = new Button("Balra");
        button_balra.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                kocka.setRotationAxis(Rotate.Y_AXIS);
                kocka.setRotate(kocka.getRotate() + 10);
            } else if (root.getChildren().contains(gomb)) {
                gomb.setRotationAxis(Rotate.Y_AXIS);
                gomb.setRotate(kocka.getRotate() + 10);
            } else if (root.getChildren().contains(henger)) {
                henger.setRotationAxis(Rotate.Y_AXIS);
                henger.setRotate(kocka.getRotate() + 10);
            }
        });
        Button button_jobbra = new Button("Jobbra");
        button_jobbra.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                kocka.setRotationAxis(Rotate.Y_AXIS);
                kocka.setRotate(kocka.getRotate() - 10);
            } else if (root.getChildren().contains(gomb)) {
                gomb.setRotationAxis(Rotate.Y_AXIS);
                gomb.setRotate(kocka.getRotate() - 10);
            } else if (root.getChildren().contains(henger)) {
                henger.setRotationAxis(Rotate.Y_AXIS);
                henger.setRotate(kocka.getRotate() - 10);
            }
        });
        Button button_fel = new Button("Fel");
        button_fel.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                kocka.setRotationAxis(Rotate.X_AXIS);
                kocka.setRotate(kocka.getRotate() - 10);
            } else if (root.getChildren().contains(gomb)) {
                gomb.setRotationAxis(Rotate.X_AXIS);
                gomb.setRotate(kocka.getRotate() - 10);
            } else if (root.getChildren().contains(henger)) {
                henger.setRotationAxis(Rotate.X_AXIS);
                henger.setRotate(kocka.getRotate() - 10);
            }
        });
        Button button_le = new Button("Le");
        button_le.setOnAction((e) -> {
            if (root.getChildren().contains(kocka)) {
                kocka.setRotationAxis(Rotate.X_AXIS);
                kocka.setRotate(kocka.getRotate() + 10);
            } else if (root.getChildren().contains(gomb)) {
                gomb.setRotationAxis(Rotate.X_AXIS);
                gomb.setRotate(kocka.getRotate() + 10);
            } else if (root.getChildren().contains(henger)) {
                henger.setRotationAxis(Rotate.X_AXIS);
                henger.setRotate(kocka.getRotate() + 10);
            }
        });
        hbox.getChildren().addAll(button_balra, button_jobbra, button_fel, button_le);

        primaryStage.setTitle("3D shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
