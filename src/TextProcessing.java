import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessing {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/my_text_file.txt"));
			Pattern domainPattern = Pattern.compile("([\\w+]+\\:\\/\\/)?([\\w\\d-]+\\.)*[\\w-]+[\\.\\:]\\w+([\\/\\?\\=\\&\\#\\.]?[\\w-]+)*\\/?");
			String file = "";
			String line;
			List<String> allMatches = new ArrayList<>();
			
			while((line = br.readLine())!=null) {
				file+=line+"\n";
            }
			
			Matcher matchDomain = domainPattern.matcher(file);
			
			while (matchDomain.find()) {
				allMatches.add(matchDomain.group());
			}
			
			int count = allMatches.size();
			
			if(count>0) {
				String firstOcc = allMatches.get(0);
				br.close();
				System.out.println("Occurrence Found: "+count+". First Occurrence: " + firstOcc);
				return;
			}
			
            System.out.println("Occurrence Found: "+count);
            br.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+"\n"+e.getStackTrace());
		}
	}

}
