package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import procesador_de_texto.Editor;

public class Interfaz_Editor extends JFrame {

	private JPanel contentPane;
	private Panel_acciones panel_acciones;
	private Panel_Edicion panel_Edicion;

	private Editor editor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Editor frame = new Interfaz_Editor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz_Editor() {
		editor = new Editor();
		setTitle("Editor de archivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_acciones = new Panel_acciones(this);
		contentPane.add(panel_acciones, BorderLayout.NORTH);

		panel_Edicion = new Panel_Edicion();
		contentPane.add(panel_Edicion, BorderLayout.CENTER);
	}

	public void abrir_archivo() {

		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			String contenido = "";
			try {
				contenido = editor.abrir_archivo(f.getAbsolutePath());
				panel_Edicion.refrescar_contenido(contenido);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showInputDialog(this, e.getMessage(), "Editor de archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void crear_archivo() {

		editor.crear_archivo();
		panel_Edicion.refrescar_contenido("");

	}

	public void guardar_archivo() {
		String contenido = "";
		String ruta_archivo = "";

		if (editor.es_archivo_nuevo()) {
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				ruta_archivo = fc.getSelectedFile().getAbsolutePath();
				
			}
		} 
		
		contenido = panel_Edicion.dar_contenido();
		try {
			editor.gurdar_archivo(contenido, ruta_archivo);
			JOptionPane.showMessageDialog(this, "Archivo guardado con exito", "Editor de archivo",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showInputDialog(this, e.getMessage(), "Editor de archivo", JOptionPane.ERROR_MESSAGE);
		}
	}

}
