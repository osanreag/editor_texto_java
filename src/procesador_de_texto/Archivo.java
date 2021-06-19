package procesador_de_texto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
    //objeto de la clase file que representa de forma abstracta un archivo fisico en el disco 
	private File archivo;

	public Archivo(String nombre_archivo) {
		
		/*
		 * Construye un objeto de la clase archivo. 
		 * nombre_archivo la ruta completa del archivo a crear. 
		 * */

		archivo = new File(nombre_archivo);

	}

	public String dar_contenido() throws IOException {
		
		/*
		 * Retorna el contenido del archivo en un string y arroja una excecion cuando ocurre un problema.
		 * */

		String contenido = "";

		FileReader fr = new FileReader(archivo);

		BufferedReader lector = new BufferedReader(fr);

		String linea = lector.readLine();

		while (linea != null) {

			contenido += linea + "\n";

			linea = lector.readLine();
		}

		lector.close();

		fr.close();

		return contenido;

	}

	public void gurdar(String contenido) throws IOException {
		
		/*
		 * Gurada el contenido en un archivo nuevo o existente y lanza una excepcion. 
		 * */
		
		PrintWriter escritor = new PrintWriter(archivo);
		
		escritor.write(contenido);
		
		escritor.close();

	}

}
