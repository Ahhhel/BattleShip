import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class barcosc implements Serializable
{
  private static final long serialVersionUID = 6529685098267757690L;
  int xx,yy;
  barcosc(int x,int y)
  {
    xx=x;
    yy=y;
  }  
}

class prueba implements Serializable
{
	private static final long serialVersionUID = 6529685098267757690L;
	barcosc barcoss[]=new barcoss[10];

	static void carga2()
	{
	    int cont2 = 0;
	    try
	    {
	      DataInputStream CurrentFile2 = new DataInputStream(new FileInputStream("barcos.dat"));
	      try
	      {
	        do
	        {
	          ObjectInputStream file2 = new ObjectInputStream(CurrentFile2);
	          barcosc dos = (barcosc)file2.readObject();
	          barcoss[cont2]=dos;
	          cont2++;
	        }while(true);
	      }catch (EOFException e) 
	      {
	      }catch (IOException e)
	      {
	      }
	    }catch (FileNotFoundException e) 
	    {
	    }catch (ClassNotFoundException  e) 
	    {
	    }
	}


	public static void main(String[] args) 
	{
		carga2();
		for (int i=0;i<10;i++) 
		{
			System.out.println(barcoss[i].xx+" "+barcoss[i].yy);		
		}	
	}
}