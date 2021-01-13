import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] start = new int[100];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
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
				if(arr1[0]<arr2[0] || arr2[0]==0 || arr1[0]==arr2[0])
				{	
					arr[i]=arr1[0];
					arr1[0]=0;
					if(arr1.length>1)
					{
						for(int c=0; c<arr1.length-1; c++)
						{
							arr1[c]=arr1[c+1];
						}
					}
				}
				else if(arr2[0]<arr1[0] || arr1[0]==0 || arr2[0]==arr1[0])
				{
					arr[i]=arr2[0];
					arr2[0]=0;
					if(arr2.length>1)
					{
						for(int c=0; c<arr2.length-1; c++)
						{
							arr2[c]=arr2[c+1];
						}
					}
				}
			}

			
		}
		for(int a: arr)
			System.out.print(a + " ");
		System.out.println();
	}

}
