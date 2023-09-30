package _09_StreamsFilesDirectories_Lab;

import java.io.*;

public class _05_WriteEveryThirdLine_IMPORTANT {
    public static void main(String[] args) throws IOException {

        String path = "src/_09_resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        // четем информацията, която ни трябва, когато ни трябва
        // потока пази вътрешно информацията в отделни парчета (chunks)

        FileOutputStream outputStream = new FileOutputStream("src/_09_resources\\every-third-line.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream)); //изисква FileOutputStream за да запази резултата

        String line = reader.readLine();

        int lineCounter = 1;

        while (line != null){
            if(lineCounter % 3 == 0){
                writer.write(line);  // чети всяки трети ред
                writer.newLine();    // след това премини на нов ред
            }

            line = reader.readLine();
            lineCounter++;
        }

       // writer.flush(); // какеото има, го пускай при
        writer.close(); // writer.close(); включва и flushBuffer(); т.е. може и без writer.flush();
    }
}
