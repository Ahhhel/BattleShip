import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class pedir extends JFrame
{
	private static final long serialVersionUID = 6529685098267757690L;
  JPanel def,cerrar;
  JButton dar;
  JLabel xeti,yeti,cerrarl,cerrarl2;
  JTextField xt1,xt2,xt3,xt4,xt5,xt6,xt7,xt8,xt9,xt10,yt1,yt2,yt3,yt4,yt5,yt6,yt7,yt8,yt9,yt10;
  int xd,yd;

  public pedir()
  {
    super("Coordenadas");
    cerrar=new JPanel();
    cerrarl=new JLabel("Listo");
    cerrarl2=new JLabel("(Puedes cerrar esta ventana)");
    def=new JPanel();
    dar=new JButton("Establecer Coordenadas");
    xeti=new JLabel("X");
    yeti=new JLabel("Y");
    xt1=new JTextField();
    xt2=new JTextField();
    xt3=new JTextField();
    xt4=new JTextField();
    xt5=new JTextField();
    xt6=new JTextField();
    xt7=new JTextField();
    xt8=new JTextField();
    xt9=new JTextField();
    xt10=new JTextField();
    yt1=new JTextField();
    yt2=new JTextField();
    yt3=new JTextField();
    yt4=new JTextField();
    yt5=new JTextField();
    yt6=new JTextField();
    yt7=new JTextField();
    yt8=new JTextField();
    yt9=new JTextField();
    yt10=new JTextField();
    pack();
    setLocation(new Point(600, 150));
    setSize(250,290);
    setVisible(true);
    setResizable(false);

    def.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    def.add(xeti,gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    def.add(yeti,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 1;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt1,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 1;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt1,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 2;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt2,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 2;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt2,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 3;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt3,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 3;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt3,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 4;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt4,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 4;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt4,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 5;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt5,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 5;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt5,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 6;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt6,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 6;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt6,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 7;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt7,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 7;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt7,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 8;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt8,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 8;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt8,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 9;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt9,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 9;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt9,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 0;
    	gbc.gridy = 10;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(xt10,gbc);
    	gbc.weightx = 9.0;
      	gbc.weighty = 0.0;
    	gbc.gridx = 1;
    	gbc.gridy = 10;
   		gbc.fill =GridBagConstraints.BOTH;
    	gbc.anchor = GridBagConstraints.CENTER;
    	def.add(yt10,gbc);
    gbc.gridx = 2;
    gbc.gridy = 5;
    gbc.fill =GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.CENTER;
    def.add(dar,gbc);

    setContentPane(def);
    validate();
    repaint();

    dar.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
      	try
        {
          int x1=Integer.parseInt(xt1.getText());
          int y1=Integer.parseInt(yt1.getText());
          int x2=Integer.parseInt(xt2.getText());
          int y2=Integer.parseInt(yt2.getText());
          int x3=Integer.parseInt(xt3.getText());
          int y3=Integer.parseInt(yt3.getText());
          int x4=Integer.parseInt(xt4.getText());
          int y4=Integer.parseInt(yt4.getText());
          int x5=Integer.parseInt(xt5.getText());
          int y5=Integer.parseInt(yt5.getText());
          int x6=Integer.parseInt(xt6.getText());
          int y6=Integer.parseInt(yt6.getText());
          int x7=Integer.parseInt(xt7.getText());
          int y7=Integer.parseInt(yt7.getText());
          int x8=Integer.parseInt(xt8.getText());
          int y8=Integer.parseInt(yt8.getText());
          int x9=Integer.parseInt(xt9.getText());
          int y9=Integer.parseInt(yt9.getText());
          int x10=Integer.parseInt(xt10.getText());
          int y10=Integer.parseInt(yt10.getText());
          try
          {
            //DataOutputStream CurrentFile=new DataOutputStream(new FileOutputStream("barcos.dat",false));
            //ObjectOutputStream lol = new ObjectOutputStream(CurrentFile);
            DataOutputStream lol=new DataOutputStream(new FileOutputStream("barcos.dat"));

            lol.writeInt(x1);
            lol.writeInt(y1);
            lol.writeInt(x2);
            lol.writeInt(y2);
            lol.writeInt(x3);
            lol.writeInt(y3);
            lol.writeInt(x4);
            lol.writeInt(y4);
            lol.writeInt(x5);
            lol.writeInt(y5);
            lol.writeInt(x6);
            lol.writeInt(y6);
            lol.writeInt(x7);
            lol.writeInt(y7);
            lol.writeInt(x8);
            lol.writeInt(y8);
            lol.writeInt(x9);
            lol.writeInt(y9);
            lol.writeInt(x10);
            lol.writeInt(y10);

            /*lol.writeObject(new barcosc(x2,y2));
            lol.writeObject(new barcosc(x3,y3));
            lol.writeObject(new barcosc(x4,y4));
            lol.writeObject(new barcosc(x5,y5));
            lol.writeObject(new barcosc(x6,y6));
            lol.writeObject(new barcosc(x7,y7));
            lol.writeObject(new barcosc(x8,y8));
            lol.writeObject(new barcosc(x9,y9));
            lol.writeObject(new barcosc(x10,y10));*/
            //lol.flush();
            lol.close(); 
            remove(def);
            setContentPane(cerrar);
            validate();
            repaint();
          }catch (IOException exx)
           {
           }
        }catch(java.lang.NumberFormatException e9)
        {
          JOptionPane.showMessageDialog(null,"Introduce NUMEROS en las casillas","Faltan numeros",JOptionPane.ERROR_MESSAGE);
        }
        
    	 //JOptionPane.showMessageDialog(null,cadena,"Nombre invalido",JOptionPane.ERROR_MESSAGE);
      }
    });

    cerrar.setLayout(new GridBagLayout());
    GridBagConstraints gbc2 = new GridBagConstraints();
    cerrarl.setFont(new java.awt.Font("Times New Roman", 0, 28));
    cerrarl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gbc2.fill =GridBagConstraints.BOTH;
    gbc2.anchor = GridBagConstraints.CENTER;
    cerrar.add(cerrarl,gbc2);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    gbc2.fill =GridBagConstraints.BOTH;
    gbc2.anchor = GridBagConstraints.CENTER;
    cerrar.add(cerrarl2,gbc2);
  }
}