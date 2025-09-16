public class arraylinearsearch {
public static void main(String[] args){
    int arr[]={1,2,3,4,5};
    int ele=7;
    int ans=linearsearch(arr, ele);
    System.out.println(ans);
}
    public static int linearsearch(int[] arr,int ele){
    for(int i=0;i<arr.length-1;i++){
        if(arr[i]==ele){
          return i;
        }
    }
    return -1; 
}
}