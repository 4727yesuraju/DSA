class TimeComplexity{

    static int findSumOrder1(int n){ //O(1) constant time independent from input
         return n*(n+1)/2;
    }

    static int findSumOrderN(int n){ //O(n)  input processed by algorithm helps in determining the time complexity
        int sum = 0;
        for(int i=1;i<=n;i++) sum+=i;
         return sum;
    }

    public static void main(String args[]){
        double now = System.currentTimeMillis();
        System.out.println(findSumOrder1(99999));
        System.out.println("Time required for Order : O(1) ==> " + (System.currentTimeMillis()-now) + " millisecs ");
        now = System.currentTimeMillis();
        System.out.println(findSumOrderN(99999));
        System.out.println("Time required for Order : O(n) ==> " + (System.currentTimeMillis()-now) + " millisecs ");

    }
}