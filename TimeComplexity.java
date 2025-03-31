class TimeComplexity{
    public static void main(String args[]){
        final int number= 99999;

        System.out.println("Calculating time : ");
        double now = System.currentTimeMillis();
        System.out.println(/* "Sum of first "+ number +"numbers are O(n) : "+ */findSum(number));
        System.out.println("Time taken to complete : "+ (System.currentTimeMillis()-now));
        double nowAlt = System.currentTimeMillis();
        System.out.println(/* "Sum of first "+ number +"numbers are O(n) : "+ */findSumAlt(number));
        System.out.println("Time taken to complete : "+(System.currentTimeMillis()-nowAlt));

    }

    static long findSum(int n){
        return n*(n+1)/2;
    }

    static long findSumAlt(int n){
        int sum = 1+n;
        for(int i=2;i<n;i++)  sum +=i;
        return sum;
    }
}