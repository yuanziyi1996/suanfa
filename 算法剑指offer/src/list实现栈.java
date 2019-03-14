import java.util.LinkedList;

public class list实现栈 {
    public static void main(String[] args) {
        Tools tools = new Tools();
        tools.add("a");
        tools.add("b");
        tools.add("c");
        tools.add("d");
        tools.add("e");
        tools.add("f");
        tools.add("g");
        tools.add("h");
        tools.add("i");
        tools.add("j");

        tools.romove();
    }
}
class Tools{
    private LinkedList<String> ll;
    public Tools(){
        ll = new LinkedList<String>();
    }

    public void add(String str){
        ll.addFirst(str);//每加入一个就放到第一个，name他出来的时候就是第一个了呗
    }

    public void romove(){
        for(int i=0;i<ll.size();i++){
            String content = ll.get(i);
            System.out.println(content);
        }
    }

}