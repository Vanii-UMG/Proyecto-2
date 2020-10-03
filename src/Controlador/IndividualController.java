package Controlador;

import Modelo.Cliente;
import Modelo.Individual;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IndividualController implements Initializable {

    @FXML
    private TextField txtDpi;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnSalir;
    @FXML
    private TableView<Cliente> tblIndividual;
    @FXML
    private TableColumn colDpi;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colEdad;
    @FXML
    private TableColumn col_Id;
    @FXML
    private Button btnMoificar;
    @FXML
    private Button btnEliminar;
    
    private Cliente clientes;
    
    public ObservableList<Cliente> cliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Creo el observablelist
        cliente = FXCollections.observableArrayList();
        
        // Asigno las columnas con los atributos del modelo
        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("Apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("Edad"));
        this.col_Id.setCellValueFactory(new PropertyValueFactory("Id"));
        this.colDpi.setCellValueFactory(new PropertyValueFactory("Dpi"));
        
        
    }    

    @FXML
    private void btnAgregaIndividual(ActionEvent event) {
        try{
            
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String dpi = this.txtDpi.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            int id = Integer.parseInt(this.txtId.getText());
            Cliente c = new Individual(dpi,nombre, apellido, edad, id);
          
            
            if(!this.cliente.contains(c)){
                this.cliente.add(c);
                this.tblIndividual.setItems(cliente);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona ya existe");
                alert.showAndWait();
            }
        }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
        }    
        
    }

    @FXML
    private void btnSalida(ActionEvent event) {
        Stage stage= (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }

    public Cliente getClientes() {
        return clientes;
    }

    @FXML
    private void Seleccionar(MouseEvent event) {
        Individual c = (Individual) this.tblIndividual.getSelectionModel().getSelectedItem();
        
        if(c !=null){
            this.txtApellido.setText(c.getApellido());
            this.txtNombre.setText(c.getNombre());
            this.txtEdad.setText(c.getEdad() + "");
            this.txtDpi.setText(c.getDpi());
            this.txtId.setText(c.getId() + "");
        }
    }

    @FXML
    private void btnModifico(ActionEvent event) {
           Individual c = (Individual)this.tblIndividual.getSelectionModel().getSelectedItem();
        
        if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un cliente");
                alert.showAndWait();
        }else{
            try{
           
              
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String dpi = this.txtDpi.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            int id = Integer.parseInt(this.txtId.getText());
            
            Individual aux = new Individual(dpi,nombre, apellido, edad,id);
            
            if(!cliente.contains(aux)){
                c.setNombre(aux.getNombre());
                c.setApellido(aux.getApellido());
                c.setDpi(aux.getDpi());
                c.setId(aux.getId());
                c.setEdad(aux.getEdad());
                this.tblIndividual.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona ya existe");
                alert.showAndWait();
            }
        }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
            
        }
    }

    @FXML
    private void btnElimino(ActionEvent event) {
        Individual c = (Individual)this.tblIndividual.getSelectionModel().getSelectedItem();
        
        if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un cliente");
                alert.showAndWait();
        }else{
            
            this.cliente.remove(c);
            this.tblIndividual.refresh();
            
        }
    
    }

}
