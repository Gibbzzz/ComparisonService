import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromFile {

    String filename = "input.txt";

    public List<List<String>> separateInputFileOnTwoLists() throws IOException {
        List<Integer> countOfLines = fillCountOfLinesFromFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> list1;
            List<String> list2;
            list1 = reader.lines()
                    .skip(1)
                    .limit(countOfLines.get(0))
                    .collect(Collectors.toList());
            list2 = reader.lines()
                    .skip(1)
                    .limit(countOfLines.get(0))
                    .collect(Collectors.toList());
            List<List<String>> twoListsFromFile = new ArrayList<>();
            twoListsFromFile.add(list1);
            twoListsFromFile.add(list2);
            return twoListsFromFile;
        }
    }

    private List<Integer> fillCountOfLinesFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                    .filter(this::isNumeric)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }

    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
