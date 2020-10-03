package Controlador;

import Modelo.Cliente;
import Modelo.Empresa;
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

public class EmpresaController implements Initializable {

    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtDescuento;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TableView<Cliente> tblEmpresa;
    @FXML
    private TableColumn colContacto;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colEdad;
    @FXML
    private TableColumn col_Id;
    @FXML
    private TableColumn colDescuento;
    
    private Cliente clientes;
    
    public ObservableList<Cliente> cliente;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cliente = FXCollections.observableArrayList();
        this.tblEmpresa.setItems(cliente);
        // Asigno las columnas con los atributos del modelo
        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("Apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("Edad"));
        this.col_Id.setCellValueFactory(new PropertyValueFactory("Id"));
        this.colContacto.setCellValueFactory(new PropertyValueFactory("Contacto"));
        this.colDescuento.setCellValueFactory(new PropertyValueFactory("Descuento"));
    }    

    @FXML
    private void btnAgregaEmpresa(ActionEvent event) {
        try{
            
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String contacto = this.txtContacto.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            int descuento = Integer.parseInt(this.txtDescuento.getText());
            int id = Integer.parseInt(this.txtId.getText());
            
           Cliente c = new Empresa(contacto, nombre, apellido, edad, descuento,id);
            
            if(!this.cliente.contains(c)){
                this.cliente.add(c);
                this.tblEmpresa.setItems(cliente);
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
    private void btnElminarEmpresa(ActionEvent event) {
        Empresa c = (Empresa)this.tblEmpresa.getSelectionModel().getSelectedItem();
        
        if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un cliente");
                alert.showAndWait();
        }else{
            
            this.cliente.remove(c);
            this.tblEmpresa.refresh();
            
        }
    }

    @FXML
    private void btnModificarEmpresa(ActionEvent event) {
        Empresa c = (Empresa)this.tblEmpresa.getSelectionModel().getSelectedItem();
        
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
            String contacto = this.txtContacto.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            int id = Integer.parseInt(this.txtId.getText());
            int descuento = Integer.parseInt(this.txtDescuento.getText());
            
            Empresa aux = new Empresa(contacto ,nombre, apellido, edad, descuento, id);
            
            if(!cliente.contains(aux)){
                c.setNombre(aux.getNombre());
                c.setApellido(aux.getApellido());
                c.setDescuento(aux.getDescuento());
                c.setId(aux.getId());
                c.setEdad(aux.getEdad());
                c.setContacto(aux.getContacto());
                this.tblEmpresa.refresh();
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
    private void btnRegreso(ActionEvent event) {
        this.clientes = null;
        Stage stage= (Stage) this.btnAgregar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Seleccionar(MouseEvent event) {
        Empresa c = (Empresa) this.tblEmpresa.getSelectionModel().getSelectedItem();
        
        if(c !=null){
            this.txtApellido.setText(c.getApellido());
            this.txtNombre.setText(c.getNombre());
            this.txtContacto.setText(c.getContacto());
            this.txtId.setText(c.getId() + "");
            this.txtEdad.setText(c.getEdad() + "");
            this.txtDescuento.setText(c.getDescuento() + "");
            
        }
    }
    
}
