import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set; // para cosas mas grandes
import java.util.HashSet;
import java.util.Scanner;


//ver si cambio a private o public

public class Lector {
	//Set<Integer>col = new HashSet<>(Arrays.asList(0,1,2,3));
	
	private String archivoCSV = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/emails.csv";
	
	private String datosfin = "C:\\Users\\majes\\Documents\\MECATRÓNICA\\POO/160808.txt";
	
	//int nucol=3001;
	private int nucol=3002;
	private int[]sum= new int[nucol];
	 
		
	//CAMBIAR ORDEEEEEEEEEEEN
	public void ejecutar (String eids) {
		String ssd= eids.substring(3,6);
		int idis=Integer.parseInt(ssd);
		
		int renglono=idis;
		int renglonf=idis+50;
		System.out.println("primer renglon: "+renglono);
		System.out.println("ultimo renglon: "+renglonf+"\n");
		
		try(BufferedReader b = new BufferedReader(new FileReader(archivoCSV));
			
			BufferedWriter p= new BufferedWriter (new FileWriter(datosfin))){
			
			String [] palas= b.readLine().split(",");
			String linea;
			int numren=0;
			
			for(numren=0; (linea=b.readLine())!=null;numren++) {
				if(numren >= renglono && numren <= renglonf) {
                    String[] columnas = linea.split(",");
                    for(int k=0;  k<columnas.length && k<nucol; k++) {
                    	try {
                    		sum[k]+=Integer.parseInt(columnas[k]);
                    	}
                    	catch(NumberFormatException ex) {
                    		
                    	}
                    }
				}
			}
			
			//
			for (int c=0; c<palas.length; c++) {
				p.write(String.format("%-20s",palas[c]));
				
				if(c<sum.length) {
					p.write(String.format("%20d", palas[c]));
				}
			}
			
		}
		catch(IOException ex) {
            ex.printStackTrace();

		}
		
	}
}

