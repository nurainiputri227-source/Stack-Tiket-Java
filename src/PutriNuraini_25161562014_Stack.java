public class PutriNuraini_25161562014_Stack {

    // === BAGIAN 1: DEKLARASI STACK ===
    // Array untuk menyimpan data tiket
    static String[] stack = new String[10];
    static int top = -1;


    // === BAGIAN 2: OPERASI STACK ===
    // Method Push()
    // __menambahkan tiket ke posisi paling atas
    static void push(String tiket) {

        // Jika stack penuh
        if (top == stack.length - 1) {
            System.out.println("Stack Penuh");
            return;
        }
        // Menambahkan data ke stack
        top++;
        stack[top] = tiket;
    }

    // Method Pop()
    // __mengambil dan menghapus data paling atas
    static String pop() {
        // Jika stack kosong
        if (isEmpty()) {
            return "Stack kosong";
        }
        String data = stack[top];
        stack[top] = null;
        top--;
        return data;
    }

    // Method Peek()
    // __melihat data paling atas tanpa menghapus
    static String peek() {
        if (isEmpty()) {
            return "Stack kosong";
        }
        return stack[top];
    }

    // Method isEmpty()
    // __mengecek apakah stack kosong
    static boolean isEmpty() {
        return top == -1;
    }

    // Method tampilkanStack()
    // __menampilkan isi stack
    static void tampilkanStack() {
        System.out.println("=== Isi Stack (TOP -> BOTTOM) ===");
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
        System.out.println("=================================");
    }


    // === BONUS: Method hitungTotal() ===
    // Menjumlahkan semua harga tiket
    static void hitungTotal() {
        int total = 0;
        for (int i = 0; i <= top; i++) {
            String[] bagian = stack[i].split("Rp");
            String harga = bagian[1].replace(".", "").trim();
            total += Integer.parseInt(harga);
        }
        System.out.println("Total transaksi: Rp" +
                String.format("%,d", total).replace(",", "."));
    }


    // === BAGIAN 3: MAIN PROGRAM ===
    public static void main(String[] args) {

        // Push data tiket
        push("Tiket-A01: Avengers Rp50.000");
        push("Tiket-B02: Interstellar Rp45.000");
        push("Tiket-C03: Inception Rp45.000");

        // Menampilkan isi stack
        tampilkanStack();

        // Menampilkan tiket paling atas (peek)
        System.out.println("Tiket terakhir masuk: " + peek());

        //BONUS: Hitung Total Transaksi
        // Menampilkan total transaksi
        hitungTotal();

        // Menghapus tiket paling atas (pop)
        System.out.println("Tiket dibatalkan: " + pop());

        // Menampilkan stack setelah pop
        tampilkanStack();
    }
}