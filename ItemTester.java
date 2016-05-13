import java.util.*;
public class ItemTester
{
   public static void main( String args[])
   {
      ArrayList<Item> hardware = new ArrayList<Item>();
         hardware.add(new Item(1011, "Air Filters", 200, 10.5));
         hardware.add(new Item(1034, "Door Knobs", 60, 21.5));
         hardware.add(new Item(1101, "Hammers", 90, 9.99));
         hardware.add(new Item(1600, "Levels", 80, 19.99));
         hardware.add(new Item(1500, "Ceiling Fans", 100, 59));
         hardware.add(new Item(1201, "Wrench Sets", 55, 80));
      System.out.println("Original");
      sortID(hardware);
      printStock(hardware);
      System.out.println();
      System.out.println("Sort by name");
      sortName(hardware);
      printStock(hardware);
      System.out.println();
      System.out.println("Sort by number in stock");
      sortStock(hardware);
      printStock(hardware);
      System.out.println();
      System.out.println("Sort by price");
      sortPrice(hardware);
      printStock(hardware);
   }
   static void printStock(ArrayList<Item> h)
   {
      for(int i = 0; i < h.size(); i ++)
      {
         h.get(i).myToString();
      }
   }
   static ArrayList<Item> sortID(ArrayList<Item> h)
   {
      int j, i;
         for (i = 1; i < h.size(); i++) {
            Item key = new Item(0, "", 0, 0.0);
            key.id = h.get(i).id;
            key.name = h.get(i).name;
            key.stock = h.get(i).stock;
            key.price = h.get(i).price;
            j = i;
            while((j > 0) && (h.get(j - 1).id > key.id))
            {
               h.set(j,h.get(j - 1));
               j--;
            }
        h.set(j,key);
        }
        return h;
   }
   static ArrayList<Item> sortName(ArrayList<Item> h)
   {
      int j, i;
         for (i = 1; i < h.size(); i++) {
            Item key = new Item(0, "", 0, 0.0);
            key.id = h.get(i).id;
            key.name = h.get(i).name;
            key.stock = h.get(i).stock;
            key.price = h.get(i).price;
            j = i;
            while((j > 0) && (h.get(j - 1).name.compareTo(key.name) > 0))
            {
               h.set(j,h.get(j - 1));
               j--;
            }
        h.set(j,key);
        }
        return h;
   }
   static ArrayList<Item> sortStock(ArrayList<Item> m)
   {
      int max = 0;
      Item temp;
      int min = 0;
      int j = 0;
      int i = 0;
      for (j = 0; j < m.size() - 1; j ++)
      {
         max = j;
            for(i = j + 1; i < m.size(); i ++)
            {
               if(m.get(max).stock > m.get(i).stock)
               {
                  max = i;
               }
            }
         temp = m.get(j);
         m.set(j, m.get(max));
         m.set(max, temp);
      }
      return m;
   }
   static ArrayList<Item> sortPrice(ArrayList<Item> whole)
   {
      ArrayList<Item> left = new ArrayList<Item>();
      ArrayList<Item> right = new ArrayList<Item>();
      int center; 
      if (whole.size() == 1)
      {    
          return whole;
      }
      else
      {
         center = whole.size()/2;
         for (int i=0; i<center; i++) 
         {
            left.add(whole.get(i));
         }
         for (int i=center; i<whole.size(); i++) 
         { 
            right.add(whole.get(i));
         }
         left  = sortPrice(left);
         right = sortPrice(right);
         mergePrice(left, right, whole);
      }
   return whole;
   }
   private static void mergePrice(ArrayList<Item> left, ArrayList<Item> right, ArrayList<Item> whole) 
   {
      int leftIndex = 0;
      int rightIndex = 0;
      int wholeIndex = 0;
      while (leftIndex < left.size() && rightIndex < right.size()) 
      {
         if ( (left.get(leftIndex).price < right.get(rightIndex).price))
         {
            whole.set(wholeIndex, left.get(leftIndex));
            leftIndex++;
         }
         else 
         {
            whole.set(wholeIndex, right.get(rightIndex));
            rightIndex++;
         }
         wholeIndex++;
      }
      ArrayList<Item> rest;
      int restIndex;
      if (leftIndex >= left.size()) 
      {
          rest = right;
          restIndex = rightIndex;
      } 
      else 
      {
         rest = left;
         restIndex = leftIndex;
      }
   
       // Copy the rest of whichever ArrayList (left or right) was not used up.
      for (int i=restIndex; i<rest.size(); i++) 
      {
         whole.set(wholeIndex, rest.get(i));
         wholeIndex++;
      }
   }

}