

import java.io.*;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import Jama.Matrix;

//"C:/Users/user/Desktop/numeros/test/0/"+numi+".png"

public class ReconocimientoImagenes {
	
	private int alto,ancho = 0;
	private File f;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter pw;
	private double[][] imagenM; 
	private Matrix matriz0;
	private Matrix matriz1;
	private Matrix matriz2;
	private Matrix matriz3;
	private Matrix matriz4;
	private Matrix matriz5;
	private Matrix matriz6;
	private Matrix matriz7;
	private Matrix matriz8;
	private Matrix matriz9;
	
	
	public ReconocimientoImagenes()
	{
			imagenM = new double[784][1];
		    matriz0= new Matrix(784, 300);
			matriz1= new Matrix(784, 300);
			matriz2= new Matrix(784, 300);
			matriz3= new Matrix(784, 300);
			matriz4= new Matrix(784, 300);
			matriz5= new Matrix(784, 300);
			matriz6= new Matrix(784, 300);
			matriz7= new Matrix(784, 300);
			matriz8= new Matrix(784, 300);
			matriz9= new Matrix(784, 300);
			
	}
	
	
	
	public void llenarMatrices( int arch)
	{
		  String cadena;
		  FileReader f;
		try {
			
			
			f = new FileReader("C:\\Users\\user\\Desktop\\archivos proyecto\\"+arch+".txt");
			BufferedReader b = new BufferedReader(f);
			cadena = b.readLine();
			StringTokenizer token = new StringTokenizer(cadena);
			String datoString;
			
		      
		    	  
		    	   for (int r = 0; r<300;r++)
			          {
			        	  for (int w = 0; w<784;w++)
			        	  {
			        		  
			        		      
			        		  datoString = token.nextToken();
			        		  matriz0.set(w,r, Double.parseDouble(datoString));
			        		  System.out.print( matriz0.get(w, r));
			    		      
			        	  }
			        	  
			        	  System.out.println();
			          }
		          
		       
		      
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}

	public void convertirImagen(String ruta)
	{
		
		try {
			
			InputStream archivo;
			archivo = new FileInputStream(ruta);
			ImageInputStream imagen = ImageIO.createImageInputStream(archivo);
			BufferedImage imagenB = ImageIO.read(imagen);
			int count = 0;
		
			
			for(int w = 0; w< 28;w++)
			{
				for (int r = 0; r<28;r++)
				{
					int num = imagenB.getRGB(r,w);
					
					Color color = new Color(num);
					int numf = color.getGreen();
					
					if(numf >= 255)
					{
						imagenM[count][0] = 0.0;
						//System.out.print(imagenM[count][0]);
						
					}
					else if(numf<255)
					{
						imagenM[count][0] = 1.0;
						//System.out.print(imagenM[count][0]);

						
					}
					count++;
				}
				
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	public void matrizDeimagen(int numi)
	{
		
		
		try {
			
			InputStream archivo;
			archivo = new FileInputStream("C:/Users/user/Desktop/numeros/test/0/"+numi+".png");
			ImageInputStream imagen = ImageIO.createImageInputStream(archivo);
			BufferedImage imagenB = ImageIO.read(imagen);
			
		
			
			for(int w = 0; w< 28;w++)
			{
				for (int r = 0; r<28;r++)
				{
					int num = imagenB.getRGB(r, w);
					
					Color color = new Color(num);
					int numf = color.getGreen();
					
					if(numf >= 255)
					{
						pw.write(0+" ");
						
					}
					else if(numf<255)
					{
						pw.write(1+" ");

						
					}
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
	public void llenarBase(int numeroDeimagenes )
	
	{
		try
		{
			int count =0;
			
				
		for(int j = 0 ; j<10; j++)
			{ count = 0;
				
				f = new File("C:\\Users\\user\\Desktop\\archivos proyecto\\"+j+".txt");
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				
				
				for (int i = 1; i<= numeroDeimagenes;i++ )
				{
					matrizDeimagen(i);
					
					
				}
				
				
				
				try {
					bw.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		catch(Exception e)
		{
			System.out.print("error file not found ");

		}
		
	
		
		
		
	}
	

	
	
	
	public static void main(String[] args) {
		
		
		ReconocimientoImagenes obj = new ReconocimientoImagenes();
		
		obj.convertirImagen("C:/Users/user/Desktop/numeros/test/0/1.png");
		obj.llenarBase(300);
		obj.llenarMatrices(0);
		
		
		// TODO Auto-generated method stub

	}


}
