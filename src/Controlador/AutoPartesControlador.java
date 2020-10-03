package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class AutoPartesControlador implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContraseña;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void btnIngreso(ActionEvent event) {
        String usuario = this.txtUsuario.getText();
        String contraseña = this.txtContraseña.getText();
        if(usuario.equals("Vanii")&& contraseña.equals("123M")){
            try {
            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Menu.fxml"));

            // Cargo la ventana
            Parent root = loader.load();
            
            MenuController controlador = loader.getController();
                
            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("MENU");
            stage.setScene(scene);
            stage.show();
                
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            // Ciero la ventana donde estoy
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        }else{
            JOptionPane.showInputDialog("¡Usuario Incorrecto, Porfavor intente de nuevo!");
        }
    }

    @FXML
    private void btnSalida(ActionEvent event) {
        Stage stage= (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }
    
}
