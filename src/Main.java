import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка: ");
        //размер списка size
        int listSize = addValue();
        System.out.print("Введите верхнюю границу для значений: ");
        // верхнюю границу значений элементов в списке
        int listTop = addValue();

        logger.log("Создаём и наполняем список");
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            source.add(random.nextInt(listTop));
        }

        System.out.println("Вот случайный список: " + source.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ", " ", " ")));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int filterThreshold = addValue();

        Filter filter = new Filter(filterThreshold);
        logger.log("Запускаем фильтрацию");

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filter.filterOut(source).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ", " ", " ")));
        logger.log("Завершаем программу");
    }

    //Добавление целого не отрицетельного числа
    private static int addValue() {
        boolean isContinue = true;
        int result = -1;
        Scanner scanner = new Scanner(System.in);
        while (isContinue) {
            String answer = scanner.nextLine();
            try {
                result = Integer.parseInt(answer);
                if (result < 0) {
                    throw new NumberFormatException();
                }
                isContinue = false;
            } catch (NumberFormatException e) {
                System.out.printf("Неверный формат числа! Вы ввели: %s!\n", answer);
            }
        }
        return result;
    }

}
