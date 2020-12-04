import java.math.BigInteger;

public class 权限加密 {
    public static void main(String[] args) {
        int [] rights =new int [10];
        for(int i=0;i<rights.length;i++) {
            rights[i] = i + 1;
        }
        System.out.println(sumRights(rights));


}
    public static BigInteger sumRights(int[] rights){
        BigInteger num = new BigInteger("0");
        for(int i=0; i<rights.length; i++){
            num = num.setBit(rights[i]);
        }
        return num;
    }

}
