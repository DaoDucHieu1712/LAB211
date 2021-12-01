public class Main
 {public static void main(String [] args)
   { 
     MyList t = new MyList();
     Node p; Ticket x;
     String[] a={"HN","HP","TH","HU","DN","QB","NT"};
     int [] b = {300,180,200,190,430,200,100};
//…………………….
     System.out.println("\n1. Test addLast");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     t.addEnd("TB",-200);
     t.addEnd("TB",300);
//-----------------------
   System.out.println("\n2. Test searchByPath");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     p = t.searchByPath("DN");
     if(p==null)
      System.out.println("Not found");
      else
      {System.out.println("The Ticket found is");
        t.visit(p); System.out.println();
      }
//----------------------------------------------
   System.out.println("\n3. Test insertAfter");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     x = new Ticket("LS",300);
     t.insertAfter(x,200);  
     t.traverse(); 
//-----------------------------------
    System.out.println("\n4. Test removeFirst()");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     t.removeFirst();
     t.traverse();
//------------------
    System.out.println("\n5. cheapestPrice()");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     p = t.cheapestPrice();
     System.out.println("The ticket with cheapest price");
     t.visit(p);
     System.out.println();
//--------------------------
   System.out.println("\n6. Test remove(Node q)");
     t.clear();
     t.addLastMany(a,b);  
     t.traverse();
     Node q = t.searchByPath("HU");
     t.remove(q);  
     t.traverse();
   }
 }
