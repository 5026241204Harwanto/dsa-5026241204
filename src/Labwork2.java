import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Labwork2 {
    public static void main(String[] args) throws Exception {

        // Book stock
        HashMap<String, Integer> bookStock = new HashMap<>();

        bookStock.put("Kalkulus", 2);
        bookStock.put("Fisika", 1);
        bookStock.put("Statistika", 2);


        // Member status
        // Menyimpan jumlah buku yang sedang dipinjam
        HashMap<String, Integer> memberStatus = new HashMap<>();

        memberStatus.put("Farel", 0);
        memberStatus.put("Taqiy", 0);
        memberStatus.put("Michelle", 0);
        memberStatus.put("Raissa", 0);


        // Request list
        ArrayList<String> requests = new ArrayList<>();

        requests.add("Farel Kalkulus");
        requests.add("Farel Fisika");
        requests.add("Farel Statistika");
        requests.add("Taqiy Statistika");
        requests.add("Michelle Fisika");
        requests.add("Taqiy Kalkulus");
        requests.add("Michelle Statistika");
        requests.add("Raissa Statistika");


        // Menyimpan request yang berhasil
        ArrayList<String> successfullRequests = new ArrayList<>();

        // Menyimpan request yang gagal
        HashSet<String> failedRequests = new HashSet<>();


        // Memproses setiap request
        for (String request : requests) {
            String[] parts = request.split(" ");
            String member = parts[0];
            String book = parts[1];

            // Take the current stock of the book
            int stock = bookStock.get(book);
            // Take the current number of books borrowed by the member
            int borrowed = memberStatus.get(member);


            // Cek apakah buku masih tersedia
            // dan member belum mencapai batas 2 buku
            if (stock > 0 && borrowed < 2) {

                // Kurangi stok buku
                bookStock.put(book, stock - 1);

                // Tambah jumlah buku yang dipinjam member
                memberStatus.put(member, borrowed + 1);

                // Masukkan ke successful requests
                successfullRequests.add(request);

            } else {

                // Request gagal
                failedRequests.add(request);
            }
        }


        // ============================
        // PROGRAM OUTPUT
        // ============================

        System.out.println("=== Successfully Processed Requests ===");

        for (String request : successfullRequests) {
            System.out.println(request);
        }


        System.out.println();
        System.out.println("=== Remaining Book Stock ===");

        System.out.println("Kalkulus : " + bookStock.get("Kalkulus"));
        System.out.println("Fisika : " + bookStock.get("Fisika"));
        System.out.println("Statistika : " + bookStock.get("Statistika"));


        System.out.println();
        System.out.println("=== Failed Requests ===");

        for (String request : failedRequests) {
            System.out.println(request);
        }
    }
}
        
    


