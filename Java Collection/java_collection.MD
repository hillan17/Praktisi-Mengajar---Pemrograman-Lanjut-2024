# **JAVA COLLECTION**

Collection atau kadang disebut **container**, adalah object yang mengumpulkan atau berisikan data-data, mirip seperti Array. Semua class-class collection di java adalah **generic class**, sehingga kita bisa menggunakan Java collection dengan data apapun. Java collection telah menyediakan semua yang berhubungan dengan collection, seperti berikut ini:

- Interfaces
- Implementations
- Algorithms

### 1. Iterable Interface

Iterable adalah parent untuk semua collection di Java, kecuali Map, dan hanya digunakan agar mendukung for-each loop.

Kode Iterable:

```java
public static void main(String[] args) {
  Iterable<String> names = List.of("Gibranda");

  for (var name: names) {
    System.out.println(name);
  }
}
```

_Dengan Java 5 sudah bisa menggunakan for each, versi sebelumnya masih menggunakan iterator_

### 2. Iterator Interface

For-each di iterable bisa terjadi karena ada method iterator() yang mengembalikan object Iterator. Iterator adalah interface yang mendefinisikan cara kita mengakses element di collection secara sequential.

Kode Iterator:

```java
Iterator<String> iterator = names.iterator();

while(iterator.hasNext()) {
  String name = iterator.next();
  System.out.println(name);
}
```

### 3. Collection Interface

Collection adalah parent class semua collection selain Iterable interface di Java. Collection merupakan kontrak untuk memanipulasi data collection, seperti menambah, menghapus dan mengecek isi data collection. Collection dibagi menjadi List, Set dan Queue.

Menambah, menghapus, dan mengecek data di Collection:

```java
public static void main(String[] args) {
  Collection<String> names = new ArrayList<>();
  names.add("Gibranda");
  names.add("Kurniawan");
  names.addAll(Arrays.asList("Setiawan", "Bagas"));

  names.remove("Gibranda");

  System.out.println(names.contains("Gibranda"));

  for(var name: names) {
    System.out.println(name);
  }
}
```

### 4. List Interface

List adalah struktur data collection yang memiliki sifat, antara lain:

- Element di list bisa duplikat
- Data list berurut sesuai dengan posisi kita memasukkannya
- List memiliki index

#### **ArrayList Class vs LinkedList Class**

ArrayList adalah implementasi List menggunakan array dengan default kapasitas array adalah 10. Ketika kita memasukkan data dan array sudah penuh, maka secara otomatis akan membuat array baru dengan ukuran kapasitas lama + data baru.

LinkedList adalah implementasi List dengan struktur data Double Linked List.

| Operasi | ArrayList | LinkedList |
| ------- | --------- | ---------- |
| add     | Cpt-Lmbt  | Cepat      |
| get     | Cepat     | Lambat     |
| set     | Cepat     | Lambat     |
| remove  | Lambat    | Cepat      |

Kode List:

```java
public static void main(String[] args) {
  //List<String> names = new ArrayList<>();
  List<String> names = new LinkedList<>();

  names.add("Gibranda");

  System.out.println(names);
}
```

### 5. Queue Interface

Queue adalah implementasi dari struktur data Antrian atau _First In First Out_.

#### **Array Dequeue vs LinkedList vs Priority Queue**

- ArrayDeque menggunakan array
- LinkedList menggunakan double Linked List
- PriorityQueue menggunakan array, namun diurutkan menggunakan Comparable atau Comparator

Kode Queue:

```java
public static void main(String[] args) {
  Queue<String> queues = new ArrayDeque<>(10);
  queues.offer("Gibranda");

  for(String next = queues.poll(); next != null; next = queues.poll()) {
    System.out.println(next);
  }
  System.out.println(queues.size());
}
```

### 6. Dequeue Interface

Deque (Double Ended Queue) adalah queue yang bisa beroperasi dari depan atau belakang. Pada deque, tidak hanya _First In First Out_, namun juga mendukung _Last In First Out_.

Stack menggunakan Dequeue:

```java
public static void main(String[] args) {
  Deque<String> stack = new LinkedList<>();

  stack.offerLast("Gibranda");
  stack.offerLast("Randa");

  for(var item = stack.pollLast(); item != null; item = stack.pollLast()) {
    System.out.println(item);
  }
}
```

### 7. Map Interface

Map adalah struktur data collection yang berisikan mapping antara key dan value. Key di map harus unik, tidak boleh duplikat, dan satu key hanya boleh mapping ke satu Map. Di Map, kita bebas menentukan key sesuai keinginan kita.

#### **HashMap**

HashMap adalah implementasi Map yang melakukan distribusi key menggunakan hashCode() function. HashMap sangat bergantung dengan hashCode() function. Di HashMap pengecekan data duplikat dilakukan dengan menggunakan method equals nya.

Kode HashMap:

```java
public static void main(String[] args) {
  Map<String, String> map = new HashMap<>();
  maap.put("firstName", "Gibranda");

  System.out.println(map.get("firstName"));
}
```
