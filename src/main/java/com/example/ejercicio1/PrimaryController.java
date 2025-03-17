package com.example.ejercicio1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {
    
    @FXML
    private TextField txtOP1;
    
    @FXML
    private TextField txtOP2;

    @FXML
    private TextField txtResultado;

    @FXML
    private RadioButton rdSuma;

    @FXML
    private RadioButton rdResta;

    @FXML
    private RadioButton rdDivision;

    @FXML
    private RadioButton rdMultiplicacion;

    @FXML
    private void switchToSecondary() throws IOException {   
    }
    
    @FXML
    private void onRdSumaButtonClick() throws IOException{
    }

    @FXML
    private void initialize(){
        txtOP1.setText("0");
        txtOP2.setText("0");
        txtResultado.setText("0");

        ToggleGroup operaciones = new ToggleGroup();
        rdSuma.setToggleGroup(operaciones);
        rdResta.setToggleGroup(operaciones);
        rdDivision.setToggleGroup(operaciones);
        rdMultiplicacion.setToggleGroup(operaciones);
    }

    // funcion que me permite crear un mensaje de alerta
    private void mostrarMensaje(String mensaje){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Warming");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void onOperarButtonClick() throws IOException{
        try{
        Alert alert = new Alert(AlertType.INFORMATION);
        float num1=0, num2=0, resultado=0;
        num1 = Float.parseFloat(txtOP1.getText());
        num2 = Float.parseFloat(txtOP2.getText());

        if(num1 == 0 || num2 == 0){
            mostrarMensaje("Error: Los numeros ingresados no pueden ser 0");
            return;
        }

        if(rdSuma.isSelected() == false && rdResta.isSelected() == false && rdDivision.isSelected() == false && rdMultiplicacion.isSelected() == false){
            mostrarMensaje("Error: Debe Seleccionar Una Operacion");
            return;
        }

        if(rdSuma.isSelected()){
            // rdResta.setSelected(false);
            // rdDivision.setSelected(false);
            // rdMultiplicacion.setSelected(false);

            resultado = (num1 + num2);
            txtResultado.setText(String.valueOf(resultado));

            rdResta.setDisable(false);
            rdDivision.setDisable(false);
            rdMultiplicacion.setDisable(false);
        }
        else if(rdResta.isSelected()){

            if(num1 < num2){
                mostrarMensaje("Error: El primer numero debe ser mayor al segundo");
                return;
            }
            else{
            resultado = (num1 - num2);
            txtResultado.setText(String.valueOf(resultado));
            }
        }
        else if(rdMultiplicacion.isSelected()){
            resultado = (num1 * num2);
            txtResultado.setText(String.valueOf(resultado));
        }
        else if(rdDivision.isSelected()){
            if(num2 == 0){
                mostrarMensaje("Error: No se puede dividir por 0");
                return;
            }
            else{
                resultado = (num1 / num2);
                txtResultado.setText(String.valueOf(resultado));
            }
        }
    }catch(NumberFormatException e){
        mostrarMensaje("Error: Formato de numero incorrecto");
        return;
    }
        
    }

    @FXML
    private void onSalirButtonClick() throws IOException{
        mostrarMensaje("Gracias Por Usar La Calculadora");
        System.exit(0);
    }

    @FXML
    private void onLimpiarButtonClick() throws IOException{
        txtOP1.setText("0");
        txtOP2.setText("0");
        txtResultado.setText("0");
    }
}
