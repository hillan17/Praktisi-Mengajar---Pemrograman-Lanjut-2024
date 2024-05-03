public class GenericCustomer<T> {
  private T id;
  private String name;

  public GenericCustomer(T id, String name){
    this.id = id;
    this.name = name;
  }

  public T getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public void displayCustomer(){
    System.out.println("----------------------------");
    System.out.println("Berhasil Membuat Customer!");
    System.out.println("ID: " + getId());
    System.out.println("Nama: " + getName());
    System.out.println("----------------------------");
  }
}
