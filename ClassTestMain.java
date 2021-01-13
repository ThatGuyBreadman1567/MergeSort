import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author breadman22
 *
 */
public class ClassTestMain 
{
	public static void main(String[] args) 
	{
		int[] list = new int[] {7,2,8,3,5 };
		for(int a : list)
		{
			System.out.print(a + " ");
		}
		System.out.println();
		mergesort(list);
		for(int a : list)
		{
			System.out.print(a + ", ");
		}
	}
	public static void mergesort(int[] arr)
	{
		int[] arr1 = new int[arr.length-(arr.length/2)];
		int[] arr2 = new int[arr.length/2];
		
		if(arr.length>1)
		{
			for(int i=0; i<arr1.length;i++)
			{
				arr1[i]+=arr[i];
			}
			for(int i=arr1.length; i<arr.length; i++)
			{
				arr2[i-arr1.length]+=arr[i];
			}
			
			if(arr1.length>1)
				mergesort(arr1);
			if(arr2.length>1)
				mergesort(arr2);
			
			for(int i=0; i<arr.length; i++)
			{
				if(arr1[0]<arr2[0] || arr2[0]==0 || arr1[0]==arr2[0] && !(arr1[0]==0))
				{	
					arr[i]=arr1[0];
					arr1[0]=0;
					if(arr1.length>1)
					{
						for(int c=0; c<arr1.length-1; c++)
						{
							arr1[c]=arr1[c+1];
						}
						arr1[arr1.length-1]=0;
					}
				}
				else if(arr2[0]<arr1[0] || arr1[0]==0 || arr2[0]==arr1[0] && !(arr2[0]==0))
				{
					arr[i]=arr2[0];
					arr2[0]=0;
					if(arr2.length>1)
					{
						for(int c=0; c<arr2.length-1; c++)
						{
							arr2[c]=arr2[c+1];
						}
						arr2[arr2.length-1]=0;
					}
				}
			}	
		}
	}
}


