import java.io.*;
import java.util.*;
/**

 * This class manages all functions relate to the product

 */

public class OperationToProduct {

    /**

     * Creating and returning a product with info input from keyboard.

     *

     * @return The product

     */

    public Product createProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Product code: ");
        String pCode = input.nextLine();
        System.out.print("Product name: ");
        String pName= input.nextLine();
        System.out.print("Product quantity: ");
        Integer pQuantity = input.nextInt();
        System.out.print("Product price: ");
        double pPrice= input.nextDouble();
        Product newProduct = new Product(pCode,pName,pQuantity,pPrice);
        return newProduct;
    }



    /**

     * Reading all products from the file and insert them to the list.

     *

     * @param fileName The file name of the file

     * @param list     The Linked List contains all products that read from file

     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        try{
            list.clear();
            FileInputStream input= new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(input);
            Object obj = objectIn.readObject();
            while (obj!=null){
                Product a= (Product) obj;
                list.insertAtTail(a);
                obj = objectIn.readObject();
        }
            objectIn.close();
        }catch (Exception ex) {
            ex.getStackTrace();
        }

    }



    /**

     * Reading all products from the file and insert them to the stack.

     *

     * @param fileName The file name of the file

     * @param stack     The Stack contains all products that read from file

     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        try{
            stack.clear();
            FileInputStream input= new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(input);
            Object obj = objectIn.readObject();
            while (obj!=null){
                Product a= (Product) obj;
                stack.push(a);
                obj = objectIn.readObject();
            }
            objectIn.close();
        }catch (Exception ex) {
            ex.getStackTrace();
        }

    }



    /**

     * Reading all products from the file and insert them to the queue.

     *

     * @param fileName The file name of the file

     * @param queue     The Queue contains all products that read from file

     */

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        try{
            queue.clear();
            FileInputStream input= new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(input);
            Object obj = objectIn.readObject();
            while (obj!=null){
                Product a= (Product) obj;
                queue.enqueue(a);
                obj = objectIn.readObject();
            }
            objectIn.close();
        }catch (Exception ex) {
            ex.getStackTrace();
        }
    }





    /**

     * Printing all products of the list to console screen

     *

     * @param list The product list need to print

     */

    public void displayAll(MyList<Product> list) {
        Node temp = list.head;
        if (temp==null){
            System.out.println("Currently no product available");
        }
        while (temp!=null){
            System.out.println(temp.info.toString());
            temp=temp.next;
        }

    }
    /**

     * Printing all products of the stack to console screen

     *

     * @param stack The product stack need to print

     */

    public void displayAll(MyStack<Product> stack) {
        Node temp = stack.head;
        if (temp==null){
            System.out.println("Currently no product available");
        }
        while (temp!=null){
            System.out.println(temp.info.toString());
            temp=temp.next;
        }

    }
    /**

     * Printing all products of the queue to console screen

     *

     * @param queue The product stack need to print

     */
    public void displayAll(MyQueue<Product> queue) {
        Node temp = queue.head;
        if (temp==null){
            System.out.println("Currently no product available");
        }
        while (temp!=null){
            System.out.println(temp.info.toString());
            temp=temp.next;
        }

    }



    /**

     * Writing all products from the list to the file

     *

     * @param fileName Input file name

     * @param list     Input Linked list

     */

    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Node temp = list.head;
            while(temp!=null) {
                objectOut.writeObject(temp.info);
                temp=temp.next;
            }
            objectOut.close();
            System.out.println("The Object was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    /**

     * Searching product by ID input from keyboard.

     *

     * @param list Input Linked list

     */

    public void searchByCode(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input search ID: ");
        String searchID = input.nextLine();
        Node <Product> temp = list.head;
        while(temp!= null && !(temp.info.getBcode().contains(searchID))){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("-1");
            return;
        }
        else if(temp.info.getBcode().contains(searchID)){
            System.out.println(temp.info.toString());
        }
    }



    /**

     * Deleting first product that has the ID input from keyboard from the list.

     *

     * @param list Input Linked list

     */

    public void deleteByCode(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input search ID: ");
        String searchID = input.nextLine();
        Node <Product> temp = list.head;
        int indexOfSearchID=0;
        while(temp!= null && !(temp.info.getBcode().contains(searchID))){
            temp=temp.next;
            indexOfSearchID+=1;
        }
        if(temp==null)
        {
            System.out.println("The Id non exist!");
            return;
        }
        else if(temp.info.getBcode().contains(searchID)){
           list.deleteElement(indexOfSearchID);
        }

    }
    //Swap two arraylist index
    public static void swap(ArrayList<Product> arr, int x, int y) {
        Product temp = arr.get(x);
        arr.set(x,arr.get(y));
        arr.set(y,temp);
    }
    //Quicksort method for arraylist
    public static void quickSort(ArrayList<Product> arr, int low, int high) {
        //Check if arraylist is null
        if (arr == null || arr.size() == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        //Choose middle index of arraylist to pivot
        int middle = low + (high - low) / 2;
        String pivot = arr.get(middle).getBcode();
        // Split arraylist
        int i = low, j = high;
        while (i <= j) {
            //Check until all left side smaller than pivot
            while (arr.get(i).getBcode().compareTo(pivot) <0) {
                i++;
            }
            //Check until all right side larger than pivot
            while (arr.get(j).getBcode().compareTo(pivot)>0) {
                j--;
            }
            //Compare two side to check if they need to swap
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        //Recursion
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }


    /**

     * Sorting products in linked list by ID

     *

     * @param list The Linked list

     */

    public void sortByCode(MyList<Product> list) {
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        Node <Product> temp = list.head;
        while (temp!=null){
            productArrayList.add(temp.info);

            temp=temp.next;
        }
        quickSort(productArrayList,0,productArrayList.size()-1);
        list.clear();
        for (int i = 0;i< productArrayList.size();i++){
                    list.insertAtTail(productArrayList.get(i));
                    productArrayList.get(i).toString();
                }
        }



    /**

     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010

     * @param x Input decimal number

     * @return a integer numbers

     */

    public String convertToBinary(int x) {
        int a;
        if(x > 0)
        {
            a = x % 2;
            return (convertToBinary(x / 2) + "" +a);
        }
        return "";

    }
    //Print console output to file and console
    public void saveConsoleOutPutToFile(){
        try{
            PrintStream originalSysOut=System.out;

            SplitOutPutStream split=new SplitOutPutStream(
                    new FileOutputStream("ConsoleOutput.txt"),
                    originalSysOut
            );
            PrintStream splitPs=new PrintStream(split,true);

            System.setOut(splitPs);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}