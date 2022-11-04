package StaffBook;

public class EmployeeBook {

    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, int salary) {
        boolean addedSucessfully = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(fullName, department, salary);
                employees[i] = newEmployee;
                addedSucessfully = true;
                break;
            }
        }
        if (addedSucessfully) {
            System.out.println("Сотрудник " + fullName + " успешно добавлен.");
        } else {
            System.out.println("В бухгалтерской книге нет места. Добавить сотрудника невозможно.");
        }
    }

    public void removeEmployee(int id) {
        boolean removedSuccessfully = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                removedSuccessfully = true;
                break;
            }
        }
        if (removedSuccessfully) {
            System.out.println("Сотрудник с id " + id + " удален успешно.");
        } else {
            System.out.println("Сотрудник с данным id не найден.");
        }
    }

    public void changeEmployee(String fullName, int department, int salary) {
        boolean changedSuccessfully = false;
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
                employee.setSalary(salary);
                changedSuccessfully = true;
                break;
            }
        }
        if (changedSuccessfully) {
            System.out.println("Данные о сотруднике " + fullName + " успешно перезаписаны.");
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printByCondition(int i, boolean condition) {
        if (condition) {
            Employee employee = employees[i];
            System.out.println(employee.toStringWithoutDep());
        }
    }

    public int countTotalSalaryCost() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        int min = employees[0].getSalary();
        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < min)) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee findEmployeeWithMaxSalary() {
        int max = employees[0].getSalary();
        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() > max)) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public int countAverageSalary() {
        return countTotalSalaryCost() / employees.length;
    }

    public void printAllEmployeesFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexAllSalary(int percent) {
        int newSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                newSalary = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary(newSalary);
            }
        }
    }

    public void printAllDepartmentEmployees(int department) {
        if (department < 1 || department > 5) {
            throw new RuntimeException("Введен несуществующий номер отдела.");
        }
        System.out.println("Список сотрудников отдела " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                printByCondition(i, employees[i].getDepartment() == department);
            }
        }
    }

    public void printEmployeesWithLowerSalary(int number) {
        System.out.println("Сотрудники с зарплатой ниже " + number + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                printByCondition(i, employees[i].getSalary() < number);
            }
        }
    }

    public void printEmployeesWithHigherSalary(int number) {
        System.out.println("Сотрудники с зарплатой выше " + number + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                printByCondition(i, employees[i].getSalary() >= number);
            }
        }
    }

    public void printByDepartments() {
        for (int i = 1; i < 6; i++) {
            printAllDepartmentEmployees(i);
        }
    }

}
