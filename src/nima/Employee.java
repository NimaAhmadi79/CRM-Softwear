package nima;

import java.util.ArrayList;

public class Employee implements Person {
    private String first_name;
    private String last_name;
    private String job;
    private static ArrayList<Employee>employees=new ArrayList<>();
    public Employee(String first_name,String last_name,String job){
        this.first_name=first_name;
        this.last_name=last_name;
        this.job=job;
        employees.add(this);

    }
    public Employee(String first_name,String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
    }
    @Override
    public void save() {
        Myfile myfile=new Myfile();
        myfile.saveemployee(employees);
        employees.clear();
    }

    @Override
    public  void remove() {
        Myfile myfile=new Myfile();
        myfile.removeemployee(first_name,last_name);

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getJob() {
        return job;
    }
}
