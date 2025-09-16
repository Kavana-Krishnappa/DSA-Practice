import java.util.Arrays;

public class array0 {

 public static void main(String[] args) {
    int arr[]={1,3,4,5,0};
    System.out.println(Arrays.toString(arr));
    int pos=1;
    int val=2;

    for(int i=(arr.length-2);i>=pos;i--){
        arr[i+1]=arr[i];
    }
    arr[pos]=val;
    System.out.println(Arrays.toString(arr));
    
}
}