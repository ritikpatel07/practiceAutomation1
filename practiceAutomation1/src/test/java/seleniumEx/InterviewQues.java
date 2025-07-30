package seleniumEx;

public class InterviewQues {
	public static void main(String [] args)
	{
		// 1. Sorting an array
		int arr[] = {5,3,1,2,4};
		int result[] = sorting(arr);
		
		for(int i=0; i< result.length; i++)
		{
			System.out.println(result[i]);
		}
		
		// 2. Sum of each digit in a string
//		String s="ab12cd3e4f5";
//		int count = 0;
//		for(int i = 0; i< s.length(); i++)
//		{
//			char c = s.charAt(i);
//			if(c >= '0' && c <= '9')
//			{
//				int n = c - 48;
//				count += n;
//			}
//		}
//		System.out.println(count);
	}
	
	public static int[] sorting(int arr[])
	{
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j= i+1; j<arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					//swap the values
					int val = arr[i];
					arr[i] = arr[j];
					arr[j] = val;
				}
			}
		}
		return arr;
	}

}
