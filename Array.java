

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

    void reverseArray(int arr[],int start, int end){
        while(start<end){
            arr[start]+=arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start++]-=arr[end--];
        }
    }

    int findMin(int [] arr){
        int size  = arr.length;
        int min = Math.min(arr[0],arr[size-1]);
        for(int i=1;i<size-1;i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    int findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i]!=max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    void moveZeroLeft(int[] arr){
        for(int i=0,j=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[j]==0){
                arr[j] = arr[i];
                arr[i] = 0;
            }
            if(arr[j] != 0) j++;
        }
    }

    int findMissingNumber(int[] arr){
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        for(int num : arr) sum -= num;
        return sum;
    }

    boolean isPalindrom(String word){
        char[] charArray = word.toCharArray();
        System.out.println(word);
        for(int i=0,j=charArray.length-1;i<j;i++,j--) if(charArray[i] != charArray[j]) return false;
        return true;
    }
    public static void main(String args[]){
          Array array = new Array();
        //   array.arrayDemo();
        //   System.out.println(Arrays.toString(array.removeEven(new int[]{1,2,3,4,5,6})));
        //   array.printArray(array.removeEven(new int[]{1,2,3,4,5,6}));
          int arr[] = new int[]{0,1,2,0,3,4,0,0,5,-1,6,0};
        //   array.reverseArray(arr,0,arr.length-1);
        //   array.printArray(arr);
        // System.out.println(array.findMin(arr));
        // System.err.println(array.findSecondMax(arr));
        array.moveZeroLeft(arr);
        // array.printArray(arr);
        // System.out.print(array.findMissingNumber(new int[] {2,5,1,3,4}));
        System.out.println(array.isPalindrom("madama"));
    }
}