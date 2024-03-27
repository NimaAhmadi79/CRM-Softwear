package nima;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Myfile {
    private static final ArrayList<String> companyArray = new ArrayList<>();
    private static final ArrayList<String> productArray = new ArrayList<>();
    private static final ArrayList<String> employeeArray = new ArrayList<>();
    private static final ArrayList<String> managerArray = new ArrayList<>();
    Scanner input=new Scanner(System.in);
    //------------------------------------------------------------------------------------------------------------------
    public void saveproduct() {
        String productpath = "C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(productpath)))) {
            for (String s : productArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void saveproduct(ArrayList<Product> product) {
        for (Product item : product) {
            productArray.add(item.getName() + " " + item.getCode() + " " + item.getCompany() + " " + item.getProduce_date() + " " + item.getExpire_date());
        }
        String productpath = "C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(productpath), true))) {
            int temp = productArray.size();
            buf.write(productArray.get(temp - 1));
            buf.newLine();
        } catch (IOException e) {
            e.getMessage();
        }


    }

    //------------------------------------------------------------------------------------------------------------------
    public void savecompany() {
        String companypath = "C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt";
        try (BufferedWriter buf = new BufferedWriter((new FileWriter(new File(companypath))))) {
            for (String s : companyArray) {
                buf.write(s);
                buf.newLine();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void savecompany(ArrayList<Company> company) {
        for (Company item : company) {
            String[] c = new String[item.getSetemployee().size()];
            String[] p = new String[item.getSetproduct().size()];
            for (int i = 0; i < item.getSetemployee().size(); i++) {
                c[i] = item.getSetemployee().get(i).getFirst_name() + " " + item.getSetemployee().get(i).getLast_name() + " ";
            }
            StringBuilder C= new StringBuilder();
            for (String value : c) {
                C.append(value);
            }
            String e1=C.toString();
            for (int i = 0; i < item.getSetproduct().size(); i++) {
                p[i] = item.getSetproduct().get(i).getName() + " ";
            }
            StringBuilder P = new StringBuilder();
            for (String s : p) {
                P.append(s);
            }
            String e2=P.toString();
            companyArray.add(item.getName() + " " + item.getManager().getFirst_name() + " " + item.getManager().getLast_name() + " " + item.getAdress() + " " + item.getPhone() + "// " + e1 + "// " + e2);
        }
        String companypath = "C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt";
        try (BufferedWriter buf = new BufferedWriter((new FileWriter(new File(companypath), true)))) {
            int temp1 = companyArray.size();
            buf.write(companyArray.get(temp1 - 1));
            buf.newLine();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void saveemployee() {
        String employeepath = "C:\\Users\\nima8\\OneDrive\\Desktop\\employee.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(employeepath)))) {
            for (String s : employeeArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void saveemployee(ArrayList<Employee> employees) {
        for (Employee item : employees) {
            employeeArray.add(item.getFirst_name() + " " + item.getLast_name() + " " + item.getJob());
        }
        String employeepath = "C:\\Users\\nima8\\OneDrive\\Desktop\\employee.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(employeepath), true))) {
            int temp2 = employeeArray.size();
            buf.write(employeeArray.get(temp2 - 1));
            buf.newLine();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void savemanager() {
        String managerpath = "C:\\Users\\nima8\\OneDrive\\Desktop\\manager.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(managerpath)))) {
            for (String s : managerArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void savemanager(ArrayList<Manager> managers) {
        for (Manager item : managers) {
            managerArray.add(item.getFirst_name() + " " + item.getLast_name());
        }
        String managerpath = "C:\\Users\\nima8\\OneDrive\\Desktop\\manager.txt";
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(managerpath), true))) {
            int temp3 = managerArray.size();
            buf.write(managerArray.get(temp3 - 1));
            buf.newLine();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void loadcompany() {
        try (BufferedReader buf=new BufferedReader(new FileReader(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt")))) {
            String text;
            while ((text=buf.readLine())!=null){
                companyArray.add(text);
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void loadproducts() {
        try (BufferedReader buf=new BufferedReader(new FileReader(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt")))) {
            String text;
            while ((text=buf.readLine())!=null){
                productArray.add(text);
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void loademployee() {
        try (BufferedReader buf=new BufferedReader(new FileReader(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\employee.txt")))) {
            String text;
            while ((text=buf.readLine())!=null){
                employeeArray.add(text);
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void loadmanager() {
        try (BufferedReader buf=new BufferedReader(new FileReader(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\manager.txt")))) {
            String text;
            while ((text=buf.readLine())!=null){
                managerArray.add(text);
            }
        }
        catch (IOException e){
            e.getMessage();
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    public void removecompany(String companyname) {
        System.out.println(companyname);
        boolean b;
        int a=-1;
        int temp = companyArray.size();
        if(temp==0){
            String error= "No companies have been added yet";
            Graphic graphic=new Graphic();
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = companyArray.get(i).contains(companyname);
            if (b) {
                a=i;
                String[] emp;
                emp = companyArray.get(i).split("// ");
                String[] employee = emp[1].split(" ");
                for (int j = 0; j < employee.length-1; j++) {
                    removeemployee1(employee[j],employee[j+1]);
                    j++;
                }
                String[] products = emp[2].split(" ");
                for (String product : products) {
                    removeproducts(product);
                }
                String[] manager=emp[0].split(" ");
                removemanager(manager[1]);
                break;
            }
            if(i==temp-1){
                String error="company not found";
                Graphic graphic=new Graphic();
                graphic.alert(error);
                System.exit(0);
            }

        }
        companyArray.remove(a);
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt")))) {
            for (String s : companyArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    public void removeproducts(String productname) {
        int a;
        boolean b;
        int temp = productArray.size();
        if (temp == 0) {
            String error = "No products have been added yet";
            Graphic graphic = new Graphic();
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = productArray.get(i).contains(productname);
            if (b) {
                a = i;
                productArray.remove(a);
                break;
            }
            if (i == temp - 1) {
                String error = "product no found";
                Graphic graphic = new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt")))) {
            for (String s : productArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public void removeproducts1(String productname,String companyname ){
        int a;
        boolean b;
        int temp = productArray.size();
        if (temp == 0) {
            String error = "No products have been added yet";
            Graphic graphic = new Graphic();
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = productArray.get(i).contains(productname);
            if (b) {
                a = i;
                productArray.remove(a);
                break;
            }
            if (i == temp - 1) {
                String error = "product no found";
                Graphic graphic = new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt")))) {
            for (String s : productArray) {
                buf.write(s);
                buf.newLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
        int temp1=companyArray.size();
        boolean b1;
        int q=0;
        for (int i = 0; i <temp1 ; i++) {
            b1=companyArray.get(i).contains(companyname);
            if (b1){
                String[]s=companyArray.get(i) .split("// ");
                String[]s1=s[2].split(" ");
                boolean b2;
                for (int j = 0; j <s1.length ; j++) {
                    b2=s1[j].contains(productname);
                    if (b2){
                        q=j;
                    }
                }
                StringBuilder p=new StringBuilder();
                for (int j = 0; j <s1.length ; j++) {
                    if(j!=q){
                        p.append(s1[j]);
                    }
                }
                String e=p.toString();
                companyArray.remove(i);
                companyArray.add(s[0]+"// "+s[1]+"// "+e);
                break;
            }
        }
        try(BufferedWriter buf=new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt")))) {
            for (String s : companyArray) {
                buf.write(s);
                buf.newLine();
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void removeemployee(String employeefirstname,String employeelastname) {
        int a=0;
        int b=1;
        int temp = employeeArray.size();
        if(temp==0){
            String error= "No employees have been added yet";
            Graphic graphic=new Graphic();
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            if(employeeArray.get(i).contains(employeefirstname)){
                 a=i;
            }
            if(employeeArray.get(i).contains(employeelastname)){
                 b=i;
            }
            if(a==b){
                employeeArray.remove(a);
                break;
            }
            if(i==temp-1){
                String error= "Not found this employee";
                Graphic graphic=new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\employee.txt")))) {
            for (String s : employeeArray) {
                buf.write(s);
                buf.newLine();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
    public void removeemployee1(String employeefirstname,String employeelastname){
        int a=0;
        int b=1;
        int temp = employeeArray.size();
        for (int i = 0; i < temp; i++) {
            if(employeeArray.get(i).contains(employeefirstname)){
                a=i;
            }
            if(employeeArray.get(i).contains(employeelastname)){
                b=i;
            }
            if(a==b){
                employeeArray.remove(a);
                break;
            }
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\employee.txt")))) {
            for (String s : employeeArray) {
                buf.write(s);
                buf.newLine();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void removemanager(String managername) {
        int a;
        boolean b;
        int temp =managerArray.size();
        if(temp==0){
            String error= "No managers have been added yet";
            Graphic graphic=new Graphic();
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = managerArray.get(i).contains(managername);
            if (b) {
                a = i;
                managerArray.remove(a);
                break;
            }
            if(i==temp-1){
                String error= "manager not found";
                Graphic graphic=new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\manager.txt")))) {
            for (String s : managerArray) {
                buf.write(s);
                buf.newLine();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void addprduct(String companyname1, String productname) {
        int a = 0;
        boolean b;
        int temp = companyArray.size();
        if(temp==0){
            Graphic graphic=new Graphic();
            String error="No companies have been added yet";
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = companyArray.get(i).contains(companyname1);
            if (b) {
                String q = companyArray.get(i);
                companyArray.remove(i);
                companyArray.add(q + productname);
                try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\company.txt")))) {
                    for (String s : companyArray) {
                        buf.write(s);
                        buf.newLine();
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
                break;
            }
            if (i == temp - 1) {
                String error="not found this company";
                Graphic graphic=new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static String[] details;
    public static int index;
    public void setDetails(String s,int a){
        details[a]=s;
    }

    public void editproduct(String productname) {
        boolean b;
        int temp = productArray.size();
        if (temp == 0) {
            Graphic graphic = new Graphic();
            String error = "No products have been added yet";
            graphic.alert(error);
            System.exit(0);
        }
        for (int i = 0; i < temp; i++) {
            b = productArray.get(i).contains(productname);
            if (b) {
                index = i;
                break;
            }
            if (i == temp - 1) {
                String error = "not found this product";
                Graphic graphic = new Graphic();
                graphic.alert(error);
                System.exit(0);
            }
        }
        details=productArray.get(index).split(" ");
        editProduct1();
    }
    public void editProduct1(){
        Graphic graphic=new Graphic();
        graphic.showProductDetails("the cod of product is:"+" "+details[1]);
        boolean val=graphic.getvalue();
        if(val){
            graphic.editProductShow("new code",1);
        }
        else {
            editProduct2();
        }
    }
    public void editProduct2(){
        Graphic graphic=new Graphic();
        graphic.showProductDetails("the produce date of product is:"+ " "+ details[3]);

        boolean val1=graphic.getvalue();
        if(val1){
            graphic.editProductShow("new Pdate",3);
        }
        else {
            editProduct3();
        }
    }
    public void editProduct3() {
        Graphic graphic = new Graphic();
        graphic.showProductDetails("the expire date of product is:" + " " + details[4]);

        boolean val2 = graphic.getvalue();
        if (val2) {
            graphic.editProductShow("new Edate", 4);
        }
        else {
            editProduct4();
        }
    }
    public void editProduct4(){
        productArray.remove(index);
        productArray.add(details[0]+" "+details[1]+" "+details[2]+" "+details[3]+" "+details[4]);
        try(BufferedWriter buf=new BufferedWriter(new FileWriter(new File("C:\\Users\\nima8\\OneDrive\\Desktop\\product.txt")))) {
            for (String s : productArray) {
                buf.write(s);
                buf.newLine();
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}



