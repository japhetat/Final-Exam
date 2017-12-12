package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

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
	
	@FXML
	private Label labelAmountToSave;
	
	@FXML
	private Label labelTotalAmountSaved;
	
	private static DecimalFormat MONEY_FORMAT = new DecimalFormat("$###,###,###,###.00");
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.labelAmountToSave.setText("");
		this.labelTotalAmountSaved.setText("");
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		this.txtYearsToWork.setText("");
		this.txtSavingAnnualReturn.setText("");
		this.txtYearsRetired.setText("");
		this.txtReturningAnnualReturn.setText("");
		this.txtRequiredIncome.setText("");
		this.txtMonthlySSI.setText("");
		this.labelAmountToSave.setText("");
		this.labelTotalAmountSaved.setText("");
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if (isInputValid()) {
			int yearsToWork = Integer.parseInt(this.txtYearsToWork.getText());
			double annualReturnWorking = Integer.parseInt(this.txtSavingAnnualReturn.getText()) / 100.00;
			int yearsRetired = Integer.parseInt(this.txtYearsRetired.getText());
			double annualReturnRetired = Integer.parseInt(this.txtReturningAnnualReturn.getText()) / 100.00;
			double requiredIncome = Double.parseDouble(this.txtRequiredIncome.getText());			
			double ssiIncome = Double.parseDouble(this.txtMonthlySSI.getText());
			Retirement retirement = 
					new Retirement(yearsToWork, annualReturnWorking, yearsRetired, 
							annualReturnRetired, requiredIncome, ssiIncome);
			this.labelAmountToSave.setText(MONEY_FORMAT.format(retirement.AmountToSave()));
			this.labelTotalAmountSaved.setText(MONEY_FORMAT.format(retirement.TotalAmountSaved()));
		}
		
	}
	
	private boolean isInputValid() {
		
		String errorMessage = "";
		if (txtYearsToWork.getText() == null || 
			txtYearsToWork.getText().length() == 0 ||
			!isValidNumber(txtYearsToWork.getText(), 1, 65)) {
			errorMessage += "Years of work is not valid! Use 1 - 65.\n";
		}
		if (txtSavingAnnualReturn.getText() == null || 
			txtSavingAnnualReturn.getText().length() == 0 ||
			!isValidNumber(txtSavingAnnualReturn.getText(), 0, 20)) {
			errorMessage += "Saving Annual Return is not valid! Use 0 - 20.\n";
		}
		if (txtYearsRetired.getText() == null || 
			txtYearsRetired.getText().length() == 0 ||
			!isValidNumber(txtYearsRetired.getText(), 1, 100)) {
			errorMessage += "Years Retired is not valid! Use 1 - 100.\n";
		}
		if (txtReturningAnnualReturn.getText() == null || 
			txtReturningAnnualReturn.getText().length() == 0 ||
			!isValidNumber(txtReturningAnnualReturn.getText(), 0, 3)) {
			errorMessage += "Returning Annual Return is not valid! Use 1 - 3.\n";
		}
		if (txtRequiredIncome.getText() == null || 
			txtRequiredIncome.getText().length() == 0 ||
			!isValidNumber(txtRequiredIncome.getText(), 0, 100000)) {
			errorMessage += "Required Income is not valid! Use any positive number.\n";
		}
		if (txtMonthlySSI.getText() == null || 
			txtMonthlySSI.getText().length() == 0 ||
			!isValidNumber(txtMonthlySSI.getText(), 0, 2642)) {
			errorMessage += "Monthly SSI is not valid! Use 0 - 2642.\n";
		}
		
	
		
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
