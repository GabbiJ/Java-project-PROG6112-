
package prog6112.assignment.pkg1;

/**
 *
 * @author ST10034968
 */
public class Product 
{
    String code, category, name, warranty, supplier;
    int price, stockLevel;
    
    //method to print all attributes of a product
    public void display()
    {
        System.out.println("PRODUCT CODE >>\t\t" + this.code
                + "\nPRODUCT NAME >>\t\t" + this.name
                + "\nPRODUCT CATEGORY >>\t" + this.category
                + "\nPRODUCT WARRANTY >>\t" + this.warranty
                + "\nPRODUCT PRICE >>\tR " + this.price
                + "\nPRODUCT LEVEL >>\t" + this.stockLevel
                + "\nPRODUCT SUPPLIER >>\t" + this.supplier);
    }
    
    //getters and setters of attributes
    //getters
    public String getCode() {
        return code;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getWarranty() {
        return warranty;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getPrice() {
        return price;
    }

    public int getStockLevel() {
        return stockLevel;
    }
    //setters

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
}
