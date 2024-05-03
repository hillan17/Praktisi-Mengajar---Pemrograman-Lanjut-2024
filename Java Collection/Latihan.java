 import java.util.*;

 public class Latihan {
    public static void main(String[] args) {
        //ITERABLE
        /* Iterable<String> fruits = List.of("Grapes", "Cherry");

        for (var name: fruits) {
            System.out.println(name);
        } */

        //ITERATOR
        /* Iterable<Integer> numbers = List.of(1, 7);
        Iterator<Integer> iterator = numbers.iterator();

        while(iterator.hasNext()) {
            int name = iterator.next();
            System.out.println(name);
        } */

        //COLLECTION
        /* Collection<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Cherry");

        fruits.remove("Banana");

        System.out.println(fruits.contains("Orange"));

        for(var name: fruits) {
            System.out.println(name);
        } */

        //LIST
        /* List<String> fruits = new LinkedList<>();

        fruits.add("Melon");
        fruits.add("Melon");

        System.out.println(fruits); */

        //LINKEDLIST
        /* LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Mango");

        for (String fruit : linkedList) {
              System.out.println(fruit);
        } */

        //QUEUE
        /* Queue<String> queues = new ArrayDeque<>(10);
        queues.offer("Orange");
        queues.offer("Grapes");

        for(String next = queues.poll(); next != null; next = queues.poll()) {
            System.out.println(next);
        }

        System.out.println(queues.size()); */

        //DEQUEUE
        Deque<String> stack = new LinkedList<>();

        stack.offerLast("Melon");
        stack.offerLast("Water");

        for(var item = stack.pollLast(); item != null; item =stack.pollLast()) {
            System.out.println(item);
        } 

        //HASHMAP
        /* Map<String, String> map = new HashMap<>();
        map.put("firstFruit", "Orange");

        System.out.println(map.get("firstFruit")); */
    }
}



       