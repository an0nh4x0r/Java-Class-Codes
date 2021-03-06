import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();
//
//
// new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        new Thread(() -> {
            System.out.println("Printing from the runnable");
            System.out.println("This is line 2");
            System.out.format("This is line %d\n", 3);

            Employee john = new Employee("John Doe", 30);
            Employee tim = new Employee("Tim Buchalka", 21);
            Employee jack = new Employee("Jack Hill", 40);
            Employee snow = new Employee("Snow White", 22);

            List<Employee> employees = new ArrayList<>();
            employees.add(john);
            employees.add(tim);
            employees.add(jack);
            employees.add(snow);

//            Collections.sort(employees, new Comparator<Employee>() {
//                @Override
//                public int compare(Employee employee1, Employee employee2) {
//                    return employee1.getName().compareTo(employee2.getName());
//                }
//            });

//            Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                    employee1.getName().compareTo(employee2.getName()));

            Collections.sort(employees, (employee1, employee2) ->
                    employee1.getName().compareTo(employee2.getName()));

            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }

//            String sillyString = doStringStuff(new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            }, employees.get(0).getName(), employees.get(1).getName());
//
//            System.out.println(sillyString);

//            String sillyString = doStringStuff(((s1, s2) ->
//                    s1.toUpperCase() + s2.toUpperCase()), employees.get(0).getName(), employees.get(1).getName());

            UpperConcat uc = ((s1, s2) -> {
                String result = s1.toUpperCase() + s2.toUpperCase();
                return result;
            });

            String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());

            System.out.println(sillyString);

            AnotherClass anotherClass = new AnotherClass();
            System.out.println(anotherClass.doSomething());
        }).start();

    }

    public static final String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Printing from the runnable");
//    }
//}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }
}