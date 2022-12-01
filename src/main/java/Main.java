import java.io.IOException;
/*
Программа читает из файла input.txt входные данные:
n число, далее n строк (первое множество)
m число, далее m строк (второе множество),
затем должна сопоставить максимально похожие строки из первого множества со строками из второго множества
и вывести их в output.txt
Пример:
4
гвоздь
шуруп
краска синяя
ведро для воды
3
краска
корыто для воды
шуруп 3х1.5
 */

public class Main {

    public static void main(String[] args) throws IOException {
        ComparisonService comparisonService = new ComparisonService();
        comparisonService.comparingLinesFromFile();
    }
}
