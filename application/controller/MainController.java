package application.controller;

import application.model.Mission;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainController implements EventHandler<ActionEvent>{
	@FXML
	Button a11;
	@FXML
	Button a13;
	@FXML
	Button a15;
	@FXML
	Text tTitle;
	@FXML
	Text tDescription;
	@FXML
	Text tLeft;
	@FXML
	ImageView iLeft;
	@FXML
	Text tRight;
	@FXML
	ImageView iRight;
	
	@Override
	public void handle(ActionEvent event) {		
		String name = event.getSource().toString().substring(11,13);
		
		Mission mission = new Mission(name);
		
		tLeft.setVisible(true);
		iLeft.setVisible(true);
		tRight.setVisible(true);
		iRight.setVisible(true);
		
		tTitle.setText("Mission: " + mission.getName());
		tDescription.setText(""
				+ mission.getType()
				+ "\nOperated by: " + mission.getOperator()
				+ "\nYear: " + mission.getYear()
				+ "\nCommander: " + mission.getCrew(0)
				+ "\nCommander Module Pilot (CMP): " + mission.getCrew(1)
				+ "\nLunar Modulte Pilot: " + mission.getCrew(2)
		);
		
		tLeft.setText(mission.getCraft(0));
		tRight.setText(mission.getCraft(1));
		
		Image image;
		image = new Image("/images/Apollo" + name + "-CM.jpg");
		iLeft.setImage(image);
		image = new Image("/images/Apollo" + name + "-LM.jpg");
		iRight.setImage(image);
	}
}