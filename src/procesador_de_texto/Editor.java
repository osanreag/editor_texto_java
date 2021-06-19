package procesador_de_texto;

import java.io.IOException;

public class Editor {

	//Este archivo representa el archivo que esta cargado en el editor. 
	private Archivo archivo;

	public Editor() {
		
		/*construye un objeto de la clase editor*/

		archivo = null;
	}

	public String abrir_archivo(String nombre_archivo) throws Exception {

		/*
		 * Abrir de texto existente post: el atributo archivo debe haber sido
		 * inicializado. nombre_archivo la ruta del archivo con su respectivo nombre.
		 * esto devuelve un string con el contenido del archivo.
		 */
		String contenido = "";
		archivo = new Archivo(nombre_archivo);
		try {
			contenido=archivo.dar_contenido();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 throw new Exception ("Error leyendo el archivo",e);
		}
		return contenido; 

	}

	public void crear_archivo() {

		/*
		 * Crear un nuevo archivo de texto en el editor.
		 * 
		 * post: el archivo es igual a null.
		 */
		
		archivo=null; 

	}

	public void gurdar_archivo(String contenido, String ruta_archivo) throws Exception {

		/*
		 * Guardar el contenido de un archivo nueo o existente el contenido es un string
		 * con el texto ingresado
		 * 
		 * ruta_archivo es la ruta donde se va a guardar el archivo.
		 * arroja una excepcion cuando ocurre un error escribiendo el archivo. 
		 */
		
		if(archivo == null) {
			
			archivo=new Archivo(ruta_archivo);
		}		
		try {
			archivo.gurdar(contenido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al guardar el archivo",e);
		}
	}
	
	public boolean es_archivo_nuevo() {
		//indica si el archivo del editor es nuevo o no y retorna true si el archivo es nuevo y false en caso contrario. 
		return archivo==null;
	}

}
