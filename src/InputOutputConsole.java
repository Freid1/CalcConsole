import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputConsole {
   private static BufferedReader reader;

    public InputOutputConsole() {
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputFromConsole(){
       String line="";
        try {
            line=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void outputToConsole(String message){
        System.out.println(message);
    }
    public void outputToConsole(int message){
        System.out.println(message);
    }

}
