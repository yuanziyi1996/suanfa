public class 丑数 {
    //判断是不是丑数
    public static boolean isUglyNumber(int num){

        if(num==1)
            return true;
        if(num%2==0){
            return isUglyNumber(num/2);
        }
        if(num%3==0){
            return isUglyNumber(num/3);
        }
        if(num%5==0){
            return isUglyNumber(num/5);
        }

        return false;
    }

    //求第几个丑数
    public static int GetUglyNumber_Solution(int index) {
        int m=1;
        int j=1;
        int i=1;
        for(i=2;j<index;i++){
            m=i;
            while(m%2==0){
                m=m/2;
            }

            while(m%3==0){
                m=m/3;
            }

            while(m%5==0){
                m=m/5;
            }

            if(m==1){
                j++;
            }

        }
        return i-1;
    }
    public static void main(String[] args) {

        //System.out.println(isUglyNumber(1));
        long start = System.currentTimeMillis();
        System.out.println(GetUglyNumber_Solution(8));
        System.out.println(System.currentTimeMillis()-start);
    }

}
