import java.util.*;

class ArraySort{
    public static void main(String[] args){
        //input for array length
        int num;
        Scanner sc=new Scanner(System.in);
        System.out.print("Type array length: ");
        num=sc.nextInt();

        //forming the array
        Integer[] arr=new Integer[num];

        for(int i=0;i<arr.length;i++){
            System.out.print("Entry "+(i+1)+" :");
            arr[i]=sc.nextInt();
        }


        //deleting duplicate entries
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[i+j]==arr[i]){
                    arr[i+j]=null;
                }
            }
        }   
        
        int k=arr.length;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==null){
                k--;
            }
        }

        //sorting array
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[i]==null){
                    if(arr[i+j]!=null){
                        arr[i]=arr[i+j];
                        arr[i+j]=null;
                    }
                }else{}
            }
            
        }

        
        //printing array
        System.out.println("k="+k);
        System.out.print("Sorted array = [");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");

        sc.close();
        


    }
}