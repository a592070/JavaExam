package JavaForReallyImpatientExam.Chapter2.Demo02;

public class Employee {
    private String name;
    private double salary;

    public void replaceWithZombie(Employee e){
        e = new Employee("",0);     //e 離開作用域後 沒有功用
    }

    public void raiseSalary(double byPercent){
        this.salary = salary*(1+byPercent/100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }
}
