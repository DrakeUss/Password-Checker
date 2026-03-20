package Dz4.Pasword;

public class PasswordChecker {
    private int minPassword;
    private int maxRepeats;

    public void setMinLength(int minPassword) {
        if (minPassword < 0) {
            throw new IllegalArgumentException("Исключение недопустимого аргумента");
        }
        this.minPassword = minPassword;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Исключение недопустимого повторений аргумента");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minPassword == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Один из чекеров не настроен");
        }
        if (password.length() < minPassword) {
            return false;
        }
        int count = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i - 1) == password.charAt(i)) {
                count++;
                if (count > maxRepeats) {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        return true;
    }
}