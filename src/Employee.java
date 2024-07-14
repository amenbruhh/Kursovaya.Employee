public class Employee {

    private static int idCounter = 1; // Статическая переменная-счетчик
    private int id;
    private String fullName;
    private int department;
    private double salary;

    // Конструктор
    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++; // Присвоение счетчика к id
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры и снттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Сотрудник: id = " + id + ", ФИО = " + fullName + ", отдел = " + department + ", ЗП = " + salary;
    }
}

