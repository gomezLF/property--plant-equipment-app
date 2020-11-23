package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Asset;
import model.PPE;


public class DeregisterMenuController {
	
	private PPE PPE;
	
	private List<Asset> listedAssets;
	
    @FXML
    private JFXCheckBox depreciableAsset_checkBox;

    @FXML
    private JFXCheckBox nonDepreciableAsset_checkBox;
    
    @FXML
    private JFXComboBox<String> category_comboBox;

    @FXML
    private VBox registrationDate_VBox;
    
    @FXML
    private JFXButton showCategory_button;
    
    @FXML
    private JFXDatePicker registrationDate_TextField;

    @FXML
    private TableView<Asset> data_TableView;
    
    @FXML
    private TableColumn<Asset, String> nameColum;

    @FXML
    private TableColumn<Asset, Double> valueColum;

    @FXML
    private TableColumn<Asset, String> categoryColum;

    @FXML
    private TableColumn<Asset, LocalDate> registrationDatecolumn;
    
    
    
    @FXML
    void initialize() {
    	depreciableAssetClicked();
    	registrationDate_VBox.setDisable(true);
    	createTableColumns();
    }
    
    
    
    
    @FXML
    void cleanFieldsClicked(ActionEvent event) {
    	
    }
    
    @FXML
    void showCategoryClicked(ActionEvent event) {

    }
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	if(category_comboBox.getValue() != null) {
    		registrationDate_VBox.setDisable(false);
        	
			if(depreciableAsset_checkBox.isSelected()) {
				addDataToTable(PPE.getDerpeciableAssets().get(category_comboBox.getValue()));
				
			}else {
				addDataToTable(PPE.getNonDepreciableAsset().get(category_comboBox.getValue()));
			}
    			
    		
    	}
    }
    
    @FXML
    void depreciableAssetClicked() {
    	depreciableAsset_checkBox.setSelected(true);
    	nonDepreciableAsset_checkBox.setSelected(false);
    	
    	data_TableView.getItems().clear();
    	updateDepreciableCategories();
    }

    @FXML
    void nonDepreciableAssetClicked() {
    	nonDepreciableAsset_checkBox.setSelected(true);
    	depreciableAsset_checkBox.setSelected(false);
    	
    	data_TableView.getItems().clear();
    	updateNonDepreciableCategories();
    }
    
    @FXML
    void registrationDateClicked(ActionEvent event) {
    	data_TableView.getItems().clear();
    	
		List<Asset> data = filterAssets();
		data_TableView.getItems().addAll(data);
    }
    
    
    
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    
    
    
    private void updateDepreciableCategories() {
    	category_comboBox.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	category_comboBox.getItems().clear();
    	
    	Hashtable<String, List<Asset>> hash = PPE.getDerpeciableAssets();
    	List<String> list = Collections.list(hash.keys());
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				category_comboBox.getItems().add(list.get(i));
			}
		}
    }
    
    private void updateNonDepreciableCategories() {
    	category_comboBox.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	category_comboBox.getItems().clear();
    	
    	Hashtable<String, List<Asset>> hash = PPE.getNonDepreciableAsset();
    	List<String> list = Collections.list(hash.keys());
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				category_comboBox.getItems().add(list.get(i));
			}
		}
    }
    
    
    
    
	private void createTableColumns() {
    	nameColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("name"));
    	valueColum.setCellValueFactory(new PropertyValueFactory<Asset, Double>("value"));
    	categoryColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("category"));
    	registrationDatecolumn.setCellValueFactory(new PropertyValueFactory<Asset, LocalDate>("registrationDate"));
    }
	
	private void addDataToTable(List<Asset> list) {
		data_TableView.getItems().clear();
		listedAssets = list;
		data_TableView.getItems().addAll(list);
	}
	
	private List<Asset> filterAssets(){
		List<Asset> data = new ArrayList<Asset>();
		
		for (Asset asset : listedAssets) {
			if(asset.getRegistrationDate().compareTo(registrationDate_TextField.getValue()) == 0) {
				data.add(asset);
			}
		}
		
		return data;
	}
}
