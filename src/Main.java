import StaffBook.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иванов Иван Иванович", 3, 150_000);
        employeeBook.addEmployee("Петров Петр Петрович", 1, 300_000);
        employeeBook.addEmployee("Нюхалов Семён Маркович", 5, 70_000);
        employeeBook.addEmployee("Иванцов Василий Натанович", 2, 123_000);
        employeeBook.addEmployee("Шилова Маргарита Святославовна", 4, 96_000);
        employeeBook.addEmployee("Сулимова Валентина Павловна", 2, 213_000);
        employeeBook.addEmployee("Валиев Павел Брониславович", 3, 400_000);
        employeeBook.addEmployee("Волынкина Диана Романовна", 5, 345_000);
        employeeBook.addEmployee("Акинфеев Леонид Венедиктович", 1, 110_000);
        employeeBook.addEmployee("Абрашина Алла Филипповна", 3, 80_000);
        employeeBook.addEmployee("Одиннадцатый сотрудник", 3, 200_000);

        employeeBook.printAllEmployees();

        System.out.println();
        employeeBook.removeEmployee(6);
        employeeBook.printAllEmployees();

        System.out.println();
        employeeBook.addEmployee("Свиридов Антон Павлович", 2, 112_000);
        employeeBook.printAllEmployees();

        System.out.println();
        System.out.println("Размер ФОТ в месяц: " + employeeBook.countTotalSalaryCost());
        System.out.println("Сотрудник с минимальной зарплатой:\n" + employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой:\n" + employeeBook.findEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата: " + employeeBook.countAverageSalary());

        System.out.println();
        employeeBook.printAllEmployeesFullNames();

        System.out.println();
        employeeBook.indexAllSalary(50);
        employeeBook.printAllEmployees();

        System.out.println();
        employeeBook.printAllDepartmentEmployees(2);

        System.out.println();
        employeeBook.printEmployeesWithLowerSalary(200_000);

        System.out.println();
        employeeBook.printEmployeesWithHigherSalary(300_000);

        System.out.println();
        employeeBook.changeEmployee("Иванов Иван Иванович", 1, 280_000);

        System.out.println();
        employeeBook.printByDepartments();
    }
}