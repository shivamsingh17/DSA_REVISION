import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearch
{
    int bin(int[] a)
    {
        int t = 1;
        int s = 0;
        int end = a.length - 1;
        int mid = 0;
        while(s<=end){ //
            mid = (s+end)/2;
            if (t == a[mid])return mid;
            if(t>a[mid])s = mid+1;//
            else
            end = mid-1;
            
        }
        return -1;
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{BinarySearch ob = new BinarySearch();
		// your code goes here
	int a[] = {2,3,4,6,8};
	System.out.println(ob.bin(a));
	

	}
}
