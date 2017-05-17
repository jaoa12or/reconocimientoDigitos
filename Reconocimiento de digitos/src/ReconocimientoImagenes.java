
import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.CORBA.PRIVATE_MEMBER;


public class ReconocimientoImagenes {
	
	private int alto,ancho = 0;
	private File f;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter pw;
	private String ruta;
	private String ruta2;
	
	private boolean crear;
	
	
	public ReconocimientoImagenes()
	{
		
		
		crear = true;
	}
	
	
		
	
	
	
	
	public void convertirImagen(int numeroDeimagenes )
	
	{
		try
		{
			int count =0;
			
				
		for(int j = 0 ; j<10; j++)
			{ count = 0;
				
				f = new File("/home/invitado/"+j+".txt");
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				
				
				for (int i = 1 ; i<= numeroDeimagenes;i++ )
				{
					InputStream archivo = new FileInputStream("/home/invitado/test/"+j+"/"+i+".png");
					ImageInputStream imagen = ImageIO.createImageInputStream(archivo);
					BufferedImage imagenB = ImageIO.read(imagen);
					
					alto = imagenB.getHeight();
					ancho = imagenB.getWidth();
					
					for(int w = 0; w< 28;w++)
					{
						for (int r = 0; r<28;r++)
						{
							int num = imagenB.getRGB(r, w);
							
							Color color = new Color(num);
							int numf = color.getGreen();
							
							if(numf == 255)
							{
								pw.write("0");
								//System.out.print(0);
							}
							else
							{
								pw.write("1");

								//System.out.print(1);
							}
							
							
							
						}
						
						//pw.println();
						//System.out.println();
					}
					count++;
					//pw.println();
				}
				
				pw.print(count);
				
			}
			
			
			
		
			
			
			
		}
		
		
		catch(Exception e)
		{
			System.out.print("error file not found ");

		}
		
		try {
			bw.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	
	
	
	public static void main(String[] args) {
		
		
		ReconocimientoImagenes obj = new ReconocimientoImagenes();
		
		
		obj.convertirImagen(200);
		
		
		// TODO Auto-generated method stub

	}


}
