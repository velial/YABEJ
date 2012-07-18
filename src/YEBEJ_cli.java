import java.io.File;

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

    public static void main(String[] argv)
    {
        cli_printHeader();

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
