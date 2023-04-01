import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set; // para cosas mas grandes
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileWriter;


public class CorreoSpam {
	
	
    public static int nucol = 3002;
    public static int[]sum = new int[nucol];
	
	//SI ENTRADA ES ENTERO: ponerlo como string y remplazar los primeros 3 digitos a 0 del arreglo y luego a entero
	//Si es string esta mas facile
	public void  ejecutar(String eids) {
		//System.out.println("sub: "+eids);
		
		String ssd= eids.substring(3,6);
		
		int idis=Integer.parseInt(ssd);
		//System.out.println("parseInt "+idis);
		int renglono=idis;
		int renglonf=idis+49;
				
		//Lector miLectorExamen = new Lector();
		//miLectorExamen.ejecutar("160808");
		 
		//int d= ejecutar("160808");
		
		String archivoCSV = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/emails.csv";
		String datosfin = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/160808.txt";
		
		//Set<Integer>col = new HashSet<>(Arrays.asList(0,1,2,3));
		
		//int renglono;
		//this.idis=renglono;
		
//		int renglono=this.idis; //808
		//int renglonf = idis+50; //858
		{
		
		try(BufferedReader b = new BufferedReader(new FileReader(archivoCSV));
			BufferedWriter p = new BufferedWriter(new FileWriter(datosfin))){
			
			String []palas=b.readLine().split(",");
			
			String linea;
			int numren=0;
			
			for(numren=0;(linea=b.readLine())!=null; numren++) {
				if(numren>=renglono && numren<=renglonf) {
					String[]columnas=linea.split(",");
					for(int i=0; i<columnas.length && i<nucol; i++) {
						try {
							sum[i]+=Integer.parseInt(columnas[i]);
						}
						catch(NumberFormatException e) {
							
						}
					}
				}
			/*while((linea = b.readLine()) !=null) {
				if(numren>=renglono && numren<=renglonf) {
					
					String[] columnas = linea.split(",");
						
					for (int x=0; x<columnas.length; x++) {
	                    if(col.contains(x)) {
	                    	System.out.print(columnas[x]+"\t");
	                    }
	                }
					System.out.println();
				}
			numren++;

			}*/
			}
			for(int i=0; i<palas.length; i++) {
				p.write(String.format("%-20s", palas[i]));
				if(i<sum.length) {
					p.write(String.format("%20d", sum[i]));
				}
				p.newLine();
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
	/////////////////////////ENTERO///////////////////////////////
	
	public void ejecutar(int eidi) {
		String si=Integer.toString(eidi);
		String ssi = si.substring(3,6);
		//System.out.println("sub: "+ssi);
		
		int idis=Integer.parseInt(ssi);
		//System.out.println("parseInt"+idis);
		int renglono=idis;
		int renglonf=idis+49;
			
		
		String archivoCSV = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/emails.csv";
		String datosfin = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/160808.txt";
		
		//Set<Integer>col = new HashSet<>(Arrays.asList(0,1,2,3));
		
		{
		
		try(BufferedReader b = new BufferedReader(new FileReader(archivoCSV));
			BufferedWriter p = new BufferedWriter(new FileWriter(datosfin))){
			
			String []palas=b.readLine().split(",");
			
			String linea;
			int numren=0;
			
			for(numren=0;(linea=b.readLine())!=null; numren++) {
				if(numren>=renglono && numren<=renglonf) {
					String[]columnas=linea.split(",");
					for(int i=0; i<columnas.length && i<nucol; i++) {
						try {
							sum[i]+=Integer.parseInt(columnas[i]);
						}
						catch(NumberFormatException e) {
							
						}
					}
				}
			}
			for(int i=0; i<palas.length; i++) {
				p.write(String.format("%-20s", palas[i]));
				if(i<sum.length) {
					p.write(String.format("%20d", sum[i]));
				}
				p.newLine();
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
	
}

