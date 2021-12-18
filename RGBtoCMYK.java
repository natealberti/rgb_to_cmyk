import java.util.Arrays;
import java.util.List;

public class RGBtoCMYK {
    
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        String input = "";
        System.out.println(input);
        convert(input);
    }
    
    public static void convert(String input) {
        // parsing
        int[] parse = parseIntoNums(input);
        
        // converting
        int[] cmyk = RGBToCMYK(parse);
        
        // outputting
        System.out.print(cmyk[0] + "," + cmyk[1] + "," + cmyk[2] + "," + cmyk[3]);
    }
    
    // parsing string input into array of ints
    // working
    public static int[] parseIntoNums(String input) {
        // taking string into array of strings
        String[] arrayStrings = input.split(",");
        
        //creating array of nums from that
        int[] arrayInts = new int[3];
        for(int i = 0; i < 3; i++) {
            arrayInts[i] = Integer.parseInt(arrayStrings[i]);
        }
        
        return arrayInts;
    }
    
    // takes the rgb array of ints
    public static int[] RGBToCMYK(int[] input) {
        // dividing by 255 to get range from 0 to 1
        float[] primes = new float[3];
        for(int i = 0; i < 3; i++) {
            primes[i] = (float)input[i]/255;
        }
        
        // finding the C M Y K values from the primes and the input
        // indexes: R = 0; G = 1; B = 2
        float k = 1 - (Math.max(Math.max(primes[0], primes[1]), primes[2]));
        int c = Math.round((float)(1 - primes[0] - k)/(1 - k));
        int m = Math.round((float)(1 - primes[1] - k)/(1 - k));
        int y = Math.round((float)(1 - primes[2] - k)/(1 - k));
    
        // loading them into an array
        int[] cmyk = new int[4];
        cmyk[0] = c;
        cmyk[1] = m;
        cmyk[2] = y;
        cmyk[3] = Math.round(k);
        
        
        return cmyk;
        
    }
    
}
