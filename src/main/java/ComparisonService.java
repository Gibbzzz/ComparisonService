import org.apache.commons.text.similarity.JaroWinklerSimilarity;

import java.io.IOException;
import java.util.List;

public class ComparisonService {

    ReaderFromFile readerFromFile = new ReaderFromFile();
    WriterToFile writerToFile = new WriterToFile();

    public void comparingLinesFromFile() throws IOException {

        List<List<String>> twoListsFromInputFile = readerFromFile.separateInputFileOnTwoLists();
        List<String> firstList = twoListsFromInputFile.get(0);
        List<String> secondList = twoListsFromInputFile.get(1);

        firstList.forEach(e -> {
            secondList.forEach(s -> {
                if (findSimilarity(e, s) > 0.65) {
                    try {
                        String line = e + " : " + s + "\n";
                        writerToFile.writeLineToFile(line);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });
        });
    }

    private static double findSimilarity(String x, String y) {
        if (x == null && y == null) {
            return 1.0;
        }
        if (x == null || y == null) {
            return 0.0;
        }
        return new JaroWinklerSimilarity().apply(x, y);
    }
}
