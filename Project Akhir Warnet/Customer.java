public class Customer<T> {

  private T name;
  private int age;
  private String laptopNumber;

  public Customer(T name, int age, String laptopNumber) {
      this.name = name;
      this.age = age;
      this.laptopNumber = laptopNumber;
  }

  public T getName() {
      return name;
  }

  public int getAge() {
      return age;
  }

  public String getLaptopNumber() {
      return laptopNumber;
  }
}
