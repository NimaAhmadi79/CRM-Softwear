package nima;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Optional;

public class Graphic extends Application {
    private static ArrayList<String> products=new ArrayList<>();
    private static ArrayList<String> employees=new ArrayList<>();
    private static boolean value;
    public boolean getvalue(){
        return value;
    }
    public void alert(String error){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText(error);
        alert.showAndWait();

    }
    public void showProductDetails(String info){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText(info+" "+"Do you want to change it?");
        ButtonType yes=new ButtonType("Yes");
        ButtonType no=new ButtonType("NO");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==yes){
            value=true;

        }
        if(result.get()==no){
            value=false;

        }

    }
    public static void addCompany(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,500,665, Color.LIGHTSTEELBLUE);
        Stage stage=new Stage();
        stage.setScene(scene1);
        stage.setTitle("Add Compnay");
        stage.show();
        //------------------------------------
        Text cmpNameTxt=new Text("company name");
        cmpNameTxt.setLayoutX(15);
        cmpNameTxt.setLayoutY(70);
        cmpNameTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC,15));
        root1.getChildren().add(cmpNameTxt);
        //-----------------------------------
        TextField companyName=new TextField();
        companyName.setLayoutX(150);
        companyName.setLayoutY(53);
        companyName.setPrefWidth(300);
        root1.getChildren().add(companyName);
        //------------------------------------
        Text cmpAdressTxt=new Text(" company adress");
        cmpAdressTxt.setLayoutX(10);
        cmpAdressTxt.setLayoutY(131);
        cmpAdressTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC,15));
        root1.getChildren().add(cmpAdressTxt);
        //-------------------------------------
        TextField companyAdress=new TextField();
        companyAdress.setLayoutX(150);
        companyAdress.setLayoutY(113);
        companyAdress.setPrefWidth(300);
        root1.getChildren().add(companyAdress);
        //-------------------------------------
        Text cmpPhoneTxt=new Text("company phone");
        cmpPhoneTxt.setLayoutX(14);
        cmpPhoneTxt.setLayoutY(193);
        cmpPhoneTxt.setFont(Font.font("", FontWeight.BOLD, FontPosture.ITALIC,15));
        root1.getChildren().add(cmpPhoneTxt);
        //--------------------------------------
        TextField companyPhone=new TextField();
        companyPhone.setLayoutX(150);
        companyPhone.setLayoutY(175);
        companyPhone.setPrefWidth(300);
        root1.getChildren().add(companyPhone);
        //--------------------------------------
        Text cmpFirstManagerTxt=new Text("manager first name");
        cmpFirstManagerTxt.setLayoutX(14);
        cmpFirstManagerTxt.setLayoutY(250);
        cmpFirstManagerTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC,14));
        root1.getChildren().add(cmpFirstManagerTxt);
        //--------------------------------------
        TextField companyFirstManager=new TextField();
        companyFirstManager.setLayoutX(150);
        companyFirstManager.setLayoutY(233);
        companyFirstManager.setPrefWidth(300);
        root1.getChildren().add(companyFirstManager);
        //------------------------------------------
        Text cmpLasttManagerTxt=new Text("manager last name");
        cmpLasttManagerTxt.setLayoutX(14);
        cmpLasttManagerTxt.setLayoutY(307);
        cmpLasttManagerTxt.setFont(Font.font("", FontWeight.BOLD, FontPosture.ITALIC,14));
        root1.getChildren().add(cmpLasttManagerTxt);
        //------------------------------------------
        TextField companyLastManager=new TextField();
        companyLastManager.setLayoutX(150);
        companyLastManager.setLayoutY(291);
        companyLastManager.setPrefWidth(300);
        root1.getChildren().add(companyLastManager);
        //------------------------------------------
        addEmployeeOnCompany(root1);
        addProductOnCompany(root1);
        //------------------------------------------
        Button companySubmit=new Button("submit");
        root1.getChildren().add(companySubmit);
        companySubmit.setLayoutY(480);
        companySubmit.setLayoutX(148);
        companySubmit.setPrefWidth(200);
        companySubmit.setPrefHeight(50);
        companySubmit.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
        companySubmit.setStyle("-fx-background-color:#6495ed;-fx-border-color:midnightblue;-fx-border-width: 3px;-fx-border-radius: 4px");
        companySubmit.setOnMouseEntered(event -> {
            companySubmit.setStyle("-fx-background-color:#6486ed;-fx-border-color: midnightblue;-fx-border-width: 3px;-fx-border-radius: 4px");
            companySubmit.setScaleX(1.2);
            companySubmit.setScaleY(1.2);

        });
        companySubmit.setOnMouseExited(event -> {
            companySubmit.setStyle("-fx-background-color:#6495ed;-fx-border-color:midnightblue;-fx-border-width: 3px;-fx-border-radius: 4px");
            companySubmit.setScaleX(1);
            companySubmit.setScaleY(1);
        });

        companySubmit.setOnMouseClicked(event1 -> {
            boolean currentNumber=true;
            char[] phoneNumber= companyPhone.getText().toCharArray();
            for (int i = 0; i <phoneNumber.length ; i++) {
                if((int)phoneNumber[i]<48||(int) phoneNumber[i]>57){
                    currentNumber=false;
                    break;
                }
            }
            if(currentNumber){
                Main.addCompany(companyName.getText(),companyAdress.getText(),companyPhone.getText(),companyFirstManager.getText(),companyLastManager.getText(),employees,products);
                employees.clear();
                products.clear();
                stage.close();

            }
            else {
                Text errorMessage=new Text("invalid number");
                errorMessage.setFill(Color.RED);
                errorMessage.setLayoutX(14);
                errorMessage.setLayoutY(214);
                root1.getChildren().add(errorMessage);

                Timeline t1=new Timeline(new KeyFrame(Duration.seconds(1),event2 -> {
                    root1.getChildren().remove(errorMessage);
                }));
                t1.play();
                t1.setCycleCount(1);
            }


        });
    }
    public static void addEmployeeOnCompany(Group root1) {
        Button addEmployee = new Button("add employee");
        addEmployee.setLayoutX(57);
        addEmployee.setLayoutY(350);
        addEmployee.setPrefHeight(50);
        addEmployee.setPrefWidth(150);
        root1.getChildren().add(addEmployee);
        addEmployee.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12));
        addEmployee.setStyle("-fx-background-color:#06baf5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
        addEmployee.setOnMouseEntered(event -> {
            addEmployee.setStyle("-fx-background-color:#0695f5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
            addEmployee.setScaleX(1.1);
            addEmployee.setScaleY(1.1);

        });
        addEmployee.setOnMouseExited(event -> {
            addEmployee.setStyle("-fx-background-color:#06baf5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
            addEmployee.setScaleX(1);
            addEmployee.setScaleY(1);
        });
        addEmployee.setOnMouseClicked(event1 -> {
            Stage stage2 = new Stage();
            Group root2 = new Group();
            Scene scene2 = new Scene(root2, 350, 400, Color.LIGHTSTEELBLUE);
            stage2.setTitle("Add Employee");
            stage2.show();
            stage2.setScene(scene2);
            //-----------------------------------
            Text cmpEmployeeFirstTxt = new Text("employee first name");
            cmpEmployeeFirstTxt.setLayoutX(14);
            cmpEmployeeFirstTxt.setLayoutY(50);
            cmpEmployeeFirstTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root2.getChildren().add(cmpEmployeeFirstTxt);
            //------------------------------------
            TextField companyFirstEmployee = new TextField();
            companyFirstEmployee.setLayoutX(180);
            companyFirstEmployee.setLayoutY(33);
            companyFirstEmployee.setPrefWidth(150);
            root2.getChildren().add(companyFirstEmployee);
            //-----------------------------------------
            Text cmpEmployeeLastTxt = new Text("employee last name");
            cmpEmployeeLastTxt.setLayoutX(14);
            cmpEmployeeLastTxt.setLayoutY(100);
            cmpEmployeeLastTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root2.getChildren().add(cmpEmployeeLastTxt);
            //-------------------------------------------
            TextField companyLastEmployee = new TextField();
            companyLastEmployee.setLayoutX(180);
            companyLastEmployee.setLayoutY(85);
            companyLastEmployee.setPrefWidth(150);
            root2.getChildren().add(companyLastEmployee);
            //-------------------------------------------
            Text cmpEmployeeJobTxt = new Text("employee job");
            cmpEmployeeJobTxt.setLayoutX(33);
            cmpEmployeeJobTxt.setLayoutY(150);
            cmpEmployeeJobTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root2.getChildren().add(cmpEmployeeJobTxt);
            //------------------------------------------
            TextField companyJobEmployee = new TextField();
            companyJobEmployee.setLayoutX(180);
            companyJobEmployee.setLayoutY(134);
            companyJobEmployee.setPrefWidth(150);
            root2.getChildren().add(companyJobEmployee);
            //-------------------------------------------
            Button employeeSubmit = new Button("submit");
            employeeSubmit.setLayoutY(250);
            employeeSubmit.setLayoutX(110);
            employeeSubmit.setPrefWidth(130);
            employeeSubmit.setPrefHeight(40);
            employeeSubmit.setStyle("-fx-background-color:cadetblue");
            root2.getChildren().add(employeeSubmit);
            employeeSubmit.setOnMouseClicked(event2 -> {
                employees.add(companyFirstEmployee.getText()+" "+companyLastEmployee.getText()+" "+companyJobEmployee.getText());
                stage2.close();
            });
        });
    }
    public static void addProductOnCompany(Group root1){
        Button addProduct=new Button("add product");
        addProduct.setLayoutX(285);
        addProduct.setLayoutY(350);
        addProduct.setPrefHeight(50);
        addProduct.setPrefWidth(150);
        root1.getChildren().add(addProduct);
        addProduct.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12));


        addProduct.setStyle("-fx-background-color:#06baf5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
        addProduct.setOnMouseEntered(event -> {
            addProduct.setStyle("-fx-background-color:#0695f5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
            addProduct.setScaleX(1.1);
            addProduct.setScaleY(1.1);

        });
        addProduct.setOnMouseExited(event -> {
            addProduct.setStyle("-fx-background-color:#06baf5;-fx-border-color:rgb(25,25,112);-fx-border-width: 3px;-fx-border-radius: 4px");
            addProduct.setScaleX(1);
            addProduct.setScaleY(1);
        });
        addProduct.setOnMouseClicked(event -> {
            Stage stage3 = new Stage();
            Group root3 = new Group();
            Scene scene3 = new Scene(root3, 350, 400, Color.LIGHTSTEELBLUE);
            stage3.setTitle("Add Product");
            stage3.show();
            stage3.setScene(scene3);
            //------------------------------------
            Text cmpProductNameTxt = new Text("product  name");
            cmpProductNameTxt.setLayoutX(30);
            cmpProductNameTxt.setLayoutY(50);
            cmpProductNameTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root3.getChildren().add(cmpProductNameTxt);
            //------------------------------------
            TextField companyProductName = new TextField();
            companyProductName.setLayoutX(180);
            companyProductName.setLayoutY(33);
            companyProductName.setPrefWidth(150);
            root3.getChildren().add(companyProductName);
            //-----------------------------------------
            Text cmpProductCodeTxt = new Text("product code");
            cmpProductCodeTxt.setLayoutX(30);
            cmpProductCodeTxt.setLayoutY(100);
            cmpProductCodeTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root3.getChildren().add(cmpProductCodeTxt);
            //-------------------------------------------
            TextField companyProductCode = new TextField();
            companyProductCode.setLayoutX(180);
            companyProductCode.setLayoutY(85);
            companyProductCode.setPrefWidth(150);
            root3.getChildren().add(companyProductCode);
            //--------------------------------------------
            Text cmpProductPdateTxt=new Text("produce date");
            cmpProductPdateTxt.setLayoutX(30);
            cmpProductPdateTxt.setLayoutY(151);
            cmpProductPdateTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root3.getChildren().add(cmpProductPdateTxt);
            //---------------------------------------------
            TextField companyProductPdate=new TextField();
            companyProductPdate.setLayoutX(180);
            companyProductPdate.setLayoutY(136);
            companyProductPdate.setPrefWidth(150);
            root3.getChildren().add(companyProductPdate);
            //---------------------------------------------
            Text cmpProductEdateTxt=new Text("expire date");
            cmpProductEdateTxt.setLayoutX(34);
            cmpProductEdateTxt.setLayoutY(201);
            cmpProductEdateTxt.setFont(Font.font("", FontWeight.BLACK, FontPosture.ITALIC, 14));
            root3.getChildren().add(cmpProductEdateTxt);
            //---------------------------------------------
            TextField companyProductEdate=new TextField();
            companyProductEdate.setLayoutX(180);
            companyProductEdate.setLayoutY(186);
            companyProductEdate.setPrefWidth(150);
            root3.getChildren().add(companyProductEdate);
            //---------------------------------------------
            Button productSubmit = new Button("submit");
            productSubmit.setLayoutY(250);
            productSubmit.setLayoutX(110);
            productSubmit.setPrefWidth(130);
            productSubmit.setPrefHeight(40);
            productSubmit.setStyle("-fx-background-color: cadetblue");
            root3.getChildren().add(productSubmit);
            productSubmit.setOnMouseClicked(event1 -> {
                String exp=companyProductCode.getText();
                try{
                    int Exp=Integer.parseInt(exp);
                    products.add(companyProductName.getText()+" "+companyProductPdate.getText()+" "+companyProductEdate.getText()+" "+Exp);

                    stage3.close();

                }
                catch (NumberFormatException e){
                    Text errorMessage=new Text("invalid number");
                    errorMessage.setFill(Color.RED);
                    errorMessage.setLayoutX(30);
                    errorMessage.setLayoutY(115);
                    root3.getChildren().add(errorMessage);
                    Timeline t1=new Timeline(new KeyFrame(Duration.seconds(1),event2 -> {
                        root3.getChildren().remove(errorMessage);
                    }));
                    t1.play();
                    t1.setCycleCount(1);
                }


            });
        });

    }
    public static void addProduct(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,500,650,Color.rgb(0,90,120));
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Add Product");
        stage1.show();
        //-----------------------------------
        Text pName=new Text("product name");
        pName.setLayoutX(70);
        pName.setLayoutY(78);
        pName.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,17));
        pName.setFill(Color.WHITE);
        root1.getChildren().add(pName);
        //-----------------------------------
        TextField productName=new TextField();
        productName.setLayoutX(250);
        productName.setLayoutY(59);
        productName.setPrefWidth(170);
        productName.setPrefHeight(30);
        root1.getChildren().add(productName);
        //------------------------------------
        Text pCompanyName=new Text("company name");
        pCompanyName.setLayoutX(65);
        pCompanyName.setLayoutY(155);
        pCompanyName.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,17));
        pCompanyName.setFill(Color.WHITE);
        root1.getChildren().add(pCompanyName);
        //--------------------------------------
        TextField productCompanyName=new TextField();
        productCompanyName.setLayoutX(253);
        productCompanyName.setLayoutY(134);
        productCompanyName.setPrefWidth(170);
        productCompanyName.setPrefHeight(30);
        root1.getChildren().add(productCompanyName);
        //-----------------------------------------
        Text pProduceDate=new Text("produce date");
        pProduceDate.setLayoutX(73);
        pProduceDate.setLayoutY(230);
        pProduceDate.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,17));
        pProduceDate.setFill(Color.WHITE);
        root1.getChildren().add(pProduceDate);
        //--------------------------------------
        TextField productProduceDate=new TextField();
        productProduceDate.setLayoutX(250);
        productProduceDate.setLayoutY(211);
        productProduceDate.setPrefWidth(170);
        productProduceDate.setPrefHeight(30);
        root1.getChildren().add(productProduceDate);
        //----------------------------------------
        Text pExpireDate=new Text("expire date");
        pExpireDate.setLayoutX(80);
        pExpireDate.setLayoutY(305);
        pExpireDate.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,17));
        pExpireDate.setFill(Color.WHITE);
        root1.getChildren().add(pExpireDate);
        //--------------------------------------
        TextField productExpireDate=new TextField();
        productExpireDate.setLayoutX(250);
        productExpireDate.setLayoutY(286);
        productExpireDate.setPrefWidth(170);
        productExpireDate.setPrefHeight(30);
        root1.getChildren().add(productExpireDate);
        //------------------------------------------
        Text pCode=new Text("product code");
        pCode.setLayoutX(74);
        pCode.setLayoutY(382);
        pCode.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,17));
        pCode.setFill(Color.WHITE);
        root1.getChildren().add(pCode);
        //--------------------------------------
        TextField productCode=new TextField();
        productCode.setLayoutX(250);
        productCode.setLayoutY(361);
        productCode.setPrefWidth(170);
        productCode.setPrefHeight(30);
        root1.getChildren().add(productCode);
        //---------------------------------------
        Button productSubmit=new Button("submit");
        productSubmit.setLayoutX(150);
        productSubmit.setLayoutY(485);
        productSubmit.setPrefWidth(200);
        productSubmit.setPrefHeight(40);
        productSubmit.setStyle("-fx-background-color: lightblue");
        root1.getChildren().add(productSubmit);
        productSubmit.setFont(Font.font("",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,15));
        productSubmit.setOnMouseClicked(event -> {
            String exp=productCode.getText();
            try{
                int Exp=Integer.parseInt(exp);
                Main.addProduct(productName.getText(),productCompanyName.getText(),productProduceDate.getText(),productExpireDate.getText(),Exp);
                stage1.close();
            }
            catch (NumberFormatException e){
                Text errorMessage=new Text("invalid number");
                errorMessage.setFill(Color.RED);
                errorMessage.setLayoutX(75);
                errorMessage.setLayoutY(400);
                root1.getChildren().add(errorMessage);
                Timeline t1=new Timeline(new KeyFrame(Duration.seconds(1),event2 -> {
                    root1.getChildren().remove(errorMessage);
                }));
                t1.play();
                t1.setCycleCount(1);
            }
        });

    }
    public static void addEmployee(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,450,500,Color.THISTLE);
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Add Employee");
        stage1.show();
        //------------------------------------
        Text emFirstName=new Text("employee first name");
        emFirstName.setLayoutX(34);
        emFirstName.setLayoutY(85);
        emFirstName.setFont(Font.font(" ",FontWeight.BLACK,FontPosture.ITALIC,20));
        root1.getChildren().add(emFirstName);
        //--------------------------------------
        Text emLastName=new Text("employee last name");
        emLastName.setLayoutX(34);
        emLastName.setLayoutY(180);
        emLastName.setFont(Font.font(" ",FontWeight.BLACK,FontPosture.ITALIC,20));
        root1.getChildren().add(emLastName);
        //------------------------------------------
        Text emJob=new Text("employee Job");
        emJob.setLayoutX(64);
        emJob.setLayoutY(275);
        emJob.setFont(Font.font(" ",FontWeight.BLACK,FontPosture.ITALIC,20));
        root1.getChildren().add(emJob);
        //----------------------------------------
        TextField employeeFirstName=new TextField();
        employeeFirstName.setLayoutX(255);
        employeeFirstName.setLayoutY(64);
        employeeFirstName.setPrefWidth(165);
        employeeFirstName.setPrefHeight(30);
        root1.getChildren().add(employeeFirstName);
        //------------------------------------------
        TextField employeeLastName=new TextField();
        employeeLastName.setLayoutX(255);
        employeeLastName.setLayoutY(158);
        employeeLastName.setPrefWidth(165);
        employeeLastName.setPrefHeight(30);
        root1.getChildren().add(employeeLastName);
        //-----------------------------------------
        TextField employeeJob=new TextField();
        employeeJob.setLayoutX(255);
        employeeJob.setLayoutY(252);
        employeeJob.setPrefWidth(165);
        employeeJob.setPrefHeight(30);
        root1.getChildren().add(employeeJob);
        //-----------------------------------------
        Button employeeSubmit=new Button("submit");
        employeeSubmit.setLayoutX(115);
        employeeSubmit.setLayoutY(360);
        employeeSubmit.setPrefWidth(220);
        employeeSubmit.setPrefHeight(60);
        employeeSubmit.setStyle("-fx-background-color: navy");
        employeeSubmit.setTextFill(Color.WHITE);
        employeeSubmit.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,20));
        root1.getChildren().add(employeeSubmit);
        employeeSubmit.setOnMouseClicked(event -> {
            Main.addEmployee(employeeFirstName.getText(),employeeLastName.getText(),employeeJob.getText());
            stage1.close();
        });
    }
    public static void addManager(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,370,380,Color.THISTLE);
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Add Manager");
        stage1.show();
        //---------------------------------
        Text maFirstName=new Text("manager first name");
        maFirstName.setLayoutX(34);
        maFirstName.setLayoutY(85);
        maFirstName.setFont(Font.font(" ",FontWeight.BLACK,FontPosture.ITALIC,17));
        root1.getChildren().add(maFirstName);
        //----------------------------------
        Text maLastName=new Text("manager last name");
        maLastName.setLayoutX(34);
        maLastName.setLayoutY(170);
        maLastName.setFont(Font.font(" ",FontWeight.BLACK,FontPosture.ITALIC,17));
        root1.getChildren().add(maLastName);
        //-----------------------------------
        TextField managerFirstName=new TextField();
        managerFirstName.setLayoutX(215);
        managerFirstName.setLayoutY(67);
        managerFirstName.setPrefWidth(130);
        managerFirstName.setPrefHeight(30);
        root1.getChildren().add(managerFirstName);
        //--------------------------------------
        TextField managerLastName=new TextField();
        managerLastName.setLayoutX(215);
        managerLastName.setLayoutY(150);
        managerLastName.setPrefWidth(130);
        managerLastName.setPrefHeight(30);
        root1.getChildren().add(managerLastName);
        //----------------------------------------
        Button managerSubmit=new Button("submit");
        managerSubmit.setLayoutX(93.5);
        managerSubmit.setLayoutY(260);
        managerSubmit.setPrefWidth(183);
        managerSubmit.setPrefHeight(47);
        managerSubmit.setStyle("-fx-background-color: navy");
        managerSubmit.setTextFill(Color.WHITE);
        managerSubmit.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,20));
        root1.getChildren().add(managerSubmit);
        managerSubmit.setOnMouseClicked(event -> {
            Main.addManager(managerFirstName.getText(),managerLastName.getText());
            stage1.close();
        });

    }
    public static void removeCompany(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,400,230,Color.DARKSLATEGREY);
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Remove Company");
        stage1.show();
        //---------------------------------
        Text cmpName=new Text("company name");
        cmpName.setLayoutY(80);
        cmpName.setLayoutX(55);
        cmpName.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,18));
        root1.getChildren().add(cmpName);
        cmpName.setFill(Color.LIGHTGOLDENRODYELLOW);
        //------------------------------------
        TextField companyName=new TextField();
        companyName.setLayoutX(200);
        companyName.setLayoutY(58);
        companyName.setPrefWidth(150);
        companyName.setPrefHeight(30);
        root1.getChildren().add(companyName);
        //-----------------------------------
        Button removeCompanySubmit=new Button("submit");
        removeCompanySubmit.setLayoutX(110);
        removeCompanySubmit.setLayoutY(140);
        removeCompanySubmit.setPrefWidth(180);
        removeCompanySubmit.setPrefHeight(40);
        root1.getChildren().add(removeCompanySubmit);
        removeCompanySubmit.setOnMouseClicked(event -> {
            Main.removeCompany(companyName.getText());
            stage1.close();
        });
    }
    public static void removeProduct(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,400,300,Color.SILVER);
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Remove Product");
        stage1.show();
        //----------------------------------
        Text pName=new Text("product name");
        pName.setLayoutY(70);
        pName.setLayoutX(44);
        pName.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,18));
        root1.getChildren().add(pName);
        pName.setFill(Color.rgb(150,20,60));
        //-----------------------------------
        Text pcName=new Text("company name");
        pcName.setLayoutY(144);
        pcName.setLayoutX(40);
        pcName.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,18));
        root1.getChildren().add(pcName);
        pcName.setFill(Color.rgb(150,20,60));
        //-------------------------------------
        TextField productName=new TextField();
        productName.setLayoutX(200);
        productName.setLayoutY(50);
        productName.setPrefWidth(170);
        productName.setPrefHeight(30);
        root1.getChildren().add(productName);
        //-------------------------------------
        TextField companyProductName=new TextField();
        companyProductName.setLayoutX(200);
        companyProductName.setLayoutY(124);
        companyProductName.setPrefWidth(170);
        companyProductName.setPrefHeight(30);
        root1.getChildren().add(companyProductName);
        //---------------------------------------
        Button removeProductSubmit=new Button("submit");
        removeProductSubmit.setLayoutX(110);
        removeProductSubmit.setLayoutY(200);
        removeProductSubmit.setPrefWidth(180);
        removeProductSubmit.setPrefHeight(40);
        root1.getChildren().add(removeProductSubmit);
        removeProductSubmit.setStyle("-fx-background-color:rgb(150,20,60);-fx-border-color: midnightblue;-fx-border-width:2px;-fx-border-radius: 2px");
        removeProductSubmit.setTextFill(Color.MIDNIGHTBLUE);
        removeProductSubmit.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));

        removeProductSubmit.setOnMouseClicked(event -> {
            Main.removeProduct(productName.getText(),companyProductName.getText());
            stage1.close();
        });
    }
    public static void removeEmployee(){
        Group root2=new Group();
        Scene scene2=new Scene(root2,400,300,Color.MEDIUMSLATEBLUE);
        Stage stage2=new Stage();
        stage2.setScene(scene2);
        stage2.setTitle("Remove Employee");
        stage2.show();
        //-------------------------------
        Text eFirstName=new Text("employee first name");
        eFirstName.setLayoutY(70);
        eFirstName.setLayoutX(33);
        eFirstName.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,16));
        root2.getChildren().add(eFirstName);
        eFirstName.setFill(Color.rgb(40,60,70));
        //-------------------------------------
        Text eLastName=new Text("employee last name");
        eLastName.setLayoutY(144);
        eLastName.setLayoutX(33);
        eLastName.setFont(Font.font(" ",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,16));
        root2.getChildren().add(eLastName);
        eLastName.setFill(Color.rgb(40,60,70));
        //-----------------------------------------
        TextField employeeFirstName=new TextField();
        employeeFirstName.setLayoutX(200);
        employeeFirstName.setLayoutY(50);
        employeeFirstName.setPrefWidth(170);
        employeeFirstName.setPrefHeight(30);
        root2.getChildren().add(employeeFirstName);
        //-------------------------------------
        TextField employeeLastName=new TextField();
        employeeLastName.setLayoutX(200);
        employeeLastName.setLayoutY(124);
        employeeLastName.setPrefWidth(170);
        employeeLastName.setPrefHeight(30);
        root2.getChildren().add(employeeLastName);
        //----------------------------------------
        Button removeEmployeeSubmit=new Button("submit");
        removeEmployeeSubmit.setLayoutX(110);
        removeEmployeeSubmit.setLayoutY(200);
        removeEmployeeSubmit.setPrefWidth(180);
        removeEmployeeSubmit.setPrefHeight(40);
        root2.getChildren().add(removeEmployeeSubmit);
        removeEmployeeSubmit.setOnMouseClicked(event -> {
            Main.removeEmployee(employeeFirstName.getText(),employeeLastName.getText());
            stage2.close();
        });

    }
    public static void removeManager(){
        Group root2=new Group();
        Scene scene2=new Scene(root2,400,230,Color.ALICEBLUE);
        Stage stage2=new Stage();
        stage2.setTitle("Remove Manager");
        stage2.setScene(scene2);
        stage2.show();
        //-------------------------------
        Text mName=new Text("manager name");
        mName.setLayoutY(80);
        mName.setLayoutX(55);
        mName.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.ITALIC,18));
        root2.getChildren().add(mName);
        mName.setFill(Color.rgb(30,150,150));
        //----------------------------------
        TextField managerName=new TextField();
        managerName.setLayoutX(200);
        managerName.setLayoutY(58);
        managerName.setPrefWidth(150);
        managerName.setPrefHeight(30);
        root2.getChildren().add(managerName);
        //-----------------------------------
        Button removeManagerSubmit=new Button("submit");
        removeManagerSubmit.setLayoutX(110);
        removeManagerSubmit.setLayoutY(140);
        removeManagerSubmit.setPrefWidth(180);
        removeManagerSubmit.setPrefHeight(40);
        root2.getChildren().add(removeManagerSubmit);
        removeManagerSubmit.setOnMouseClicked(event -> {
            Main.removeManager(managerName.getText());
            stage2.close();
        });

    }
    public static void editProduct(){
        Group root1=new Group();
        Scene scene1=new Scene(root1,400,230,Color.rgb(20,30,55));
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Edit Product");
        stage1.show();
        //---------------------------------
        Text pName=new Text("product name");
        pName.setLayoutY(80);
        pName.setLayoutX(55);
        pName.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.ITALIC,18));
        root1.getChildren().add(pName);
        pName.setFill(Color.SILVER);
        //------------------------------------
        TextField productName=new TextField();
        productName.setLayoutX(200);
        productName.setLayoutY(58);
        productName.setPrefWidth(150);
        productName.setPrefHeight(30);
        root1.getChildren().add(productName);
        //-----------------------------------
        Button editProductSubmit=new Button("submit");
        editProductSubmit.setLayoutX(110);
        editProductSubmit.setLayoutY(140);
        editProductSubmit.setPrefWidth(180);
        editProductSubmit.setPrefHeight(40);
        root1.getChildren().add(editProductSubmit);
        editProductSubmit.setStyle("-fx-background-color: silver");
        editProductSubmit.setTextFill(Color.rgb(20,30,55));
        editProductSubmit.setFont(Font.font("",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
        editProductSubmit.setOnMouseClicked(event -> {

            Main.editProduct(productName.getText());
            stage1.close();
        });
    }
    public void editProductShow(String s, int a){
        Group root=new Group();
        Scene scene=new Scene(root,400,230,Color.DARKSLATEGREY);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Information");
        stage.show();
        //---------------------------------
        Text details=new Text(s);
        details.setLayoutY(80);
        details.setLayoutX(55);
        details.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,18));
        root.getChildren().add(details);
        details.setFill(Color.LIGHTGOLDENRODYELLOW);
        //------------------------------------
        TextField detailsField=new TextField();
        detailsField.setLayoutX(200);
        detailsField.setLayoutY(58);
        detailsField.setPrefWidth(150);
        detailsField.setPrefHeight(30);
        root.getChildren().add(detailsField);
        //-----------------------------------
        Button submitNewInfo=new Button("submit");
        submitNewInfo.setLayoutX(110);
        submitNewInfo.setLayoutY(140);
        submitNewInfo.setPrefWidth(180);
        submitNewInfo.setPrefHeight(40);
        root.getChildren().add(submitNewInfo);
        submitNewInfo.setOnMouseClicked(event -> {
            if(a==1){
                Myfile myfile=new Myfile();
                myfile.setDetails(detailsField.getText(),a);
                myfile.editProduct2();
                stage.close();
            }
            if(a==3){
                Myfile myfile=new Myfile();
                myfile.setDetails(detailsField.getText(),a);
                myfile.editProduct3();
                stage.close();
            }
            if(a==4){
                Myfile myfile=new Myfile();
                myfile.setDetails(detailsField.getText(),a);
                myfile.editProduct4();
                stage.close();
                //count=0;
            }


        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stop[]stops=new Stop[]{
                new Stop(0,Color.DARKSLATEBLUE),
                new Stop(1,Color.DARKRED),
        };
        LinearGradient linearGradient=new LinearGradient(0,0.5,0.8,1,true, CycleMethod.NO_CYCLE,stops);
        Group root=new Group();
        Scene scene=new Scene(root,500,720, linearGradient);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Main Menue");
        //------------------------------------------------------------
        Button addCompany=new Button("add Company");
        addCompany.setLayoutX(125);
        addCompany.setLayoutY(40);
        addCompany.setPrefHeight(40);
        addCompany.setPrefWidth(250);
        root.getChildren().add(addCompany);
        addCompany.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        addCompany.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        addCompany.setTextFill(Color.AZURE);
        addCompany.setOnMouseEntered(event -> {
            addCompany.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addCompany.setScaleX(1.05);
            addCompany.setScaleY(1.05);

        });
        addCompany.setOnMouseExited(event -> {
            addCompany.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addCompany.setScaleX(1);
            addCompany.setScaleY(1);
        });

        addCompany.setOnMouseClicked(event -> {
            addCompany();
            });
        //---------------------------------------------------------------
        Button addProduct=new Button("add product");
        addProduct.setLayoutX(125);
        addProduct.setLayoutY(120);
        addProduct.setPrefHeight(40);
        addProduct.setPrefWidth(250);
        root.getChildren().add(addProduct);
        addProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        addProduct.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        addProduct.setTextFill(Color.AZURE);
        addProduct.setOnMouseEntered(event -> {
            addProduct.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addProduct.setScaleX(1.05);
            addProduct.setScaleY(1.05);

        });
        addProduct.setOnMouseExited(event -> {
            addProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addProduct.setScaleX(1);
            addProduct.setScaleY(1);
        });
        addProduct.setOnMouseClicked(event -> {
            addProduct();
        });
        //------------------------------------------------------------------
        Button addEmployeeAndManager=new Button("add employee & manager");
        addEmployeeAndManager.setLayoutX(125);
        addEmployeeAndManager.setLayoutY(200);
        addEmployeeAndManager.setPrefHeight(40);
        addEmployeeAndManager.setPrefWidth(250);
        root.getChildren().add(addEmployeeAndManager);
        addEmployeeAndManager.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        addEmployeeAndManager.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        addEmployeeAndManager.setTextFill(Color.AZURE);
        addEmployeeAndManager.setOnMouseEntered(event -> {
            addEmployeeAndManager.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addEmployeeAndManager.setScaleX(1.05);
            addEmployeeAndManager.setScaleY(1.05);

        });
        addEmployeeAndManager.setOnMouseExited(event -> {
            addEmployeeAndManager.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            addEmployeeAndManager.setScaleX(1);
            addEmployeeAndManager.setScaleY(1);
        });
        addEmployeeAndManager.setOnMouseClicked(event -> {
            Group root1=new Group();
            Scene scene1=new Scene(root1,350,350,Color.LAVENDER);
            Stage stage=new Stage();
            stage.setScene(scene1);
            stage.setTitle("Choose");
            stage.show();
            //----------------------------------------------
            Button addEmployee=new Button("add employee");
            addEmployee.setLayoutX(75);
            addEmployee.setLayoutY(70);
            addEmployee.setPrefHeight(60);
            addEmployee.setPrefWidth(200);
            addEmployee.setStyle("-fx-background-color: midnightblue");
            addEmployee.setTextFill(Color.WHITE);
            root1.getChildren().add(addEmployee);
            addEmployee.setOnMouseClicked(event1 -> {
                addEmployee();
            });
            Button addManager=new Button("add manager");
            addManager.setLayoutX(75);
            addManager.setLayoutY(220);
            addManager.setPrefHeight(60);
            addManager.setPrefWidth(200);
            addManager.setStyle("-fx-background-color: midnightblue");
            addManager.setTextFill(Color.WHITE);
            root1.getChildren().add(addManager);
            addManager.setOnMouseClicked(event1 -> {
                addManager();
            });
        });
        //-------------------------------------------------------------------
        Button removeCompany=new Button("remove company");
        removeCompany.setLayoutX(125);
        removeCompany.setLayoutY(280);
        removeCompany.setPrefHeight(40);
        removeCompany.setPrefWidth(250);
        root.getChildren().add(removeCompany);
        removeCompany.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        removeCompany.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        removeCompany.setTextFill(Color.AZURE);
        removeCompany.setOnMouseEntered(event -> {
            removeCompany.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeCompany.setScaleX(1.05);
            removeCompany.setScaleY(1.05);

        });
        removeCompany.setOnMouseExited(event -> {
            removeCompany.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeCompany.setScaleX(1);
            removeCompany.setScaleY(1);
        });
        removeCompany.setOnMouseClicked(event -> {
            removeCompany();
        });

        //--------------------------------------------------------------------
        Button removeProduct=new Button("remove product");
        removeProduct.setLayoutX(125);
        removeProduct.setLayoutY(360);
        removeProduct.setPrefHeight(40);
        removeProduct.setPrefWidth(250);
        root.getChildren().add(removeProduct);
        removeProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        removeProduct.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        removeProduct.setTextFill(Color.AZURE);
        removeProduct.setOnMouseEntered(event -> {
            removeProduct.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeProduct.setScaleX(1.05);
            removeProduct.setScaleY(1.05);

        });
        removeProduct.setOnMouseExited(event -> {
            removeProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeProduct.setScaleX(1);
            removeProduct.setScaleY(1);
        });
        removeProduct.setOnMouseClicked(event -> {
            removeProduct();
        });
        //--------------------------------------------------------------------
        Button removeEmployeeandManager=new Button("remove employee & manager");
        removeEmployeeandManager.setLayoutX(125);
        removeEmployeeandManager.setLayoutY(440);
        removeEmployeeandManager.setPrefHeight(40);
        removeEmployeeandManager.setPrefWidth(250);
        root.getChildren().add(removeEmployeeandManager);
        removeEmployeeandManager.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        removeEmployeeandManager.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        removeEmployeeandManager.setTextFill(Color.AZURE);
        removeEmployeeandManager.setOnMouseEntered(event -> {
            removeEmployeeandManager.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeEmployeeandManager.setScaleX(1.05);
            removeEmployeeandManager.setScaleY(1.05);

        });
        removeEmployeeandManager.setOnMouseExited(event -> {
            removeEmployeeandManager.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            removeEmployeeandManager.setScaleX(1);
            removeEmployeeandManager.setScaleY(1);
        });
        removeEmployeeandManager.setOnMouseClicked(event -> {
            Group root1=new Group();
            Scene scene1=new Scene(root1,350,350,Color.SEASHELL);
            Stage stage=new Stage();
            stage.setTitle("Choose");
            stage.setScene(scene1);
            stage.show();
            //------------------------------------------
            Button removeEmployee=new Button("remove employee");
            removeEmployee.setLayoutX(75);
            removeEmployee.setLayoutY(70);
            removeEmployee.setPrefHeight(60);
            removeEmployee.setPrefWidth(200);
            removeEmployee.setStyle("-fx-background-color: cornflowerblue");
            removeEmployee.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,16));
            removeEmployee.setTextFill(Color.BLACK);
            root1.getChildren().add(removeEmployee);
            removeEmployee.setOnMouseClicked(event1 -> {
                removeEmployee();
            });
            Button removeManager=new Button("remove manager");
            removeManager.setLayoutX(75);
            removeManager.setLayoutY(220);
            removeManager.setPrefHeight(60);
            removeManager.setPrefWidth(200);
            removeManager.setStyle("-fx-background-color: cornflowerblue");
            removeManager.setFont(Font.font(" ",FontWeight.BOLD,FontPosture.REGULAR,16));
            removeManager.setTextFill(Color.BLACK);
            root1.getChildren().add(removeManager);
            removeManager.setOnMouseClicked(event1 -> {
                removeManager();
            });

        });;
        //---------------------------------------------------------------------
        Button editProduct=new Button("edit product");
        editProduct.setLayoutX(125);
        editProduct.setLayoutY(520);
        editProduct.setPrefHeight(40);
        editProduct.setPrefWidth(250);
        root.getChildren().add(editProduct);
        editProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        editProduct.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        editProduct.setTextFill(Color.AZURE);
        editProduct.setOnMouseEntered(event -> {
            editProduct.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            editProduct.setScaleX(1.05);
            editProduct.setScaleY(1.05);

        });
        editProduct.setOnMouseExited(event -> {
            editProduct.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            editProduct.setScaleX(1);
            editProduct.setScaleY(1);
        });
        editProduct.setOnMouseClicked(event -> {
            editProduct();
        });
        //----------------------------------------------------------------------
        Button exit=new Button("exit");
        exit.setLayoutX(125);
        exit.setLayoutY(600);
        exit.setPrefHeight(40);
        exit.setPrefWidth(250);
        root.getChildren().add(exit);
        exit.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
        exit.setFont(Font.font("",FontWeight.BLACK,FontPosture.REGULAR,14));
        exit.setTextFill(Color.AZURE);
        exit.setOnMouseEntered(event -> {
            exit.setStyle("-fx-background-color:midnightblue;-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            exit.setScaleX(1.05);
            exit.setScaleY(1.05);

        });
        exit.setOnMouseExited(event -> {
            exit.setStyle("-fx-background-color:rgba(11,97,120,0.86);-fx-border-color: azure;-fx-border-width: 3px;-fx-border-radius: 2px");
            exit.setScaleX(1);
            exit.setScaleY(1);
        });
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        //-----------------------------------------------------------------

    }

    public static void graphics(String []arrgs){
        launch(arrgs);
    }
}
