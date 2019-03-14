public class 九宫格 {
    public static void main(String[] args) {
        int sum=0;
        for(int a=0; a<=9; a++)
            for(int b=0; b<=9; b++)
            {
                if(Math.abs(b-a)==1) continue;
                for(int c=0; c<=9; c++)
                {
                    if(Math.abs(c-b)==1) continue;
                    for(int d=0; d<=9; d++)
                    {
                        if(Math.abs(d-a)==1) continue;
                        for(int e=0; e<=9; e++)
                        {
                            if(Math.abs(e-a)==1||Math.abs(e-b)==1||Math.abs(e-d)==1) continue;
                            for(int f=0; f<=9; f++)
                            {
                                if(Math.abs(f-a)==1||Math.abs(f-b)==1||Math.abs(f-c)==1||Math.abs(f-e)==1) continue;
                                for(int g=0; g<=9; g++)
                                {
                                    if(Math.abs(g-b)==1||Math.abs(g-c)==1||Math.abs(g-f)==1) continue;
                                    for(int h=0; h<=9; h++)
                                    {
                                        if(Math.abs(h-d)==1||Math.abs(h-e)==1) continue;
                                        for(int i=0; i<=9; i++)
                                        {
                                            if(Math.abs(i-d)==1||Math.abs(i-e)==1||Math.abs(i-f)==1||Math.abs(i-h)==1) continue;
                                            for(int j=0; j<=9; j++)
                                            {
                                                if(Math.abs(j-e)==1||Math.abs(j-f)==1||Math.abs(j-g)==1||Math.abs(j-i)==1) continue;
                                                sum++;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        System.out.println("sum = " + sum);
    }

   
}
