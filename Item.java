public class Item
{
   int id;
   String name;
   int stock;
   double price;
   public Item(int itemID,String itemName,int inStore,double price)
   {
      id = itemID;
      name = itemName;
      stock = inStore;
      this.price = price;
   }
   public void myToString()
   {
      System.out.printf("%4d  %13s  %3d  %2.2f %n",id,name,stock,price);
   }
}