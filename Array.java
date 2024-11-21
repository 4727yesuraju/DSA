

class Array{



    //creating array
    public void arrayDemo(){
        int [] arr = new int[5];
        arr[0] = 0;
        arr[2] = 2;
        printArray(arr);

        int[] arr1 = {1,2,4};
        printArray(arr1);

        printArray(new int[]{1,2,3});
    }

    //print array in this format [ 0, 0, 0 ]
    public static void printArray(int[] arr){
        int length = arr.length;
        if(length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[ ");
        for(int i=0;i<length;i++){
            if(i==length-1){
                System.out.print(arr[i] + " ]\n");
                return;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    //remove even enteegers from array
    public static int[] removeEven(int[] arr){
        int oddCount = 0, length= arr.length;
        for(int i=0;i<length;i++){
            if(arr[i]%2!=0) oddCount++;
        }

        int res[] = new int[oddCount], ind=0;

        for(int i=0;i<length;i++){
            if(arr[i]%2!=0){
                res[ind++] = arr[i];
            }
        }
        return res;
    }
    public static void main(String args[]){
        //  Array array = new Array();
        //  array.arrayDemo();
        printArray(removeEven(new int[]{2,4,6,1}));
    }
}