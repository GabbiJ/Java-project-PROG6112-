
package prog6112.assignment.pkg1;

import java.util.Scanner;

/**
 *
 * @author ST10034968
 */
public class Products 
{
    //declarations
    static Scanner s = new Scanner(System.in);
    static String lineA = "*******************************************";
    static String lineE = "===========================================";
    static String lineD = "-------------------------------------------";
    
    //method to search array for a product by code
    static void SearchProduct()
    {
        //declarations
        String searchedCode;
        boolean found = false;
        Product result;
        
        //prompting user for code to search
        System.out.print("Please enter a product code to search: ");
        searchedCode = s.next();
        
        //code is compared against code of every element in product array list
        for (int i = 0; i < ReportData.report.size(); i++) 
        {
            //printing product if found
            String tempCode = ReportData.report.get(i).code;
            if(searchedCode.equalsIgnoreCase(tempCode))
            {
                found = true;
                result = ReportData.report.get(i);
                System.out.println(lineA 
                                   + "\nPRODUCT SEARCH RESULTS" 
                                   + "\n" + lineA
                                   + "\nPRODUCT CODE:\t\t" + result.code
                                   + "\nPRODUCT NAME:\t\t" + result.name
                                   + "\nPRODUCT WARRANTY:\t" + result.warranty
                                   + "\nPRODUCT CATEGORY:\t" + result.category
                                   + "\nPRODUCT PRICE:\t\tR " + result.price
                                   + "\nPRODUCT STOCK LEVELS:\t" + result.stockLevel
                                   + "\nPRODUCT SUPPLIER:\t" + result.supplier
                                   + "\n" + lineA);
            }
        }
        //if no product is found then user is notified
        if(found == false)
        {
            System.out.println("The product cannot be located. Invalid product.");
        }
        return;
    }
    //search method that takes a String as an argument 
    //and returns a Product
    static Product SearchProduct(String searchedCode)
    {
        //declarations
        boolean found = false;
        Product result = new Product();
        
        //comparing each code in the array with searched code to find a match
        for (int i = 0; i < ReportData.report.size(); i++) 
        {
            //printing product if found
            String tempCode = ReportData.report.get(i).code;
            if(searchedCode.equalsIgnoreCase(tempCode))
            {
                found = true;
                result = ReportData.report.get(i);
                
                System.out.println(lineA 
                                   + "\nPRODUCT SEARCH RESULTS" 
                                   + "\n" + lineA
                                   + "\nPRODUCT CODE:\t\t" + result.code
                                   + "\nPRODUCT NAME:\t\t" + result.name
                                   + "\nPRODUCT WARRANTY:\t" + result.warranty
                                   + "\nPRODUCT CATEGORY:\t" + result.category
                                   + "\nPRODUCT PRICE:\t\tR " + result.price
                                   + "\nPRODUCT STOCK LEVELS:\t" + result.stockLevel
                                   + "\nPRODUCT SUPPLIER:\t" + result.supplier
                                   + "\n" + lineA);
            }
        }
        //user is notified if no product is found
        if(found == false)
        {
            System.out.println("The product cannot be located. Invalid product.");
        }
       
        return result;    
    }
    //method to save product to array
    static void SaveProduct(Product tempProduct)
    {
        ReportData.report.add(tempProduct);
    }
    //method to alter a product in the array
    static void UpdateProduct()
    {
        //declarations
        String search;
        String choice;
        Product toChange;
        int index;
        
        //searching product by code
        System.out.print("Please enter the product code to update: ");
        search = s.next();
        
        //assigning searchhed product to temporary product
        toChange = SearchProduct(search);
        index = ReportData.report.indexOf(toChange);
        
        //prompting user if they want to update warranty
        System.out.println("Update the warranty? (y) Yes, (n) No");
        choice = s.next();
        
        //updating warranty
        if(choice.equalsIgnoreCase("y"))
        {
           
            System.out.print("\nIndicate the product warranty. Enter 1 to apply a six-month product warranty."
                           + "\nEnter any other key to apply a 2 year warranty.");
            byte choice2 = s.nextByte();

            if(choice2 == 1)
            {
                ReportData.report.get(index).warranty = "6 months";
            }
            else
            {
                ReportData.report.get(index).warranty = "2 years";
            }
        }
        
        //prompting user if they want to update product price
        System.out.println("\nUpdate the product price? (y) Yes, (n) No ");
        choice = s.next();
        
        //updating product price
        if(choice.equalsIgnoreCase("y"))
        {
            System.out.print("Enter the new price for " + ReportData.report.get(index).name + " >> ");
            ReportData.report.get(index).price = s.nextInt();
        }
        
        //prompting user if they want to update stock level
        System.out.println("\nUpdate the stock level? (y) Yes, (n) No ");
        choice = s.next();
        
        //updating stock level
        if(choice.equalsIgnoreCase("y"))
        {
            System.out.print("Enter the new stock level >> ");
            ReportData.report.get(index).stockLevel = s.nextInt();
        }
        
        //notify user that update is complete
        System.out.println("Product details has been updated successfully!!!");
    }
    //method to delete product in the array
    static void DeleteProduct()
    {
        //declarations
        String answer;
        String search;
        Product productD;
        
        //searching for a product by code
        System.out.print("Please enter a product code to search: ");
        search = s.next();
        
        productD = SearchProduct(search);
        
        //asking user if they want to delete product
        System.out.println("Would you like to delete above product?(y)/(n)");
        answer = s.next();
        
        //getting index of product that matches temporary product and deleting it
        if(answer.equalsIgnoreCase("y"))
        {
            int index = ReportData.report.indexOf(productD);
            ReportData.report.remove(index);
        }
        return;
    }
    //method that prints menu of application
    static void DisplayMenu()
    {
        System.out.println("\nPlease select one of the following menu items:"
                            + "\n(1) Capture a new product"
                            + "\n(2) Search for a product"
                            + "\n(3) Update a product"
                            + "\n(4) Delete a product"
                            + "\n(5) Print report"
                            + "\n(6) Exit Application");
    }
    //method that prompts user for product attributes 
    //and saves them in the array
    static void CaptureProduct()
    {
        //declarations
        byte choice = 0;
        Product temp = new Product();
        
        System.out.println("CAPTURE A NEW PRODUCT"
                + "\n*************************\n");
        
        //prompting for product code
        System.out.print("Enter the product code: ");
        temp.code = s.next();
        s.nextLine();
        
        //prompting user for product name
        System.out.print("\nEnter the product name: ");
        temp.name = s.nextLine();
        
        //prompting user using a menu for product category
        //if incorrect value inputted then the menu is reprompted
        while(choice < 1 || choice > 5)
        {
            System.out.println("\nSelect the product category:"
                + "\nDesktop Computer - 1"
                + "\nLaptop - 2"
                + "\nTablet - 3"
                + "\nPrinter - 4"
                + "\nGaming Console - 5\n");
            
            System.out.print("Product Category >> ");
            choice = s.nextByte();
            
            switch (choice)
            {
                case 1:
                  temp.category = "Desktop Computer";  
                break;
                case 2:
                    temp.category = "Laptop";
                break;
                case 3:
                    temp.category = "Tablet";
                break;
                case 4:
                    temp.category = "Printer";
                break;
                case 5:
                    temp.category = "Gaming Console";
                break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        choice = 0;
        
        //prompting user to use a menu to enter product warranty
        System.out.print("\nIndicate the product warranty. "
                + "\nEnter 1 to apply a six-month product warranty."
                + "\nEnter any other key to apply a 2 year warranty. ");
        choice = s.nextByte();
        
        if(choice == 1)
        {
            temp.warranty = "6 months";
        }
        else
        {
            temp.warranty = "2 years";
        }
        
        //prompting user for product price 
        System.out.print("\nEnter the price for " + temp.name + " >> ");
        temp.price = s.nextInt();
        
        
        //prompting user for stock level
        System.out.print("\nEnter the stock level for " + temp.name + " >> ");
        temp.stockLevel = s.nextInt();
        s.nextLine();
        
        //prompting user for supplier
        System.out.print("\nEnter the supplier for " + temp.name + " >> ");
        temp.supplier = s.nextLine();
        
        //confirming to user that product has beeen saved
        System.out.println("\nProduct details have been saved successfully!!!");
        
        //saving product
        Products.SaveProduct(temp);
        
        return;
    }
    //method to exit application
    static void ExitApplication()
    {
        System.out.println("Exiting program.");
        System.exit(0);
    }
    //method to generate a report
    static void GenerateReport()
    {
        //declarations
        int totalValue = 0;
        double aveValue;
        
        System.out.println("PRODUCT REPORT"
                + "\n" + lineE);
        //using a for loop prints out all products in array list
        for(int i = 0; i < ReportData.report.size(); i++)
        {
            System.out.println("\nPRODUCT " + (i+1)
                + "\n" + lineD);
            
            ReportData.report.get(i).display();
            
            System.out.println(lineD);
            
            //accumulating a total value of all the prices for report 
            totalValue += ReportData.report.get(i).price;
        }
        //calculating average price for report
        aveValue = (double)totalValue / (double)ReportData.report.size();
        aveValue = (double)Math.round(aveValue *100) / 100;
        
        //printing total products,total prices and average price
        System.out.println(lineE
                           + "\nTOTAL PRODUCT COUNT: " + ReportData.report.size()
                           + "\nTOTAL PRODUCT VALUE: R " + totalValue 
                           + "\nAVERAGE PRODUCT VALUE: R " + aveValue 
                           + "\n" + lineE);
        
    }
}
