import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;
public class barcosc
{
  private static final long serialVersionUID = 6529685098267757690L;
  int p1,p2,p3;
  boolean hun=false,pe1,pe2,pe3,visto=true;
  barcosc(int p1,int p2,int p3)
  {
    this.p1=p1;
    this.p2=p2;
    this.p3=p3;
    pe1=true;
    pe2=true;
    pe3=true;
  } 

  public boolean hit(int punto)
  {
  	if(punto==p1)
  		pe1=false;
  	if(punto==p2)
  		pe2=false;
  	if(punto==p3)
  		pe3=false;
  	if(pe1==false&&pe2==false&&pe3==false)
  	{
  		hun=true;
  		return hun;
  	}
  	else
  		return hun;
  }
  public void visto1()
  {
  	visto=false;
  }
  public boolean visto2()
  {
  	return visto;
  } 
}