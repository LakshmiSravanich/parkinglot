import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) {
        try{
                FileInputStream fs = new FileInputStream("input.txt");
                Scanner sc = new Scanner(fs);
                String t = sc.nextLine();
                String[] st = t.split(" ");
                int size = Integer.parseInt(st[1]);
                System.out.println("Created parking of "+size+" slots");
                int num = 0;
                String[] reg = new String[size];
                for(int i=0;i<size;i++){
                    reg[i] = "";
                }
                int[] age = new int[size];
                while(sc.hasNextLine()){
                    String temp = sc.nextLine();
                    String[] s = temp.split(" ");
                    
                    if(s[0].equals("Park")){
                        String r = s[1];
                        int a = Integer.parseInt(s[3]);
                        if(num<size){
                            for(int i=0;i<size;i++){
                                if(age[i]<1){
                                    age[i] = a;
                                    reg[i] = r;
                                    System.out.println("Car with vehicle registration number \""+r+"\" has been parked at slot number "+(i+1));
                                    break;
                                }
                            }
                            num++;
                        }   
                        else{
                            System.out.println("No Slots Available");
                        }
                    }

                    else if(s[0].equals("Slot_numbers_for_driver_of_age")){
                        int a = Integer.parseInt(s[1]);
                        int count =0;
                        for(int x=0;x<age.length;x++){
                            if(age[x]==a){
                                if(count<1){
                                    System.out.print(x+1);
                                    count++;
                                } 
                                else{
                                    System.out.print(","+(x+1));
                                }
        
                            }
                        }
                        System.out.println();
                    }

                    else if(s[0].equals("Slot_number_for_car_with_number")){
                        String a = s[1];
                        for(int x=0;x<reg.length;x++){
                            if(reg[x].equals(a)){
                                System.out.println(x+1);
                                break;
                            }
                        }
                    }

                    else if(s[0].equals("Leave")){
                        int sl = Integer.parseInt(s[1]);
                        if(reg[sl-1]=="-1"){
                            System.out.println("Slot already vacant");
                        }
                        else{
                            System.out.println("Slot number "+sl+" vacated, the car with vehicle registration number \""+reg[sl-1]+"\" left the space, the driver of the car was of age "+age[sl-1]);
                            reg[sl-1] = "-1";
                            age[sl-1] = -1;
                            num--;
                        }
                    }

                    else if(s[0].equals("Vehicle_registration_number_for_driver_of_age")){
                        int a = Integer.parseInt(s[1]);
                        int count=0;
                        for(int x=0;x<age.length;x++){
                            if(age[x]==a){
                                if(count<1){
                                    System.out.print(reg[x]);
                                    count++;
                                }
                                else{
                                    System.out.print(","+reg[x]);
                                }
                            }
                        }
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
