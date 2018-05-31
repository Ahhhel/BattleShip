import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;


public class pedirbarcos implements Serializable
{
   private static final long serialVersionUID = 6529685098267757690L;
  public pedirbarcos(int xs,int ys)
  {
    try
    {
      DataOutputStream CurrentFile=new DataOutputStream(new FileOutputStream("barcos.dat",true));
      ObjectOutputStream Objfi = new ObjectOutputStream(CurrentFile);
       Objfi.writeObject(new barcosc(xs,ys));
      //Objfi.flush();
      Objfi.close(); 
    }catch (IOException e)
    {
    }
    JOptionPane.showMessageDialog(null,"Se creo !","Juego Listo",JOptionPane.PLAIN_MESSAGE);
  }
}
