import java.text.DecimalFormat;
public class Main {

    // Хранилище для сотрудников
    private static Employee[] employees = new Employee[10];

    // Разделитель (для удобства чтения)
    public static void printSeparator() {
        System.out.println("\n---------------------------\n");
    }

    // Метод для вывода всех сотрудников
    public static void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    // Метод для расчета суммы выданных зарплат
    public static double getTotalSalary() {
        double total = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                total += emp.getSalary();
            }
        }
        return total;
    }

    // Метод для нахождения сотрудника с минимальной зарплатой
    public static Employee getEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    // Метод для нахождения сотрудника с максимальной зарплатой
    public static Employee getEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    // Метод для расчета среднего значения зарплат
    public static double getAverageSalary() {
        double totalSalary = getTotalSalary();
        int count = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                count++;
            }
        }
        return count > 0 ? totalSalary / count : 0;
    }

    // Метод для распечатки ФИО всех сотрудников
    public static void printEmployeeFullNames() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.getFullName());
            }
        }
    }

    // Индексирование зарплаты
    public static void indexSalary(double percent) {
        for (Employee emp : employees) {
            if (emp != null) {
                double currentSalary = emp.getSalary();
                double indexedSalary = currentSalary * (1 + percent / 100);
                emp.setSalary(indexedSalary);
            }
        }
    }

    // Метод для ограничения знаков после запятой
    private static String formatSalary(double salary) {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(salary);
    }

    public static void main(String[] args) {
        // Сотрудники
        employees[0] = new Employee("Собянин Семен Аркадьевич", 1, 160500);
        employees[1] = new Employee("Петров Артур Алибекович", 1, 155000);
        employees[2] = new Employee("Абрикосов Эдуард Иванович", 1, 153500);
        employees[3] = new Employee("Казанцев Братислав Иванович", 3, 115000);
        employees[4] = new Employee("Мельников Роман Михайлович", 4, 191000);
        employees[5] = new Employee("Иванов Иван Иванович", 5, 261100);
        employees[6] = new Employee("Злыгостев Петр Добронравович", 5, 265500);

        System.out.println("КНИГА УЧЕТА СОТРУДНИКОВ\n");
        printAllEmployees();
        printSeparator();
        System.out.println("Сумма выданных зарплат: " + getTotalSalary());
        printSeparator();
        System.out.println("Сотрудник с минимальной запрлатой: " + getEmployeeWithMinSalary());
        printSeparator();
        System.out.println("Отрудник с максимальной: " + getEmployeeWithMaxSalary());
        printSeparator();
        System.out.println("Средняя зарплата: " + formatSalary(getAverageSalary()));
        printSeparator();
        indexSalary(6); // Процент индекирования зарплаты
        System.out.println("Зарплаты индексированы: \n");
        printAllEmployees();
        printSeparator();
        printEmployeeFullNames();
    }
}