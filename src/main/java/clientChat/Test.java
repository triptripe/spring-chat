package clientChat;

import javax.persistence.*;

/**
 * Created by user on 11.05.2018.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int a;

    private ArrayThings arr;

    public Test() {
    }

    public Test(int a) {
        this.a = a;
    }

    public ArrayThings getArr() {
        return arr;
    }

    public void setArr(ArrayThings arr) {
        this.arr = arr;
    }

    public int getA() {
        return a;
    }

}
