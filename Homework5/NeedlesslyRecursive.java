import java.math.BigInteger;

// These methods would not be ordinarily be written recursively, but we are writing them in this program for practice. 

public interface NeedlesslyRecursive{
    public static BigInteger a(BigInteger x, BigInteger y){
        if (x == null || (x.compareTo(BigInteger.ZERO) < 0 || (y == null || (y.compareTo(BigInteger.ZERO) < 0)))){
            throw new IllegalArgumentException(); 
        }
        else if(x.equals(BigInteger.ZERO) && y.compareTo(BigInteger.ZERO) >= 0){
            return y.add(BigInteger.ONE); 
        }
        else if (x.compareTo(BigInteger.ZERO) > 0 && y.equals(BigInteger.ZERO)){
            return a(x.subtract(BigInteger.ONE), BigInteger.ONE);
        }
        else if (x.compareTo(BigInteger.ZERO) > 0 && y.compareTo(BigInteger.ZERO) > 0){
            return a(x.subtract(BigInteger.ONE),a(x,y.subtract(BigInteger.ONE)));
        }
        return BigInteger.ZERO;
    }

    public static String binaryString(int x){ 
        if(x == 0){
            return "0";
        }
        else if (x == 1){
            return "1"; 
        }
        else if(x == -1){
            return "-1"; 
        }
        else if(x >= 0){
           if(x % 2 == 0){
            return binaryString(x/2)+ "0";
           }
           else if (x % 2 != 0){
            return binaryString(x/2) + "1"; 
           }
        }
        else if (x < 0){
            if(x % 2 == 0){
            return binaryString(x/2)+ "0";
           }
           else if (x % 2 != 0){
            return binaryString(x/2) + "1"; 
           }
        }
        return "0"; 
    }

    public static int log3(int n){
       if(n < 3){
        return 0;
       }
       else{
        return log3(n / 3) + 1; 
       }
    }

    public static BigInteger power(BigInteger x, int n){
        if(n==0){
            return BigInteger.ONE; 
        }

        BigInteger result = power(x, n/2);

        if(n % 2 == 0){
            return result.multiply(result);
        }
        else{
            return x.multiply(result).multiply(result);
        }
    }
}
