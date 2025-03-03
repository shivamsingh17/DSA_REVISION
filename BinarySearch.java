import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearch
{   int firstandlast(int []a){
    int res = -1;
            int t = 3;

          int s = 0;
        int end = a.length - 1;
        int mid = 0;
        while(s<=end){ // r
            mid = (s+end)/2;
            if(t == a[mid]){
                res = mid; 
                end = mid-1;; // 1st oc 
                // last oc start = mid+1
            }
            else if(t < a[mid]) end = mid-1;
            else s = mid+1;
        }
        
        return res;
}
    int bin(int[] a) //naive
    {
        int t = 1;
        int s = 0;
        int end = a.length - 1;
        int mid = 0;
        while(s<=end){ // r
            mid = (s+end)/2;
            if (t == a[mid])return mid;
            if(t>a[mid])s = mid+1;//r
            else
            end = mid-1;
            
        }
        return -1;
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{BinarySearch ob = new BinarySearch();
		// your code goes here
	int a[] = {1, 2,3,3, 4,6,8};
	System.out.println(ob.bin(a));
		System.out.println(ob.firstandlast(a));
	


	}
}
