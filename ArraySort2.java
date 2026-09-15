//Given an integer array nums, move all 0s to the end of it while maintaining the relative order of the non-zero elements.
import java.util.*;

class ArraySort2 {
    public static void main(String[] args){

        int num;
        Scanner sc=new Scanner(System.in);
        System.out.print("Type array length: ");
        num=sc.nextInt();

        Integer[] arr=new Integer[num];

        for(int i=0;i<arr.length;i++){
            System.out.print("Type entry "+(i+1)+":");
            arr[i]=sc.nextInt();
        }

        System.out.print("Current array : [");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
              
        }
        System.out.println("]");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[i]==0){
                    if(arr[i+j]!=0){
                        arr[i]=arr[i+j];
                        arr[i+j]=0;
                        continue; //go to next j
                    }
                }
            }
        }

        //print new array
        System.out.print("New array : [");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
              
        }
        System.out.println("]");

        sc.close();
        
    }
}
