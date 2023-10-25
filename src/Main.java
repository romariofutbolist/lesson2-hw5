import exceptions.WrongLoginExcepton;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String login = "gggгкне";
        String password = "hhhh";
        String confirmPassword = "1131242";

        try {
            checkUser(login, password, confirmPassword);
        } catch (WrongLoginExcepton e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка выполнена верно");
        }
    }

    public static void checkUser(String login, String password, String confirmPassword) throws WrongLoginExcepton, WrongPasswordException {
        checkLogin(login);
        checkPassword(password, confirmPassword);
    }

    private static void checkLogin(String login) throws WrongLoginExcepton {
        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginExcepton("Логин не подходит под требуемое значение");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль не подходит под требуемое значение");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}