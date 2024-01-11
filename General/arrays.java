public class arrays{
	static int[] ChangeNigrs(int[] arr){
		int[] newArr = new int[arr.length * 2];
		for (int i = 0; i < newArr.length; ++i){
			newArr[i] = i;
		}
		arr = newArr;
		return arr;
	}

	static void print(int[] arr){
		for (int i = 0; i < arr.length; ++i){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		int[] nigrs = new int[] {1,2,3,4,5,6,7,8};
		print(nigrs);
		
		nigrs = ChangeNigrs(nigrs);

		print(nigrs);
	}
}