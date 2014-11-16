import java.lang.StringBuilder;

public class NamingConvention {
  
  public String toCamelCase(String variableName) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < variableName.length(); i++) {
      if (variableName.charAt(i) == '_' && i+1 < variableName.length()) {
        sb.append(Character.toUpperCase(variableName.charAt(i+1)));
        i++;
      } else {
        sb.append(variableName.charAt(i));  
      }
      
    }
    return sb.toString();
  }

}

