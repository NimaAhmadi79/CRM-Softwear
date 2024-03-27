package nima;

import java.util.ArrayList;

public class Manager implements Person {
    private String first_name;
    private String last_name;
    private static ArrayList<Manager>managers=new ArrayList<>();
    public Manager(String name,String lastname){
        this.first_name=name;
        this.last_name=lastname;
        managers.add(this);
    }
    public Manager(String first_name){
        this.first_name=first_name;
    }
    @Override
    public void save() {
        Myfile myfile=new Myfile();
        myfile.savemanager(managers);
        managers.clear();
    }

    @Override
    public void remove() {
        Myfile myfile=new Myfile();
        myfile.removemanager(first_name);
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
