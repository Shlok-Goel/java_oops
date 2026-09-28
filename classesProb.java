abstract class item{
    String ID;
    String name;
    double basePrice;
    double weight;

    item(String ID, String name, double basePrice,double weight){
        this.ID=ID;
        this.name=name;
        this.basePrice=basePrice;
        this.weight=weight;
    }

    public abstract double calculateStorageCost(int daysInWarehouse);

    public abstract boolean isShippable();

    public String getItemDetails(item item){
        return ("Item details: "+ item.ID+", "+item.name+", RS."+item.basePrice+", "+item.weight+" kgs.");
    }

}

class PerishableItem extends item{
    int expirationDays;
    boolean requiresRefrigeration;

    PerishableItem(String ID, String name, double basePrice,double weight,int expirationDays,boolean requiresRefrigeration){
        super(ID,name,basePrice,weight);
        this.expirationDays=expirationDays;
        this.requiresRefrigeration=requiresRefrigeration;
    }

    @Override
    public double calculateStorageCost(int daysInWarehouse) {
        return basePrice*0.02*daysInWarehouse;
    }

    @Override
    public boolean isShippable() {
        if (expirationDays>2){
            return true;
        } else {return false;}
    }
}

class HazardousItem extends item{
    int hazardRating;
    boolean hasSafetyPermit;

    HazardousItem(String ID, String name, double basePrice,double weight,int hazardRating,boolean hasSafetyPermit){
        super(ID, name, basePrice, weight);
        this.hasSafetyPermit=hasSafetyPermit;
        this.hazardRating=hazardRating;
    }

    @Override
    public double calculateStorageCost(int daysInWarehouse) {
        return (basePrice*0.01*daysInWarehouse)+(hazardRating*15.00);
    }

    @Override
    public boolean isShippable() {
        if(hasSafetyPermit && hazardRating<=3)
            return true;
        else {return false;}
    }  

}

class WarehouseManager {
    item[] items;
    private int count;

    public WarehouseManager(int capacity){
        items=new item[capacity];
        count=0;
    }

    void addItem(item item){
        if (count<items.length){
            items[count]=item;
            count++;
        } else {System.out.println("Capacity is full!");}
    }

    float calculateTotalStorageCost(int days){
        float totalCost=0;
        for (item item : items) {
            if(item!=null)
            totalCost+=item.calculateStorageCost(days);
        }
        return totalCost;
    }

    public item getItem(int index) {
        return items[index];
    }

   


}


public class classesProb {
    public static void main(String[] args){
        WarehouseManager warehouse=new WarehouseManager(10);
        warehouse.addItem(new PerishableItem("E001", "Pickle", 100, 1, 90, false));
        warehouse.addItem(new HazardousItem("F001", "Acid", 500, 0.5, 2, true));

        System.out.println("Cost for perishable items for 10 days is: "+warehouse.getItem(0).calculateStorageCost(10));
        System.out.println("Total warehouse for 10 days: "+warehouse.calculateTotalStorageCost(10));
    }
}
