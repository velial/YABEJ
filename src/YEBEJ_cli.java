import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: denys
 * Date: 18.07.12
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class YEBEJ_cli {
    static void cli_printHeader()
    {
        System.out.println("====================================");
        System.out.println("Yet Another Blog Engine J");
        System.out.println("Command Line Interface");
        System.out.println("Type \"yebej_cli --help\" for more help...");
    }

    static void findAllFilesInDirectory(String path)
    {
        String list[] = new File(path).list();
        for (String file : list)
        {
            System.out.println(file);
        }
    }

    static void readConfig()
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader("config" + System.getProperty("file.separator") + "config.json"));
            JSONObject jsonObject = (JSONObject) object;
            String siteName = (String) jsonObject.get("siteName");
            System.out.println("Site name: " + siteName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv)
    {
        cli_printHeader();
        readConfig();
        for (String arg : argv)
        {
            if ("--help".equals(arg))
            {
                System.out.println("More help ......");
            }
        }

        findAllFilesInDirectory("posts");
    }
}
