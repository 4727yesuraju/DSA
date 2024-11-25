

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

    public static void reverse(int[] nums){
        int start = 0, end = nums.length-1;
        while(start < end){
            nums[start] +=nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start++]-=nums[end--];
        }
    }

    public static int findMin(int[] arr){
        if(arr==null || arr.length==0) throw new IllegalArgumentException("invalid input");
        int min = arr[0];
        for(int i=0;i<arr.length;i++) if(arr[i]<min) min = arr[i];
        return min;
    }

    public static int findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i]>secondMax && arr[i]!=max) secondMax = arr[i];
        }
        return secondMax;
    }

    public static void moveZerosToRight(int[] arr){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[j]==0){
                  arr[i]+=arr[j];
                  arr[j]= arr[i]-arr[j];
                  arr[i]-=arr[j];
            }
            if(arr[j]!=0) j++;
        }
    }

    static int sum(int[] nums){ 
        int sum= 0;
        for(int num:nums) sum+=num;
        return sum;
    }
    public static int findMissingNumber(int[] arr){
           int n = arr.length+1;
           int nTermsSum = n*(n+1)/2;
           return nTermsSum - sum(arr);
    }

    public static boolean isPalindrom(String word){
        char[] charArray = word.toCharArray();
        int start = 0,end= charArray.length-1;
        while(start<end){
            if(charArray[start++] != charArray[end--]) return false;
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isPalindrom("yesu"));
        System.out.println(isPalindrom("ada"));
    }
}