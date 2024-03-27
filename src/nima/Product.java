package nima;

import java.util.ArrayList;

public class Product {

    private String name;
    private String company;
    private int code;
    private String expire_date;
    private String produce_date;
    private static ArrayList<Product>products=new ArrayList<>();

    public Product(String name,String company,String produce_date,String expire_date, int code) {
        this.name=name;
        this.code=code;
        this.company=company;
        this.produce_date=produce_date;
        this.expire_date=expire_date;
        products.add(this);
    }
    public void setCompany(String cname,String pname){
        Myfile myfile=new Myfile();
        myfile.addprduct(cname,pname);
    }
    public String getExpire_date(){return expire_date;}
    public String getProduce_date(){ return produce_date;}
    public String getName(){return name;}
    public String getCompany(){return company;}
    public int getCode(){return code;}

    public void save(){
        Myfile myfile=new Myfile();
        myfile.saveproduct(products);
        products.clear();
    }
    public static void remove(String productname,String companyname){
        Myfile myfile=new Myfile();
        myfile.removeproducts1(productname,companyname);
    }
    public static void edit(String productname){
        Myfile myfile=new Myfile();
        myfile.editproduct(productname);

    }


}
