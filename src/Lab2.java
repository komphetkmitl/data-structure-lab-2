import java.util.Arrays;

public class Lab2 {
    static int N = 5;
    static int data[] = new int[N];
    static int size = 0;

    public static void add(int d) {
        if (isFull()) expand();
        data[size++] = d;
    }

    public static void insert(int d, int index) {
        for (int i = size++; i > index; i--) data[i] = data[i - 1];
        data[index] = d;
    }

    public static int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) return i;
        }
        return -1;
    }

    public static int binarySearch(int d) {
        int a = 0;
        int b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d) return m;
            if (d < data[m]) b = m - 1;
            else a = m + 1;
        }
        return -1;
    }

    public static void delete(int index) {
        data[index] = data[--size];
    }

    public static void ordinalDelete(int index) {
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
            size--;
        }
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static boolean isFull() {
        return size == N;
    }

    public static void expand() {
        int M = N * 2;
        int temp[] = new int[M];
        for (int i = 0; i < size; i++) temp[i] = data[i];
        data = temp;
        N = M;
        System.gc();
    }

    public static String printArray()
    {
        String str = "";
        for (int i = 0 ; i < size ; i++) {
            str += (data[i]);
            if (i != size-1) str += (",");
        }
        return str;
    }

    public static void main(String Args[]) {
        System.out.println("New Array N = 5: " + Arrays.toString(data));
        for (int i = 0; i < 4; i++) add(i+5);
        System.out.println("Add 5-8: " + printArray());
        insert(22, 4);
        System.out.println("Insert 22 index 4: " + printArray());
        for (int i = 0; i < 30; i++) add(i+90);
        System.out.println("Add 22 When Array Full: " + printArray());
        System.out.println("Find 5: Index is "+find(5)+" Value is "+data[find(5)]);
        System.out.println("binarySearch 6: Index is "+binarySearch(6)+" Value is "+data[binarySearch(6)]);
        delete(9);
        System.out.println("Delete Index 9: "+printArray());
        ordinalDelete(10);
        System.out.println("Delete Index 10: "+printArray());

    }
}
