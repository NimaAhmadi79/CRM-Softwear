package nima;

import java.util.ArrayList;

public class Company {
    private String name;
    private String adress;
    private Manager manager;
    private String phone;
    private static ArrayList<Employee> setemployee=new ArrayList<>();
    private static ArrayList<Product> setproduct=new ArrayList<>();
    private static ArrayList<Company> company =new ArrayList<>();
    public Company(String name, String adress, String phone){
        this.name=name;
        this.adress=adress;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public Manager getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public ArrayList<Product> getSetproduct() {
        return setproduct;
    }

    public ArrayList<Employee> getSetemployee() {
        return setemployee;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setProduct(Product product) {
        setproduct.add(product);

    }
    public void setEmployee(Employee employee) {
        setemployee.add(employee);

    }
    public void saveArray(){
        company.add(this);
    }
    public void save(){
        saveArray();
        Myfile myfile=new Myfile();
        myfile.savecompany(company);
        setemployee.clear();
        setproduct.clear();
        company.clear();
    }
    public static void remove(String companyname){
        Myfile myfile=new Myfile();
        myfile.removecompany(companyname);

    }


}
