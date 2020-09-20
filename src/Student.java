public class Student {

    public static void main(String[] args) {


        int [] a =new int[]{1,2,3,4,5,6,7,8,9};

        int mid=-1,item=9;
        int low=0,h=a.length-1;

        while(low<=h){
            mid=(low+h)/2;

            if(a[mid]==item){
                System.out.println(mid);
                return;
            }else if(a[mid]>item){
                h=mid-1;
            }else
                low = mid+1;
        }
    }
}
