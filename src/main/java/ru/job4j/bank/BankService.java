package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской службы
 *
 * @author dmarakov
 * @version 1.0
 */

public class BankService {

    /**
     * Данные хранятся в объекте типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод addUser добавляет пользователя в нашу систему хранения на основе HashMap
     *
     * @param user пользователь который будет добавлен
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по номеру его паспорта
     *
     * @param passport номер паспорта
     * @return возвращает true или false, в зависимости от того был найден пользователь по паспорту или нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;

    }

    /**
     * Добавляет аккаунт для пользователя по его паспорту
     *
     * @param passport - паспорт пользователя к которому будет добавлен аккаунт
     * @param account  - аккаунт который будет добавлен в список аккаунтов пользователя. Аккаунт будет добавлен,
     *                 только если такого аккаунта еще нету.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по его паспорту
     *
     * @param passport - паспорт пользователя к которому будет добавлен счет
     * @return возвращает объект типа User. Если пользователь не был найден, то возвращает null
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(it -> it.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Ищет счет по реквизитам этого счета. Пользователь будет найден по паспорту.
     *
     * @param passport  - паспорт пользователя к которому будет добавлен счет
     * @param requisite - номер реквизита счета пользователя
     * @return - возвращает счет пользователя для указанных реквизитов. Если счет не найден возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(it -> it.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет переслать деньги с одного сета на другой.
     *
     * @param srcPassport   - номер паспорта отправляющего лица
     * @param srcRequisite  - счет отправляющего лица
     * @param destPassport  - номер паспорта принимающего лица
     * @param destRequisite - счет принимающего лица
     * @param amount        - сумма, которая будет отправлена
     * @return - возвращает true или false, в зависимости от успеха операции.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет получить список счетов указанного пользователя
     *
     * @param user - пользователь для которого будет найден список счетов
     * @return - возвращает список счетов этого юзера
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}