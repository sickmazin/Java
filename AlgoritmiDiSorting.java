import java.util.Arrays;
/**
 * Classe che fornisce i metodi di ordinamento
 * merge sort
 * e quick sort
 */
public class AlgoritmiDiSorting {
	/**
	 * Implementa il metodo merge sort per ordinare in senso crescente un array di interi
	 * @param v Il vettore da ordinare
	 * @param low L'estremo sinistro del range di v da ordinare
	 * @param high L'estremo destro del range di v da ordinare
	*/ 
	public static void mergeSort(int[] v, int low, int high)
	{
		System.out.println("Chiamata di mergeSort sull'intervallo "+low+".."+high);
	
		if (high<=low)
			return;
		
		
		int mid=(low+high)/2;
		mergeSort(v,low,mid);
		mergeSort(v, mid+1,high);
		merge(v,low,mid,high);
	}
	
	/**
	 * Implementa la fusione ordinata di due porzioni di array già ordinate
	 * @param v Il vettore contenente le sequenze ordinate da fondere
	 * @param low L'estremo sinistro del sottoarray sinistro 
	 * @param mid L'estremo destro del sottoarray sinistro 
	 *            (mid+1 è invece l'estremo sinistro del sottoarray destro)
	 * @param high L'estremo destro del sottoarray destro)
	*/ 
	static void merge (int [] v, int low, int mid, int high)
	{
		// Creo due sottoarray temporanei
		int[] leftArray= new int[mid-low+1];
		int[] rightArray= new int[high-mid];
		
		// Copio le due porzioni di v sugli array temporanei
		for (int i=0; i<leftArray.length;i++)
			leftArray[i]=v[low+i];
		for (int i=0; i<rightArray.length;i++)
			rightArray[i]=v[mid+1+i];
		
		//Creo i due iteratori con i quali scandirò leftArray e rightArray
		int leftIndex=0;
		int rightIndex=0;
		
		// Eseguo il merge vero e proprio:
		// Copio in modo ordinato leftArray e rightArray su v nel range low..high
		for (int i=low; i<=high; i++)
		{
			// Esistono ancora elementi non ricopiati in v sia in leftArray che in rightArray
			if (leftIndex<leftArray.length && rightIndex<rightArray.length)
				if (leftArray[leftIndex]<rightArray[rightIndex])
				{
					v[i]=leftArray[leftIndex];
					leftIndex++;
				}
				else
				{
					v[i]=rightArray[rightIndex];
					rightIndex++;
				}	
			else
				if (leftIndex<leftArray.length)
				{
					v[i]=leftArray[leftIndex];
					leftIndex++;
				}
				else
					if (rightIndex<rightArray.length)
					{
						v[i]=rightArray[rightIndex];
						rightIndex++;
					}
		}
	}
	

	
	/**
	 * Effettua la partizione di una porzione dell'array, spostando sulla sinistra gli elementi minori o uguali 
	 * del valore pivot, e sulla destra gli elementi maggiori o uguali al valore del pivot.
	 * Utilizza come pivot il valore in posizione mediana della porzione passata come input. 
	 * @param arr L'array contenente il sottoarray da partizionare
	 * @param left L'estremo sinistro del sottoarray 
	 * @param right L'estremo destro del sottoarray 
	 * @return La posizione assunta dal valore pivot a termine del partizionamento 
	 *         (gli elementi a sinistra saranno tutti minori o uguali ad esso, 
	 *         e gli elementi a destra saranno tutti maggiori o uguali ad esso)
	*/ 
	static int partition(int arr[], int left, int right)

	{

	      int i = left, j = right;
	      int tmp;

	      int pivot = arr[(left + right) / 2];

	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };

	     return i;

	}

	
	/**
	 * Implementa il metodo quick sort per ordinare in senso crescente un array di interi
	 * @param v Il vettore da ordinare
	 * @param low L'estremo sinistro del range di v da ordinare
	 * @param high L'estremo destro del range di v da ordinare
	*/ 

	public static void quickSort(int[] v, int low, int high) {

	      int index = partition(v,low,high);

	      if (low < index - 1)

	            quickSort(v,low, index - 1);

	      if (index < high)

	            quickSort(v, index, high);

	}
	
	public static void main(String[] args) {

		int[] v= {4,1,9,6,0,3,5,8, 9};
		System.out.println(Arrays.toString(v));
	
		quickSort(v,0,v.length-1);
		System.out.println(Arrays.toString(v));
		
	}
}	