// import java.util.Random;

class Goods {

  public int count;
  public String name;
  public double price;
  public StringBuilder description;

  // 2^n = 16;
  //

  class ProxyName {
    String val;

    public ProxyName(String v) {
      this.val = v != null ? v : "EMPTY";

      if (v != null)
        this.val = v;
      else
        this.val = "EMPTY";
    }

    public String getVal() {
      return val;
    }
  }

  public Goods(String name) {
    this.name = new ProxyName(new ProxyName(name).getVal()).getVal();
  }

  public Goods(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public Goods(int count, String name) {
    this.count = count;
    this.name = name;
  }

  public Goods(int count, String name, double price) {
    this.count = count;
    this.name = name;
    this.price = price;
  }
}

public class app {
  public static void main(String[] args) {
    Worker currentWorker = new Worker();
    currentWorker.print();

    currentWorker = new CreateWorker()
        // .setAddress("Красная площадь")
        .setAge(33)
        .setFullName(null)
        // .setJobTitle("Политик")
        .setSalary(0)
        .Create();

    currentWorker.print();
    String sb = new StringBuilder()
        .append("1231")
        .append("1231")
        .append("1231")
        .append("1231")
        .toString();

    System.out.println(sb);
    // currentWorker.address = "Красная площадь";
    // currentWorker.age = 56;
    // currentWorker.salary = 0;
    // currentWorker.jobTitle = ;
    // currentWorker.fullName = "Владимир Ильич";

    // String rs = toString(new int[] { 1, 3, 12, 3, 14, 123, 13, });

    // dry

  }

}
