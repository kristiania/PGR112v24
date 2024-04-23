package lectures._23.example2;

import java.util.HashMap;

public class Business
{
    //# Fields
    private String name;
    private HashMap<Integer, Employee> employees = new HashMap<>();
    private int employeeNumbers = 1;


    //# Constructors
    public Business(String name) {
        this.name = name;
    }


    //# Getter-methods
    public HashMap<Integer, Employee> getEmployees() {
        return this.employees;
    }


    //# Methods
    public void addEmployee() {
        var employee = this.new Employee(this.employeeNumbers ++);

        this.employees.put(employee.getEmployeeNumber(), employee);
    }


    //# Inner-classes
    class Employee
    {
        //# Fields
        private int number;


        //# Constructors
        public Employee(int number) {
            this.number = number;
        }


        //# Getter-methods
        public int getEmployeeNumber() {
            return this.number;
        }


        //# Methods
        void printNameOfBusiness() {
            System.out.println(Business.this.name);
        }
    }
}
