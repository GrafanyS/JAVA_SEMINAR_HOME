public class Worker {

  int age;
  int salary;
  String fullName;
  String jobTitle;
  String address;

  public void print() {
    System.out.println(
        String.format(
            "%d %d %s %s %s",
            this.age,
            this.salary,
            this.fullName,
            this.address,
            this.jobTitle));
  }
}
