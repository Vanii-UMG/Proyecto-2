package Controlador;

import Modelo.Cliente;
import Modelo.Empresa;
import Modelo.Producto;
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


public class ProductoController implements Initializable {

    @FXML
    private TableView<Producto> tblProducto;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colCantidad;
    @FXML
    private TableColumn col_Id;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;
    
    private Producto producto;
    
    public ObservableList<Producto> productos;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productos = FXCollections.observableArrayList();
        this.tblProducto.setItems(productos);
        // Asigno las columnas con los atributos del modelo
        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("Cantidad"));
        this.col_Id.setCellValueFactory(new PropertyValueFactory("Id"));
    }    

    @FXML
    private void seleccionar(MouseEvent event) {
        Producto c = this.tblProducto.getSelectionModel().getSelectedItem();
        
        if(c !=null){
            this.txtNombre.setText(c.getNombre());
            this.txtCantidad.setText(c.getCantidad() + "");
            this.txtId.setText(c.getId() + "");
            
            
        }
    }

    @FXML
    private void btnAgrego(ActionEvent event) {
        try{
            
            String nombre = this.txtNombre.getText();
            int cantidad = Integer.parseInt(this.txtCantidad.getText());
            int id = Integer.parseInt(this.txtId.getText());
            
            Producto c = new Producto(nombre,cantidad,id);
            
            if(!this.productos.contains(c)){
                this.productos.add(c);
                this.tblProducto.setItems(productos);
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
    private void btnElimino(ActionEvent event) {
        Producto c = this.tblProducto.getSelectionModel().getSelectedItem();
        
        if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un cliente");
                alert.showAndWait();
        }else{
            
            this.productos.remove(c);
            this.tblProducto.refresh();
            
        }
    }

    @FXML
    private void btnModifico(ActionEvent event) {
        Producto c = this.tblProducto.getSelectionModel().getSelectedItem();
        
        if(c == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un cliente");
                alert.showAndWait();
        }else{
            try{
                
            String nombre = this.txtNombre.getText();
            int id = Integer.parseInt(this.txtId.getText());
            int cantidad = Integer.parseInt(this.txtCantidad.getText());
            
            Producto aux = new Producto(nombre,cantidad, id);
            
            if(!productos.contains(aux)){
                c.setNombre(aux.getNombre());
                c.setId(aux.getId());
                c.setCantidad(aux.getCantidad());
                this.tblProducto.refresh();
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
        this.productos = null;
        Stage stage= (Stage) this.btnRegresar.getScene().getWindow();
        stage.close();
    }
    
}
