package Dz4.Pasword;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите мин. длину пароля: ");
            passwordChecker.setMinLength(Integer.parseInt(sc.nextLine()));

            System.out.println("Введите макс. допустимое количество повторений символа подряд: ");
            passwordChecker.setMaxRepeats(Integer.parseInt(sc.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }
        while (true) {
            System.out.println("Введите пароль или end:");
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            boolean result = passwordChecker.verify(input);
            System.out.println(result ? "Подходит!" : "Не подходит!");
        }
        System.out.println("Программа завершена.");
    }
}
