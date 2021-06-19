package interfaz;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_acciones extends JPanel implements ActionListener{
	
	public static final String crear = "Crear";
	public static final String abrir = "Abrir";
	public static final String guardar = "Guardar";
	private JButton btn_abrir;
	private JButton btn_crear;
	private JButton btn_guardar;
	
	private Interfaz_Editor principal; 
	
	public Panel_acciones(Interfaz_Editor principal) {
		
		//Esto se hace para que el editor muestre los elemento y no de un error. 
		this();
		
		this.principal=principal;
	}

	/**
	 * Create the panel.
	 */
	public Panel_acciones() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		
		btn_abrir = new JButton("Abrir");
		btn_abrir.setActionCommand(abrir);
		btn_abrir.addActionListener(this);
		add(btn_abrir);
		
		btn_crear = new JButton("Crear");
		btn_crear.setActionCommand(crear);
		btn_crear.addActionListener(this);
		add(btn_crear);
		
		btn_guardar = new JButton("Guardar");
		btn_guardar.setActionCommand(guardar);
		btn_guardar.addActionListener(this);
		add(btn_guardar);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
		if(evento.getActionCommand().equals(abrir)) {
			
			principal.abrir_archivo();
			
		}else if(evento.getActionCommand().equals(crear)) {
			
			principal.crear_archivo();
			
		}else if(evento.getActionCommand().equals(guardar)) {
			
			principal.guardar_archivo();
			
		}
	}

}
