import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Main {
    public static void main(String[]args){
        //Create new product linked list
        MyList<Product> productList= new MyList<Product>();
        //Create new stack
        MyStack<Product> productStack = new MyStack<Product>();
        //Create new queue
        MyQueue<Product> productQueue = new MyQueue<Product>();
        //Set function caller
        OperationToProduct perform = new OperationToProduct();
        //Get item from exist file first
        perform.getAllItemsFromFile("Product.txt",productList);
        //Print console output to file and console
        perform.saveConsoleOutPutToFile();
        showMenu();
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        while (choose!=0){
            //Load data from file and display
            if (choose==1){
                perform.getAllItemsFromFile("Product.txt",productList);
                perform.displayAll(productList);
                showMenu();
                choose = input.nextInt();
            }
            //Input & add to the end
            else if (choose==2) {
                Product newProduct = perform.createProduct();
                productList.insertAtTail(newProduct);
                System.out.println("New product has been added!");
                showMenu();
                choose = input.nextInt();
            }
            //Display data
            else if (choose==3){
                perform.displayAll(productList);
                showMenu();
                choose = input.nextInt();
            }
            //Save product list to file.
            else if (choose==4) {
                perform.writeAllItemsToFile("Product.txt",productList);
                showMenu();
                choose = input.nextInt();
            }
            //Search by ID
            else if(choose==5){
                perform.searchByCode(productList);
                showMenu();
                choose = input.nextInt();
            }
            //Delete by ID
            else if (choose==6) {
                perform.deleteByCode(productList);
                showMenu();
                choose = input.nextInt();
            }
            //Sort by ID.
            else if (choose==7) {
                perform.sortByCode(productList);
                showMenu();
                choose = input.nextInt();
            }
            //Convert first item quantity to Binary
            else if (choose==8) {
                System.out.print("Quantity = " + productList.head.info.getQuantity() + " =>(" );
                System.out.println(perform.convertToBinary(productList.head.info.getQuantity()) + ")");
                showMenu();
                choose = input.nextInt();
            }
            //Load to stack and display
            else if (choose==9) {
                perform.getAllItemsFromFile("Product.txt",productStack);
                perform.displayAll(productStack);
                showMenu();
                choose = input.nextInt();
            }
            //Load to queue and display
            else if (choose==10) {
                perform.getAllItemsFromFile("Product.txt",productQueue);
                perform.displayAll(productQueue);
                showMenu();
                choose = input.nextInt();
            }
            //Choose again if the choose input is invalid
            else{
                System.out.println("Invalid choose please choose from 0 to 10!");
                showMenu();
                choose = input.nextInt();
            }
        }

    }
    //Print menu method
    public static void showMenu() {
        String output="Choose one of this options:"+ "\n" +
                ""+"Product list:"+"\n"
                +"1. Load data from file and display"+"\n"
                +"2. Input & add to the end."+"\n"
                +"3. Display data"+"\n"
                +"4. Save product list to file."+"\n"
                +"5. Search by ID"+"\n"
                +"6. Delete by ID"+"\n"
                +"7. Sort by ID."+"\n"
                +"8. Convert to Binary"+"\n"
                +"9. Load to stack and display"+"\n"
                +"10. Load to queue and display."+"\n"
                +"0. Exit"+"\n"
                +"Your choose: ";
        System.out.println(output);
    }

}
