class ArrayHighClass {
	private long[] a;
	private int nElems;
	private long[] tempA;
	
	

	// ---------------------------------
	public ArrayHighClass(int max) {
		a = new long[max];
		tempA = new long[max];
		nElems = 0;
	}

	// ---------------------------------
	public boolean find(int searchKey) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == searchKey)
				break;
		if (j == nElems)
			return false;
		else
			return true;
	}

	// -----------------------------------
	public void insert(long value) {
		a[nElems] = value;
		tempA[nElems] = value;
		nElems++;
	}

	// -----------------------------------
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == value)
				break;
		if (j == nElems)
			return false;
		
		else {
			for (int k = j; k < nElems; k++)
			{
				a[k] = a[k + 1];
							}
			//for tempA
			for (j = 0; j < nElems; j++)
				if (tempA[j] == value)
					break;
			if (j == nElems)
				return false;
			
			else {
				for (int k = j; k < nElems; k++)
				{
										tempA[k] = tempA[k+1];
				}
			nElems--;
			
			return true;
		}
		}
	}
	/*
	 * when used instead of tempA[k] = tempA[k+1], or any other way - the array a is getting updated with the tempA values after sorting
	 * so use tempA in delete method as well to avoid the issue
	 * need to understand why is it happening
	 * 
	 * 
	public void updatetempA(long[] temp){
		tempA = temp;
	}
	*/

	// -------------------------------------
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println(" ");
	}

	// --------------------------------------
	public long getMax() {
		
		if (nElems == 0)
			return -1;

		else if (nElems > 0) {
			
			for (int j = 0; j < nElems; j++) {
				for (int i = j + 1; i < nElems; i++) {
					if (tempA[j] > tempA[i]) {
						long temp;
						temp = tempA[j];
						tempA[j] = tempA[i];
						tempA[i] = temp;

					}
				}
			}
		}
		long maxvalue = tempA[nElems-1];
	
		System.out.println("Max value in the array is : " + maxvalue);
		System.out.println(tempA[0]+" " + tempA[1] + " "+tempA[nElems-1]);//checking the last element(i.e.max value) 
		removeMax(maxvalue);
		System.out.println(tempA[0]+" " + tempA[1] + " "+tempA[nElems-1]);//checking the last element(i.e.max value) after removing
		return maxvalue;
		
		
	}
	
	//----------------------------------------------------
	public void removeMax(long maxvalue){
		delete(maxvalue);
		
		
	}

}
//---------------------- MAIN METHOD ------------------------------------------------------------------
public class HighArray {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayHighClass arr;
		arr = new ArrayHighClass(maxSize);
		
		arr.insert(87);
		arr.insert(9);
		arr.insert(56);
		arr.insert(98);
		arr.insert(34);
		arr.insert(78);
		arr.insert(45);
		arr.insert(100);
		arr.insert(67);
		arr.insert(62);
		
		arr.display();
		
		int delete1 = 100;
		if(arr.delete(delete1))
			arr.display();
		else
			System.out.println("Cant find the number to be deleted: "+ delete1);
		
		arr.delete(78);
		
		arr.display();
		
		int searchKey = 90;
		if(arr.find(searchKey))
			System.out.println("Found "+searchKey);
		else
			System.out.println("Cant find "+searchKey);
		
		int delete3 = 91;
		if(arr.delete(delete3))
			arr.display();
		else
			System.out.println("Cant find the number to be deleted: "+ delete3);
		
		arr.display();
		
		arr.getMax();
		arr.display();
	}


}
