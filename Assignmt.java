import java.io.*;
import java.util.*;

class A {
  String name;
  int price;

  public A(String n, int p) {
    this.name = n;
    this.price = p;
  }

  public String toString() { 
      return this.name + ": " + this.price;
  }
}

public class Assignmt {
  public static void main(String[] args) throws Exception {
    File file=new File("C:\\Users\\pavan\\OneDrive\\Desktop\\Assignment\\input.txt");       
    Scanner sc=new Scanner(file);
    int pse = Integer.parseInt(sc.nextLine().split(": ")[1]);
    sc.nextLine(); 
    sc.nextLine(); 
    sc.nextLine();

    ArrayList<A> ali = new ArrayList<A>();

    while(sc.hasNextLine())  
    {
      String current[] = sc.nextLine().split(": ");
      ali.add(new A(current[0], Integer.parseInt(current[1])));
    }
    sc.close();

    Collections.sort(ali, new Comparator<A>(){
      public int compare(A a, A b) { 
        return a.price - b.price; 
      } 
    });

    int asp = ali.get(ali.size()-1).price;
    int min_index = 0;
    for(int i=0;i<ali.size()-pse+1;i++) {
      int diff = ali.get(pse+i-1).price-ali.get(i).price;

      if(diff<=asp) {
        asp = diff;
        min_index = i;
      }
    }
    
    

    FileWriter fw = new FileWriter("C:\\Users\\pavan\\OneDrive\\Desktop\\Assignment\\output.txt");
    fw.write("Here the goodies that are selected for distribution are:\n\n");
    for(int i=min_index;i<min_index + pse; i++) {
      fw.write(ali.get(i).toString() + "\n");
    }

    fw.write("\nAnd the difference between the chosen goodie with highest price and the lowest price is " + asp);
      fw.close();
  }
}