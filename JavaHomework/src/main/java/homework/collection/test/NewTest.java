package homework.collection.test;
import java.util.LinkedList;



public class NewTest {


        public static void main(String[] args) {
            // Khởi tạo LinkedList
            LinkedList<String> linkedList = new LinkedList<>();

            // Thêm phần tử vào danh sách
            linkedList.add("Apple");
            linkedList.add("Banana");
            linkedList.add("Cherry");

            System.out.println("Danh sách ban đầu: " + linkedList);

            // Thêm vào vị trí index cụ thể
            linkedList.add(1, "Orange");  // Thêm "Orange" vào vị trí thứ 1

            System.out.println("Danh sách sau khi thêm vào index 1: " + linkedList);

            // Xóa phần tử theo index
            linkedList.remove(2);  // Xóa phần tử tại index 2 (Banana)

            System.out.println("Danh sách sau khi xóa phần tử ở index 2: " + linkedList);
        }

}
