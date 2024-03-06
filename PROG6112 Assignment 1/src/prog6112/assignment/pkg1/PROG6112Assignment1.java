
package prog6112.assignment.pkg1;

/**
 *
 * @author ST10034968
 */
import java.util.*;
public class PROG6112Assignment1 
{
    public static void main(String[] args) 
    {
        //declarations
        Scanner s = new Scanner(System.in);
        byte choice = 0;
        
        //Printing greeting and option to quit
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION"
                + "\n**************************************"
                + "\nEnter (1) to launch menu or any other key to exit");
        choice = s.nextByte();
        
        if(choice != 1)
        {
            Products.ExitApplication();
        }
        
        //printing selection menu and prompting user choice
        //while loop used to reprompt user
        while(choice!= 6)
        {
            Products.DisplayMenu();
            choice = s.nextByte();
            
            switch(choice)
            {
                case 1:
                    Products.CaptureProduct();
                    break;
                case 2:
                    Products.SearchProduct();
                    break;
                case 3:
                    Products.UpdateProduct();
                    break;
                case 4:
                    Products.DeleteProduct();
                    break;
                case 5:
                    Products.GenerateReport();
                    break;
                case 6:
                    Products.ExitApplication();
                    return;
                default:
                    System.out.println("Invalid input.");
            }
            //second choice for the user to exit
            System.out.println("Enter (1) to launch menu or any other key to exit");
            byte choice2 = s.nextByte();
            if(choice2 != 1)
            {
                Products.ExitApplication();
            }
        }
        
        
        
    }
    
}
