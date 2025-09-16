public class arraybinarysearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
    int ele=7;
    int ans=binarysearch(arr, ele);
    System.out.println(ans);
}
    public static int binarysearch(int[] arr,int ele){
        int low=0;
        int high= arr.length-1;

        while(low<=high){

            int mid=(low+high)/2;
            if(arr[mid]==ele){
               return mid;
            }
            if(arr[mid]<ele){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    
    }
    
}
