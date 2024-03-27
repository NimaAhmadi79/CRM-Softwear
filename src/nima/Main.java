package nima;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static void  addCompany(String cname, String cadress, String cphone, String cmfirst, String cmlast, ArrayList<String>employees,ArrayList<String>products){
        Company company =new Company(cname,cadress,cphone);
        Manager manager=new Manager(cmfirst,cmlast);
        company.setManager(manager);
        manager.save();
        for (int i = 0; i <employees.size() ; i++) {
            String []s=employees.get(i).split(" ");
            Employee employee=new Employee(s[0],s[1],s[2]);
            employee.save();
            company.setEmployee(employee);
        }
        for (int i = 0; i <products.size() ; i++) {
            String []s=products.get(i).split(" ");
            Product product=new Product(s[0],cname,s[1],s[2],Integer.parseInt(s[3]));
            product.save();
            company.setProduct(product);
        }
        company.save();
    }
    static void addProduct(String pname,String pcname,String ppdate,String pedate,int pcode) {
        Product product1 = new Product(pname, pcname, ppdate, pedate, pcode);
        product1.setCompany(pcname, pname);
        product1.save();
    }

    static  void addEmployee(String efirst,String elast,String ejob){
        Person person1=new Employee(efirst,elast,ejob);
        person1.save();
    }
    static void addManager(String mfirst,String mlast){
        Person person2=new Manager(mfirst,mlast);
        person2.save();
    }
    static void removeCompany(String companyname ){
        Company.remove(companyname);
    }
    static void removeProduct(String productname ,String companyname){
        Product.remove(productname,companyname);
    }
    static void removeEmployee(String employeefirstname,String employeelastname){
        Person person1=new Employee(employeefirstname,employeelastname);
        person1.remove();
    }
    static void removeManager(String managername){
        Person person2=new Manager(managername);
        person2.remove();
    }
    static void editProduct(String name){
        Product.edit(name);
    }

    public static void main(String[] args) {
        Myfile myfile=new Myfile();
        myfile.loadcompany();
        myfile.loademployee();
        myfile.loadmanager();
        myfile.loadproducts();
        myfile.savemanager();
        myfile.saveemployee();
        myfile.savecompany();
        myfile.saveproduct();
        Graphic.graphics(args);

    }
}

