public class array {


    public static int binarysearch(int number[], int key){
        int start = 0, end = number.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            //comparison
            if(number[mid]==key){
                return mid;
            }
            if(number[mid]<key){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return -1;
    }
     public static int findx(int number[]){
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<number.length; i++){
                if(largest<number[i]){
                    largest = number[i]; 
                }
        }
        return largest;
    }
//      public static int linear (int number[], int key){
//         for(int i = 0; i<=number.length; i++){
//             if(number[i]==key){
//                 return i;
//             }
//         }
//         return -1;
//     }
//     public static void main(String[] args) {
//         int number[] = {44,56,76,34,45,75,35};
//         int key = 56;

//         int index = linear(number,key);

//         if(index == -1){
//             System.out.println("no found");
//         }
//         else{
//             System.out.println( "key is " + index);
//         }

//     }
// }

    public static void reversearray(int number[]){
        int first = 0, last = number.length-1;

        while(first < last){
            int temp = number[last];
            number[last] = number[first];
            number[first] = temp;

            first++;
            last--;
        }
    }

    public static void printpair(int number[]){
        int tp =0;
        for(int i=0; i<number.length; i++){
            int curr = number[i];
            for(int j=i+1; j<number.length; j++){
                System.out.print("(" + curr + "," + number[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pair : "+tp);
    }

    public static void printsubarray(int number[]){
        int ts=0;
        for(int i=0; i<number.length; i++){
            int start=i;

            for(int j=i; j<number.length; j++){
                int end=j;

                for(int k=start; k<=end; k++){
                    System.out.print(number[k]+ " ");
                    ts++;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total pair : "+ts);
    }

    public static void printmaaaxsubarraysum(int number[]){
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;

        for(int i=0; i<number.length; i++){
            int start =i;

            for(int j=i; j<number.length; j++){
                int end = j;
                currsum = 0;

                for(int k=start; k<=end; k++){
                    currsum = currsum+number[k];
                }
                System.out.println(currsum);

                if(maxsum<currsum){
                    maxsum = currsum;
                }
            }
        }
        System.out.println("maxsum is : "+ maxsum);
    }

    public static void printmaaxsubarraysum(int number[]){
        int currsum =0;
        int maxsum = Integer.MAX_VALUE;
        int prefix[] = new int[number.length];

        prefix[0] = number[0];

        for(int i=1; i<number.length; i++){
            prefix[i] = prefix[i-1] + number[i];

        }

        for(int i=0; i<number.length; i++){
            int start =i;

            for(int j=i; j<number.length; j++){
                int end = j;

                currsum = start==0?prefix[end]: prefix[end]-prefix[start-1];

               if(maxsum < currsum){
                maxsum = currsum;
                
               }
            }
        }
        System.out.println("maxsum is : " + maxsum);
        
    }
    public static void printmaxsubarraysum(int number[]){
        int currsum = 0;
        int maxsum  = Integer.MIN_VALUE;

        for(int i =0; i<number.length; i++) {
            currsum = currsum + number[i];
            if(currsum<0){
                currsum =0;

            }
            maxsum = Math.max(maxsum, currsum);
        }
        System.out.println("max sum is  : " + maxsum);
    }

    public static int trappedrainwater(int number[]){
        //left max boundry
        int leftmax[] = new int[number.length];
        leftmax[0] = number[0];
        for(int i=1; i<number.length; i++){
            leftmax[i] = Math.max(number[i],leftmax[i-1]);
        }

        //rightmax boundry
        int rigthmax[] = new int[number.length];
        rigthmax[number.length-1] = number[number.length-1];

        for(int i=number.length-2; i>=0; i--){
            rigthmax[i] = Math.max(number[i],rigthmax[i+1]);
        }
            int trappedwater = 0;
        //minimum boundry
        for(int i = 0; i<number.length; i++){
            int minboundry = Math.min(rigthmax[i],leftmax[i]);

            trappedwater = trappedwater + (minboundry-number[i]);
        }

        return trappedwater;
    }
    public static int buyandsellstock(int price[]){
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int i = 0; i<price.length; i++){
            if(buyprice<price[i]){
                int profit = price[i]-buyprice;

                maxprofit = Math.max(maxprofit,profit);

            }
            else{
                buyprice = price[i];
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int price[] = {7,1,5,3,6,4};
        int key = 5;
        
        System.out.println(buyandsellstock(price));
    }
}
