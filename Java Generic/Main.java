public class Main {
  public static void main(String[] args) {
    GenericCustomer<Integer> customer1 = new GenericCustomer<>(75362474, "John Doe");
    customer1.displayCustomer();

    GenericCustomer<String> customer2 = new GenericCustomer<>("1COO2023", "Jane Smith");
    customer2.displayCustomer();
  }
}
