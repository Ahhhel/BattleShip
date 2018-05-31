import java.io.Serializable;
public class gamefile implements Serializable{
  private static final long serialVersionUID = 6529685098267757690L;
  String name;
  int edad,score;
  boolean gana;
  gamefile(String _name, int _edad,boolean _gana,int _score){
    name = _name;
    edad = _edad;
    gana= _gana;
    score=_score;
  }
}
