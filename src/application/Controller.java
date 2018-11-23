package application;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {
	
	@FXML
	AnchorPane pane1, pane2, pane3;
	
	@FXML
	Label labelContador;
	
	int numDiapositiva = 0;
	
	public void initialize() {
		desplazar(0.5, -500, pane2);
		desplazar(0.5, -500, pane3);
		labelContador.setText("1/3");
	}
	
	public void desplazar(double seconds ,int valorX, Node nodo) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(seconds), nodo);
		t.setByX(valorX);
		t.play();
	}
	
	public void atras() {
		if (numDiapositiva == 2) {
			desplazar(1, -500, pane3);
			labelContador.setText("2/3");
			numDiapositiva--;
		} else if (numDiapositiva == 1) {
			desplazar(1, -500, pane2);
			labelContador.setText("3/3");
			numDiapositiva--;
		} else {
			System.out.println("No hay mas diapositivas");
		}
	}
	
	public void siguiente() {
		if (numDiapositiva == 0) {
			desplazar(1, 500, pane2);
			labelContador.setText("2/3");
			numDiapositiva++;
			
		} else if (numDiapositiva == 1) {
			desplazar(1, 500, pane3);
			labelContador.setText("3/3");
			numDiapositiva++;
		} else {
			System.out.println("No hay más diapositivas");
		}
	}
}
