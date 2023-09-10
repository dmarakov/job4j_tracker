package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    private AbstractCache<String, String> cache;
    String dirPath;

    public void init() {
        boolean exitFlag = true;
        Scanner scanner = new Scanner(System.in);


        while (exitFlag) {
            String menu = """
                    Menu:
                    1. Указжите кэшируемую директорию
                    0. Выход
                    """;
            System.out.println(menu);
            String answer = scanner.nextLine();
            if ("0".equals(answer)) {
                exitFlag = false;
            } else if ("1".equals(answer)) {
                System.out.println("Введите относительный путь");
                dirPath = scanner.nextLine();
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
                    } else if ("1".equals(answer)) {
                        loadCache();
                    } else if ("2".equals(answer)) {
                        getCache();
                    }
                }
            }
        }
    }

    private void loadCache() {
        if (cache == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя файла");
            String filePath = scanner.nextLine();
            cache = new DirFileCache(dirPath);
            cache.get(filePath);
            System.out.println("Кэш загружен.");
        } else {
            System.out.println("Кэш уже загружен.");
        }
    }

    private void getCache() {
        if (cache != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя файла");
            String filePath = scanner.nextLine();
            String cachedContent = cache.get(filePath); // Use filePath as the key
            if (cachedContent == null) {
                System.out.println("Кеша еще нет, сначала загрузите его");
            } else {
                System.out.println(cachedContent);
            }
        } else {
            System.out.println("Сначала загрузите кэш.");
        }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.init();
    }
}
