package array;

/**
 *  Wayfair possible questions
 */
public class rearrangPositveAndNegtive {

    public static int[] reaggange(int[] input){
        int pointer1 = 0 , pointer2 = 0;

        for(pointer1 = 0 ; pointer1 < input.length ; pointer1++ ){
            if(input[pointer1] < 0 ){
                if(pointer1 != pointer2){
                    int temp = input[pointer2];
                    input[pointer2] = input[pointer1];
                    input[pointer1] = temp;
                }
                pointer2++;
            }
        }
       return input;
    }

    static int[] RearrangePosNegInorder(int arr[])
    {
        int key, j;
        for(int i = 0; i < arr.length; i++)
        {
            key = arr[i];

            // if current element is positive
            // do nothing
            if (key > 0)
                continue;

            /* if current element is negative,
            shift positive elements of arr[0..i-1],
            to one position to their right */
            j = i - 1;
            while (j >= 0 && arr[j] > 0)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Put negative element at its right position
            arr[j + 1] = key;
        }
        return arr;
    }


    public static void main(String[] args){
        int[] input = new int[]{1,-2,-3,4,5,-3};
        for( int i : RearrangePosNegInorder(input)){
            System.out.print(i);
        }
    }

}
