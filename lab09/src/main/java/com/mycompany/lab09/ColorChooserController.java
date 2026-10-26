package com.mycompany.lab09;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author 2588731
 */
public class ColorChooserController  {

    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider alphaSlider;
    @FXML
    private Rectangle colorRectangle;
    @FXML
    private TextField redTextField;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private TextField alphaTextField;
    
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        redTextField.textProperty().bind(redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(alphaSlider.valueProperty().asString("%.2f"));
        
        redSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        alphaSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
    }
    
    public void updateColor() {
        red = (int) redSlider.getValue();
        green = (int) greenSlider.getValue();
        blue = (int) blueSlider.getValue();
        alpha = alphaSlider.getValue();
        
        colorRectangle.setFill(Color.rgb(red, green, blue));
        colorRectangle.setOpacity(alpha);
    }
}
