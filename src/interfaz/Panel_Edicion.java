package interfaz;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Panel_Edicion extends JPanel {
	private JTextArea ta_edicion;
	public Panel_Edicion() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		ta_edicion = new JTextArea();
		scrollPane.setViewportView(ta_edicion);
	}

	public String dar_contenido() {
		return ta_edicion.getText();
	}
	
	public void refrescar_contenido(String contenido) {
		
		ta_edicion.setText(contenido);
	}
}
