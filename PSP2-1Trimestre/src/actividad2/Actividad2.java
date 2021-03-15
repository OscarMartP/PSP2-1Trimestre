package actividad2;

import java.io.IOException;
import java.io.InputStream;

public class Actividad2 {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "dir", "c:\\"); 
		

		try {
			pb.start(); 
			Process p = pb.start(); 
			
			p.waitFor(); 

			sacarPorPantalla(p); 

			sacarErrores(p); 

		} catch (IOException | InterruptedException e) {

			System.out.println("Error al lanzar el comando");
			e.printStackTrace();
		}

	}

	private static void sacarErrores(Process p) {

		InputStream is = p.getErrorStream();
		int letra = 0;

		try {

			while ((letra = is.read()) != -1) { 

				System.out.print((char) letra);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void sacarPorPantalla(Process p) {		
			
			InputStream is = p.getInputStream();		 	
										
									
			int letra = 0;
			
			try {
				
				while((letra=is.read())!=-1) {			 
					
					System.out.print((char)letra);
					
				}
				
			} catch (IOException e) {
				
				System.out.println("Error al leer");
				e.printStackTrace();
				
			}
			
	}
}