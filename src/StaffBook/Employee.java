package StaffBook;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private static int idCounter = 0;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.setDepartment(department);
        this.setSalary(salary);
        this.id = idCounter;
        idCounter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new java.lang.RuntimeException("Введен несуществующий номер отдела.");
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new RuntimeException("Значение зарплаты не может быть отрицательным!");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", ФИО: " + fullName +
                ", отдел: " + department +
                ", зарплата: " + salary;
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
        return Objects.hash(id);
    }

    public String toStringWithoutDep() {
        return "id: " + getId() +
                ", ФИО: " + getFullName() +
                ", Зарплата: " + getSalary();
    }
}
