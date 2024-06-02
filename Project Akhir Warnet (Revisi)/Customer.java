public class Customer<T>{

  private T name;
  private int age;


  public Customer(T name, int age) {
      this.name = name;
      this.age = age;
  }

  public T getName() {
      return name;
  }

  public int getAge() {
      return age;
  }
}
