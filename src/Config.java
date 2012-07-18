import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: denys
 * Date: 18.07.12
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    String siteName;
    String dir_posts;
    String dir_template;

    public String getDir_posts() {
        return dir_posts;
    }

    public void setDir_posts(String dir_posts) {
        this.dir_posts = dir_posts;
    }

    public String getDir_template() {
        return dir_template;
    }

    public void setDir_template(String dir_template) {
        this.dir_template = dir_template;
    }

    @Override
    public String toString() {
        return "Config: {" +
                "siteName='" + siteName + '\'' +
                ", dir_posts='" + dir_posts + '\'' +
                ", dir_template='" + dir_template + '\'' +
                '}';
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Config()
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader("config" + System.getProperty("file.separator") + "config.json"));
            JSONObject jsonObject = (JSONObject) object;
            String siteName = (String) jsonObject.get("siteName");
            if (siteName == null)
            {
                siteName = "siteName not found in config.json";
            }
            this.siteName = siteName;

            String dir_posts = (String) jsonObject.get("dir_posts");
            if (dir_posts == null)
            {
                dir_posts = "posts";
            }
            this.dir_posts = dir_posts;

            String dir_template = (String) jsonObject.get("dir_template");
            if (dir_template == null)
            {
                dir_template = "template";
            }
            this.dir_template = dir_template;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        } catch (IOException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        }
    }

    public Config(String pathToConfig)
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader(pathToConfig + System.getProperty("file.separator") + "config.json"));
            JSONObject jsonObject = (JSONObject) object;
            String siteName = (String) jsonObject.get("siteName");
            if (siteName == null)
            {
                siteName = "siteName not found in config.json";
            }
            this.siteName = siteName;

            String dir_posts = (String) jsonObject.get("dir_posts");
            if (dir_posts == null)
            {
                dir_posts = "posts";
            }
            this.dir_posts = dir_posts;

            String dir_template = (String) jsonObject.get("dir_template");
            if (dir_template == null)
            {
                dir_template = "template";
            }
            this.dir_template = dir_template;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        } catch (IOException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            this.siteName = "config.json not found";
        }
    }
}
