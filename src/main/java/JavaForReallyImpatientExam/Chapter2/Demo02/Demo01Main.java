package JavaForReallyImpatientExam.Chapter2.Demo02;

public class Demo01Main {
    public static void main(String[] args) {
        Employee fred = new Employee("fred",500);
        fred.raiseSalary(10);
        System.out.println(fred.getSalary());

        Employee john = new Employee("john",100);
        fred.replaceWithZombie(john);
        System.out.println(john.getName() + john.getSalary());

    }

}
