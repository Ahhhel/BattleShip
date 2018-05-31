import javax.swing.*;
import java.awt.*;
import java.io.*;

class MenoredadException extends Exception
{
  public MenoredadException(String mensaje)
  {
    super(mensaje);
  }
}

class NombreException extends Exception
{
  public NombreException(String mensaje)
  {
    super(mensaje);
  }
}

public class Battleship extends JFrame
{
  String nombreU;
  int edadU;
  boolean gano=false;
  JRadioButton grid[]=new JRadioButton[100];
  JPanel battle,user,historial,info,home,play,gameover;
  JButton atack,playb,coord;
  JLabel cordenda,jugador,edad,cc,his,st,turnos,turnol,nom,titulol,nombrejugador,barcosla,barcoslan;
  ImageIcon img,barc,sel,fail,titulo;
  ButtonGroup mallab;

  static  int turno = 10,undido=0,numbar=0;
  barcosc barquitos[]=new barcosc[10];
  gamefile part[] = new gamefile[10];
  int barcosx[]=new int[10];
  int barcosy[]=new int[10];
  int barcos[]=new int[100];
  int playerS =-1;


  public Battleship()
  {
    super("BATTLE SHIP");
    img = new ImageIcon("mar.png");
    barc = new ImageIcon("01.png");
    sel = new ImageIcon("02.png");
    fail = new ImageIcon("03.png");
    titulo = new ImageIcon("titulo.png");
    barcosla=new JLabel("Barcos:");
    barcoslan=new JLabel("10");
    mallab = new ButtonGroup();
    for (int i=0;i<100;i++)
    {
      //grid[i] = new JRadioButton(img);
      grid[i] = new JRadioButton(img);
      mallab.add(grid[i]);
    }
    for (int j=0;j<10;j++)
      part[j] = null;
    gameover = new JPanel();
    battle  = new JPanel();
    user = new JPanel();
    historial = new JPanel();
    info = new JPanel();
    play = new JPanel();
    home = new JPanel();

    atack = new JButton("Atacar");
    playb = new JButton("Jugar");
    coord = new JButton("Crear archivo de coordenadas");
    cordenda = new JLabel("x,y");
    jugador = new JLabel("Jugador:       ");
    edad = new JLabel("Edad: ");
    cc = new JLabel("By: team pelusita");
    his= new JLabel("Historial de batallas");
    st = new JLabel("1");
    turnos = new JLabel("10");
    turnol = new JLabel("Turnos:");
    nom = new JLabel("Edad:  ");
    titulol = new JLabel();
    nombrejugador=new JLabel(nombreU);

    setUser();
    sethis();
    setinfo();
    panels();
    homes();
    setHome();
  
    atack.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
        select();
        //JOptionPane.showMessageDialog(null,"its ok","Atacando",JOptionPane.WARNING_MESSAGE);
      }
    });

    coord.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
        pedir pb1=new pedir();
        //JOptionPane.showMessageDialog(null,"its ok","Atacando",JOptionPane.WARNING_MESSAGE);
      }  
    });

    playb.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
        try
        {
          nombreU = JOptionPane.showInputDialog(null,"Nombre: ");
          if (nombreU.length()==0)
            throw new NombreException("Nombre invalido");
          edadU = Integer.parseInt(JOptionPane.showInputDialog(null,"Edad:"));
          if(edadU <18) 
            throw new MenoredadException("Tienes que tener m\u00e1s de 18 a\u00f1os para poder jugar");
          else
          {
            modNombre();
            setPlay();
            carga();
            carga2();
            playerS=findUser(nombreU);
            if(playerS >=0)
              setGrid(playerS);
            else
            {
             //final NewGame juego = new NewGame(nombreU,edadU);
              //carga();
              setGrid(0);
            }

          }
        }catch (MenoredadException excep) 
        {
          JOptionPane.showMessageDialog(null,excep.getMessage(),"Menor de edad",JOptionPane.ERROR_MESSAGE);
        }catch(NombreException ex)
        {
          JOptionPane.showMessageDialog(null,ex.getMessage(),"Nombre invalido",JOptionPane.ERROR_MESSAGE);
        }catch(java.lang.NumberFormatException exxx)
        {
          JOptionPane.showMessageDialog(null,"Edad invalida","Edad invalida",JOptionPane.ERROR_MESSAGE);
        }

      }
    });

    for(int j=0;j<100;j++)
    {
      int x=j;
      if(grid[x]!=null)
      {
        grid[x].addMouseListener(new java.awt.event.MouseAdapter() 
        {
          public void mousePressed(java.awt.event.MouseEvent me) 
          {
            select2();
          }
        });
      }
    }

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocation(new Point(450, 250));
    setSize(500,200);
    setVisible(true);
    setResizable(false);
  }

  void select2()
  {
    for (int i=0;i<100;i++)
    {
      if(grid[i]!=null)
        if(grid[i].isSelected())
        {
          grid[i].setIcon(sel);
        }
        else
        {
          grid[i].setIcon(img);
        }
      }
  }


  void select()
  {
    for (int i=0;i<100;i++)
    {
      if(grid[i]!=null)
        if(grid[i].isSelected())
        {
          if(barcos[i]==1)
          {
            grid[i].setIcon(barc);
            JOptionPane.showMessageDialog(null,"LE DISTE!","Golpe",JOptionPane.WARNING_MESSAGE);
            for(int k=0;k<10;k++)
              if(barquitos[k].hit(i)&&barquitos[k].visto2())
              {
                System.out.println("hundido");
                JOptionPane.showMessageDialog(null,"LO HUNDISTE!","Barco hundido",JOptionPane.WARNING_MESSAGE);
                this.undido++;
                barcoslan.setText(Integer.toString(10-undido));
                barquitos[k].visto1();
              }
              else
              {
                System.out.println("no hundido");
              }
            barcos[i]=2;
            System.out.println(undido);
            if(undido==10)
              youWin();
          }
          else
          {
            this.turno-=1;
            turnos.setText(Integer.toString(this.turno));
            grid[i].setIcon(fail);
            if(turno ==0)end();
          }
          grid[i]=null;
        }
    }
  }

  void youWin()
  {
    gano=true;
    JOptionPane.showMessageDialog(null,"G A N A S T E","FIN DE LA PARTIDA",JOptionPane.PLAIN_MESSAGE); 
    over();
    setGameOver();
  }
  
  void end()
  {
    gano=false;
    for(int k =0;k<100;k++)
    {
      if(barcos[k]==1)
        if(grid[k]!=null)
          grid[k].setIcon(barc);
    }
    JOptionPane.showMessageDialog(null,"P E R D I S T E :c","FIN DE LA PARTIDA",JOptionPane.PLAIN_MESSAGE);
    over();
    setGameOver();
  }

  void modNombre()
  {
    nombrejugador.setText(nombreU);
  }
  void setHome()
  {
    remove(play);
    setContentPane(home);
    validate();
    repaint();
  }
  
  void setPlay()
  {
    remove(home);
    setLocation(new Point(500, 200));
    setSize(320,280);
    setContentPane(play);
    validate();
    repaint();
  }
    
  void setGameOver()
  {
    remove(play);
    setContentPane(gameover);
    validate();
    repaint();
  }
  
  void over()
  {
      NewGame juego=new NewGame(nombreU,edadU,gano,undido);
      carga();
      JLabel name,ed,eres,puntaje,score;
      eres = new JLabel("Eres:            ");
      puntaje = new JLabel("Puntaje:        ");
      gameover.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      gameover.add(jugador,gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      gameover.add(nom,gbc);
      gbc.gridx = 2;
      gbc.gridy = 0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      gameover.add(eres,gbc);
      gbc.gridx = 3;
      gbc.gridy = 0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      gameover.add(puntaje,gbc);
      for(int i =0;i<10;i++)
      {
        if(part[i]!=null)
        {
          name = new JLabel(part[i].name);
          ed= new JLabel(Integer.toString(part[i].edad));
          if(part[i].gana)
            eres = new JLabel("Ganador ");
          else
            eres = new JLabel("Perdedor ");
          score= new JLabel(Integer.toString(part[i].score));
        }
        else
        {
          name = new JLabel("---");
          ed = new JLabel("---");
          eres = new JLabel("---");
          score= new JLabel("---");
        }
        gbc.gridx = 0;
        gbc.gridy = i+1;
        gbc.fill =GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gameover.add(name,gbc);
        gbc.gridx = 1;
        gbc.gridy = i+1;
        gbc.fill =GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gameover.add(ed,gbc);
        gbc.gridx = 2;
        gbc.gridy = i+1;
        gbc.fill =GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gameover.add(eres,gbc);
        gbc.gridx = 3;
        gbc.gridy = i+1;
        gbc.fill =GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gameover.add(score,gbc);
      }
  }

  void homes()
  {
    home.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    titulol.setIcon(titulo);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    home.add(titulol,gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    home.add(playb,gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    home.add(coord,gbc);

  }
  
  void panels()
  {
          play.setLayout(new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.fill =GridBagConstraints.BOTH;
          gbc.anchor = GridBagConstraints.CENTER;
          play.add(battle,gbc);
          /*gbc.gridx = 1;
          gbc.gridy = 0;
          gbc.fill =GridBagConstraints.BOTH;
          gbc.anchor = GridBagConstraints.CENTER;
          play.add(historial,gbc);*/
          gbc.gridx = 1;
          gbc.gridy = 0;
          gbc.fill =GridBagConstraints.BOTH;
          gbc.anchor = GridBagConstraints.CENTER;
          play.add(user,gbc);
          gbc.gridx = 0;
          gbc.gridy = 1;
          gbc.fill =GridBagConstraints.BOTH;
          gbc.anchor = GridBagConstraints.CENTER;
          play.add(info,gbc);
  }

  void sethis()
  {
      historial.setLayout(new GridBagLayout());
      historial.setBorder(BorderFactory.createLineBorder(Color.black));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      historial.add(his,gbc);
  }

  void setinfo()
  {
      info.setLayout(new GridBagLayout());
      info.setBorder(BorderFactory.createLineBorder(Color.black));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      info.add(jugador,gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      info.add(nombrejugador,gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      info.add(cc,gbc);
  }

  void setUser()
  {
      user.setLayout(new GridBagLayout());
      user.setBorder(BorderFactory.createLineBorder(Color.black));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      user.add(turnol,gbc);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      user.add(barcosla,gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      user.add(barcoslan,gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      user.add(turnos,gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill =GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.CENTER;
      user.add(atack,gbc);
  }

  void setGrid(int s)
  {
    int rid=0;
    battle.setLayout(new GridBagLayout());
    battle.setBorder(BorderFactory.createLineBorder(Color.black));
    GridBagConstraints gbc = new GridBagConstraints();
    for (int i =0;i<10;i++)
    {
      for (int j=0;j<10;j++)
      {
        gbc.gridx = j;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill =GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        battle.add(grid[rid],gbc);
        rid++;
      }
    }
    barcoset();
    rid=0;
  }

  void barcoset()
  {
    for(int i=0;i<10;i++)
    {
      int corde=(barcosy[i]*10)+barcosx[i];

      switch(corde)
      {
        case 98:
        case 99:
        {
          menosbarco(corde,i);
          break;
        }
        case 88:
        case 89:
        {
          menosbarco(corde,i);
          break;
        }
        case 78:
        case 79:
        {
          menosbarco(corde,i);
          break;
        }
        case 68:
        case 69:
        {
          menosbarco(corde,i);
          break;
        }
        case 58:
        case 59:
        {
          menosbarco(corde,i);
          break;
        }
        case 48:
        case 49:
        {
          menosbarco(corde,i);
          break;
        }
        case 38:
        case 39:
        {
          menosbarco(corde,i);
          break;
        }
        case 28:
        case 29:
        {
          menosbarco(corde,i);
          break;
        }
        case 18:
        case 19:
        {
          menosbarco(corde,i);
          break;
        }
        case 8:
        case 9:
        {
          menosbarco(corde,i);
          break;
        }
        default:
        {
          barcos[corde]=1;
          barcos[corde+1]=1;
          barcos[corde+2]=1; 
          barquitos[i]=new barcosc(corde,corde+1,corde+2);
          break;
        }
      }
/*
      if(corde<98)
      {
        barcos[corde]=1;
        barcos[corde+1]=1;
        barcos[corde+2]=1; 
      }
      else
      {
        barcos[corde]=1;
        barcos[corde-1]=1;
        barcos[corde-2]=1; 
      } 
      */
    }

    for (int i=0;i<100;i++) 
    {
      if(barcos[i]==1)
        numbar++;
    }

  }

  void menosbarco(int corde,int i)
  {
    barcos[corde]=1;
    barcos[corde-1]=1;
    barcos[corde-2]=1; 
    barquitos[i]=new barcosc(corde,corde-1,corde-2);
  }


  
  void carga()
  {
    int cont = 0;
    try
    {
      DataInputStream CurrentFile = new DataInputStream(new FileInputStream("gdat.dat"));
      try
      {
        do
        {
          ObjectInputStream file = new ObjectInputStream(CurrentFile);
          gamefile Uno = (gamefile)file.readObject();
          System.out.println(Uno.edad);
          part[cont]= Uno;
          cont++;
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
  

  void carga2()
  {
    int cont2 = 0;
    try
    {
      DataInputStream CurrentFile2 =  new DataInputStream(new FileInputStream("barcos.dat")) ;
      try
      {
        do
        {
          int n1 =CurrentFile2.readInt();
          int n2= CurrentFile2.readInt();
          barcosx[cont2] = n1-1;
          barcosy[cont2]  = n2-1;
          System.out.println(barcosx[cont2]+" "+barcosy[cont2]);
          cont2++;
        }while(true);
      }catch (EOFException er) 
      {
      }catch (IOException err)
      {
      }
    }catch (FileNotFoundException err) 
    {
    }
  }


  public int findUser(String name)
  {
    int cn=0;
    boolean ok = false;
    while(part[cn]!=null && !ok)
    {
      if(part[cn].name.equals(name))
        ok = true;
      else
        cn++;
    }
    if(ok)
      return cn;
    else
      return -1;
  }

  public static void main(String[] args) 
  {
      Battleship p = new Battleship();
      //pedir p1=new pedir();
  }
}
