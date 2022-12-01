import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {

    private static BufferedWriter writer;
    static {
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLineToFile(String s) throws IOException {
        writer.write(s);
        writer.flush();
    }

}
