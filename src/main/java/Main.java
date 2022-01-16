import Entity.AddressEmployee;
import Entity.Employee;
import Entity.EmployeeProject;
import Entity.Project;
import bisnesLog.Util;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectSrvice;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {

    static private long countId = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();
        AddressEmployee addressEmployee = new AddressEmployee();
        Project project = new Project();
        EmployeeProject employeeProject = new EmployeeProject();

        //////////////////////////////EMPLOYEE//////////////////////////

        employee.setId(countId);


        System.out.print("введите имя сотрудника :  ");
        employee.setFirstName(new Scanner(System.in).nextLine());
        System.out.println();

        System.out.print("введите фамилию сотрудника :  ");
        employee.setLastNama(new Scanner(System.in).nextLine());
        System.out.println();

        System.out.print("введите год рождения :  ");
        int year = new Scanner(System.in).nextInt();
        System.out.println();
        System.out.print("введите месяц рождения :  ");
        int month = new Scanner(System.in).nextInt();
        System.out.println();
        System.out.print("введите день рождения :  ");
        int day = new Scanner(System.in).nextInt();
        System.out.println();
        employee.setBirthday(Date.valueOf(LocalDate.of(year,month,day)));


        //////////////////////////////ADDRESS//////////////////////////

        addressEmployee.setId(countId);

        System.out.print("введите город проживания :  ");
        addressEmployee.setCity(new Scanner(System.in).next());
        System.out.println();

        System.out.print("введите  улицу :  ");
        addressEmployee.setStreet(new Scanner(System.in).nextLine());
        System.out.println();

        System.out.print("введите  номер дома :  ");
        addressEmployee.setNumberOfHouse(new Scanner(System.in).nextLine());
        System.out.println();

        System.out.print("введите номер квартиры :  ");
        addressEmployee.setNumberOfApartment(new Scanner(System.in).nextInt());
        System.out.println();

        //////////////////////////////PROJECT//////////////////////////

        project.setId(countId);

        System.out.print("введите заголовок проекта :  ");
        project.setTitle(new Scanner(System.in).nextLine());
        System.out.println();

        System.out.print("введите оценку за проект :  ");
        project.setGrade(new Scanner(System.in).nextInt());
        System.out.println();

        //////////////////////////////EMPLOYEE__PROJECT//////////////////////////

        employeeProject.setId(countId);
        employeeProject.setIdProject(project.getId());
        employeeProject.setIdEmployee(employee.getId());

        employee.setAddressId(addressEmployee.getId());

        //////////////////////////////SERVICE//////////////////////////

        EmployeeService employeeService = new EmployeeService();
        AddressService addressService = new AddressService();
        ProjectSrvice projectSrvice = new ProjectSrvice();
        EmplProjService emplProjService = new EmplProjService();

        //// Главное порядок вызовов методов у SERVICE
        addressService.add(addressEmployee);
        projectSrvice.addProject(project);
        employeeService.addEmployee(employee);
        emplProjService.addEmployeeProject(employeeProject);

    }
}
