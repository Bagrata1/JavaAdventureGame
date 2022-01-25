package gameModel;

/**
 * enum Paths
 * 
 * creates direction objects and their corresponding strings to be used
 * for navigating through the map.
 * @author Irakli Bagratishvili
 *
 */
public enum Paths{
  EAST ("east"), 
  WEST ("west"), 
  NORTH ("north"), 
  SOUTH ("south")
  ; 
  private final String directionName;
	  
  Paths(String code) {
      this.directionName = code;
  }
	  
  public String getDirectionCode() {
      return this.directionName;
  }
}
