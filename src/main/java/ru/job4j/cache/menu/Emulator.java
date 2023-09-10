package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    public void init() {
        boolean exitFlag = true;
        Scanner scanner = new Scanner(System.in);
        String dirPath;
        String fileName;
        AbstractCache<String, String> cache;

        while (exitFlag) {
            String menu = """
                    Menu:
                    1. Указжите кэшируемую директорию
                    2. Загрузить содержимое файла в кэш
                    3. Получить содержимое файла из кэша
                    0. Выход
                    """;
            System.out.println(menu);
            String answer = scanner.nextLine();
            if ("0".equals(answer)) {
                exitFlag = false;
            } else if ("1".equals(answer)) {
                System.out.println("Введите относительный путь");
                dirPath = scanner.nextLine();
                cache = new DirFileCache(dirPath);
                System.out.println("Введите имя файла");
                fileName = scanner.nextLine();
                boolean exitInnerFlag = true;
                while (exitInnerFlag) {
                    String innerMenu = """
                            Menu:
                            1. Загрузить содержимое файла в кэш
                            2. Получить содержимое файла из кэша
                            0. Вернуться назад
                            """;
                    System.out.println(innerMenu);
                    answer = scanner.nextLine();
                    if ("0".equals(answer)) {
                        exitInnerFlag = false;
                        continue;
                    }
                    if ("1".equals(answer)) {
                        cache.get(fileName);
                    } else if ("2".equals(answer)) {
                        System.out.println(cache.get(fileName));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.init();
    }


}
