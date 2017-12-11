package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtSavingAnnualReturn;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtReturningAnnualReturn;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		txtYearsToWork.setText("");
		txtSavingAnnualReturn.setText("");
		txtYearsRetired.setText("");
		txtReturningAnnualReturn.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if (isInputValid()) {
			
		}
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		
	}
	
	private boolean isInputValid() {
		
		String errorMessage = "";
		if (txtYearsToWork.getText() == null || 
			txtYearsToWork.getText().length() == 0 ||
			!isValidNumber(txtYearsToWork.getText(), 0, 65)) {
			errorMessage += "Years of work is not valid!\n";
		}
		if (txtSavingAnnualReturn.getText() == null || 
			txtSavingAnnualReturn.getText().length() == 0 ||
			!isValidNumber(txtSavingAnnualReturn.getText(), 0, 20)) {
			errorMessage += "Saving Annual Return is not valid!\n";
		}
		if (txtYearsRetired.getText() == null || 
			txtYearsRetired.getText().length() == 0 ||
			!isValidNumber(txtYearsRetired.getText(), 0, 65)) {
			errorMessage += "Years Retired is not valid!\n";
		}
		if (txtReturningAnnualReturn.getText() == null || 
			txtReturningAnnualReturn.getText().length() == 0 ||
			!isValidNumber(txtReturningAnnualReturn.getText(), 0, 3)) {
			errorMessage += "Returning Annual Return is not valid!\n";
		}
		if (txtRequiredIncome.getText() == null || 
			txtRequiredIncome.getText().length() == 0 ||
			!isValidNumber(txtRequiredIncome.getText(), 0, 100)) {
			errorMessage += "Required Income is not valid!\n";
		}
		if (txtMonthlySSI.getText() == null || 
			txtMonthlySSI.getText().length() == 0 ||
			!isValidNumber(txtMonthlySSI.getText(), 0, 100)) {
			errorMessage += "Monthly SSI is not valid!\n";
		}
		
		// TODO validate all fields
		
		if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            // alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
		
	}
	
	private boolean isValidNumber(String value, int min, int max) {
		if (isInteger(value)) {
			int numberValue = Integer.parseInt(value);
			if (numberValue >= min && numberValue <= max) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
}
