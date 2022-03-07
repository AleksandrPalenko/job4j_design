package ru.job4j.ood.dip;

public class Service { }
/**
 * Принцип инверсии зависимостей.
 * Принцип DIP гласит:
 * Модули верхнего уровня не должны зависеть от модулей нижнего уровня.
 * И те и другие должны зависеть от абстракций.
 * Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.
 * Задание:
 * Придумайте 3 примера, когда происходит нарушение принципа DIP.
 *
 * Пример 1:
 * Нарушение DIP - в поле класса Violation происходит прямая зависимость от конкретной реализации.
 * 1.У сервиса есть единственное поле - листч, для хранения данных.
 * С точки зрения DIP, это нарушение, потому что мы зависим от реализации, а не абстракции.
 * Решение - выделение абстракции для хранилища(Новый интерфейс) Set<User> getUsers();
 * 2. завсисимость он консольного вывода, необходимо использовать поле с логгирование
 * private static final Logger LOGGER = Logger.getLogger("user logger");
 *3.Нарушение DIP - аргумент конструктора имеет конкретную реализацию.
 *
 *public class Service {
 *     String name;
 *     String number;
 *
 *  get,set

 * 1. private HashSet<Integer, Integer> hashSet = new HashSet<>();
 *  public void work() {

 *  }
 * 2. System.out.println("Get error with "  + name + " " + number);

 * 3. Public Service(HashMap<Integer, Integer> map) {
 * this.hashSet = hashSet; }
**/