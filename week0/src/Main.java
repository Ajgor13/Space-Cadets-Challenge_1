import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    private static String id;
    private static String webAddress;
    private static URL url;
    private static URLConnection connection;


    public static void main(String[] args){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your email id: ");
            id = input.readLine();
            url = new URL("https://www.ecs.soton.ac.uk/people/" + id);
            connection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while(true){
                String line = br.readLine();
                if(line != null && line.contains("<title>")){
                    line = line.substring(11,line.indexOf("|"));
                    if(line.equals("People ")){
                        System.out.println("Name not found");
                    }
                    else{
                        System.out.println("Name: " + line);
                    }
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}