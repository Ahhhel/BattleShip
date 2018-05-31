import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class NewGame implements Serializable 
{
  private static final long serialVersionUID = 6529685098267757690L;
  String nombre;
  int edad=0,score=0;
  boolean gana=false;
  public NewGame(String _nombre,int _edad,boolean gana,int score)
  {
    nombre = _nombre;
    edad = _edad;
    this.score=score;
    this.gana=gana;
    saveGameData();
  }

  public void saveGameData()
  {
    try
    {
      DataOutputStream CurrentFile=new DataOutputStream(new FileOutputStream("gdat.dat",true));
      ObjectOutputStream Objfi = new ObjectOutputStream(CurrentFile);
      Objfi.writeObject(new gamefile(this.nombre,this.edad,this.gana,this.score));
      Objfi.flush();
      Objfi.close();
    }catch (IOException e)
    {
    }
     //JOptionPane.showMessageDialog(null,"","Juego Listo",JOptionPane.PLAIN_MESSAGE);
  }
}
