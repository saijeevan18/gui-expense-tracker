import java.util.*;
import java.io.*;

class Expense{
    int Amount;
    String Category;
    String Date;
    
    
    @Override
    public String toString() {
        return "Amount:" + Amount + " | Category:" + Category + "| Date:" + Date;
    }

    
}



class ExpenseTracker{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Expense> ar=new ArrayList<>();
        int choice;
        


        do{
            System.out.println("----Expense Tracker Menu----");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expense");
            System.out.println("3.Total Expenses");
            System.out.println("4.Filter By Category");
            System.out.println("5.Highest Expense");
            System.out.println("6.Exit");
            System.out.print("Enter Your Choice: ");
            choice=sc.nextInt();
            sc.nextLine();
            
            

        
            if(choice ==1){
                Expense e=new Expense();
                System.out.println("Enter Your Amount: ");
                e.Amount=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Your Category: ");
                e.Category=sc.nextLine();
                
                System.out.println("Enter A Date: ");
                e.Date=sc.nextLine();
                ar.add(e);
                try {
                    FileWriter fw = new FileWriter("expenses.txt", true);
                    fw.write(e.Amount + "," + e.Category + "," + e.Date + "\n");
                    fw.close();
                } catch(Exception ex){
                    System.out.println("Error saving file");
                }
                
            }
            
            
            if(choice==2){
                if(ar.isEmpty()){
                    System.out.println("Please Add Your Expenses First");}
                
                for(Expense ex:ar){
                    System.out.println(ex.toString());
                }
           
            }
            if(choice==3){
                if(ar.isEmpty()){
                    System.out.println("No expenses Found");
                }
                else{
                    int total=0;

                    for(Expense ex:ar){
                        total +=ex.Amount;
                    }
                System.out.println("Total Expense = "+ total);

            }
        }
        if(choice==4){
            System.out.println("Enter category to filter");
            String cat=sc.nextLine();
            int cate_total=0;
            boolean found=false;
            
           
            for(Expense ex: ar){
                if(ex.Category.equalsIgnoreCase(cat)){
                    System.out.println(ex);
                    cate_total +=ex.Amount;
                    found=true;
                }
                
                
            }
            System.out.println("Total "+ cat + " Expenses= " +cate_total);
            if(!found){
                System.out.println("No Matching Expense");
            }
            
            
        }
        if(choice==5){
            if(ar.isEmpty()){
                System.out.println("Enter Expense First");
            }
            else{
                Expense max = ar.get(0);
                for(Expense ex:ar){
                    if(ex.Amount>max.Amount){
                        max=ex;
                    }
                }
                System.out.println("Highest Expense:");
                System.out.println(max);
            }
        }
            
        }while(choice !=6);
        if(choice==6){
            System.out.println("Exited Thank You");
        }
    sc.close();
    }
}
