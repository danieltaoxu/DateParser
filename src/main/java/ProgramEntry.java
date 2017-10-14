import com.business.DateExtractor;
import com.engine.io.InOutputHelper;
import com.engine.tools.StringUtils;

public class ProgramEntry {
  public static void main(String[] args)
  {
    String property = InOutputHelper.getProperty("com.parser.filepath");
    if (!StringUtils.Empty.equals(property))
    {
      DateExtractor.extractAllDateFromFile(property);
    }
  }
}
