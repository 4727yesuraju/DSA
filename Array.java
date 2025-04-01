
import java.util.Arrays;

public class Array{
    void printArray(int arr[]){
        int n = arr.length;
        System.out.print("[");
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]);
            if(i<n-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    void arrayDemo(){
        int[] arr = new int[5];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[3] = 30;
        printArray(arr);
        System.out.println("last Element : "+arr[arr.length-1]);
    }

    int[] removeEven(int arr[]){
        int oddCount = 0;
        for(int i=0;i<arr.length;i++) if(arr[i]%2!=0) oddCount++;
        int[] res = new int[oddCount];
        int idx = 0;
        for(int i=0;i<arr.length;i++) if(arr[i]%2!=0) res[idx++] = arr[i];
        return res;
    }
    public static void main(String args[]){
          Array array = new Array();
          array.arrayDemo();
          System.out.println(Arrays.toString(array.removeEven(new int[]{1,2,3,4,5,6})));
          array.printArray(array.removeEven(new int[]{1,2,3,4,5,6}));
    }
}