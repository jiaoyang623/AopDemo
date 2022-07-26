package guru.ioio.aop.demo.base.bean;

public class SimpleBean {
    public int id;
    public String name;

    public void process() {
        System.out.println("process");
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
