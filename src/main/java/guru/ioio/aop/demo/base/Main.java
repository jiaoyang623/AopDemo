package guru.ioio.aop.demo.base;

import guru.ioio.aop.demo.base.bean.SimpleBean;

public class Main {
    public static void main(String[] args) {
        SimpleBean bean = new SimpleBean();
        bean.name = "hugo";
        bean.id = 7;

        bean.process();
        System.out.println("start from here " + bean);
    }
}
