package cnn.whoops.string;

/**
 * @author: whoops
 * @date: 2021/7/26 - 14:45
 * @description:
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str); // good,String不可变性
        System.out.println(ex.ch); // best
    }
}
