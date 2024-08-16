import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.naming.Name;

class Main {
    
    public static void main(String[] args) {
        //  path to text file
        String filePath = "example.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            String next = scanner.nextLine();
          Human arr[] = new Human[96];
          int yuh = 0;
          
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
              // name
              int spot = line.indexOf(",");
                String name = line.substring(0, spot);
                System.out.println("name: " + name); 
              
              //email
              int spot2 = line.indexOf(",",spot +1);
              String email = line.substring(spot +1, spot2);
              System.out.println("email:" + email);
              
              //id
              int spot3 = line.indexOf(",",spot2+1);
              String id = line.substring(spot2+1, spot3);
              int id2 = Integer.parseInt(id);
              System.out.println("id:" + id);
              
              //money
              String money = line.substring(spot3+2);
              int money2 = Integer.parseInt(money);
              System.out.println("money: " + money2);
              arr [yuh] = new Human(name, email, id2, money2);
              yuh++;
            }
          System.out.println(filePath);
        // below is code for finding average # of letters in a human's name - alg. 1
        
          double sumLength = 0.0;
          for (int x = 0; x<arr.length; x++){
            String name6 = arr[x].getName();
            sumLength += (name6.length() - 1); // -1 to get rid of space
          }
          double avgNum = (sumLength/arr.length);
          System.out.println("Average Number of Letters in a Human's Full Name = " + avgNum);

// algorithm 2 :)
          int count = 0;
          for (int x = 0; x<arr.length; x++){
            String name7 = arr[x].getName();
            if((name7.length()-1) >= avgNum){
count+=1; 
              
            }
          }
          System.out.println("# of People Who Are ABOVE Average :) :) :):" + "(have more than " + avgNum +" letters in their name) = " + count);
          
            scanner.close();
          
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
