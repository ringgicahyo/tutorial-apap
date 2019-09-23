# Tutorial APAP

## Authors

* **ringgi.cahyo** - *1706025005* - *B*

---
## Tutorial 1
### What I have learned today
#### Github
1. ***Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?***

    _Issue Tracker_ adalah sebuah alat pelacak isu/masalah, dalam hal ini kita dapat mencatat masalah-masalah apa saja yang sedang dialami oleh sebuah tim. Issue tracker juga dapat berfungsi untuk merencanakan sebuah pekerjaan yang nantinya akan diselesaikan. Dengan begitu, masalah dan perubahan permintaan yang ada dapat dilacak atau diketahui.

    Masalah-masalah yang dapat di-_track_ antara lain:
    - Membahas implementasi ide baru
    - Melacak tugas dan status pekerjaan
    - Menerima proposal fitur baru, pertanyaan, permintaan dukungan, dan laporan bug
    - Mengelaborasi implementasi kode yang baru

2. ***Apa perbedaan dari git merge dan merge --squash?***

    _Squash merge_ adalah sebuah pilihan _merge_ yang disediakan oleh _git_ yang hanya akan menghasilkan sebuah _merge commit_ dengan satu _parent_, di saat _normal merge_ akan menghasilkan dua _parent_. _File_ tetap akan digabungkan seperti halnya saat melakukan _normal merge_, bedanya terletak pada _commit metadata_ yang diubah untuk menunjukkan bahwa hanya ada satu _parent commit_. Hasilnya adalah _commit_ tunggal pada _branch target_ dengan semua perubahan dari _normal merge_. Sederhananya, _squash merge_ menghasilkan _history_ yang lebih bersih dari pada _normal merge_.

    Contohnya, kita memiliki repository dengan _master branch_ dan _topic branch_.
    ![alt text](https://devblogs.microsoft.com/devops/wp-content/uploads/sites/6/2016/03/Branches-topic-master.png)

    Gambar di bawah ini menunjukkan jika kita melakukan _normal merge_, maka akan menciptakan dua _commit parent_.
    ![alt text](https://devblogs.microsoft.com/devops/wp-content/uploads/sites/6/2016/03/regular-merge.png)

    Sedangkan, gambar di bawah ini menunjukkan saat kita melakukan _squash merge_, maka hanya akan menghasilkan satu _commit parent_.
    ![alt text](https://devblogs.microsoft.com/devops/wp-content/uploads/sites/6/2016/03/squash-merge.png)

#### Spring
3. ***Apa itu library & dependency?***

    _library_ adalah sekumpulan potongan kode terkait yang telah di-_compile_ dan disimpan bersama dalam satu file. File itu dapat ditautkan dengan kode kita untuk memberi kita akses ke kode di _library_ tersebut.

    _Dependency_ adalah ketika suatu aplikasi tidak hanya terdiri dari satu objek. Bahkan aplikasi yang paling sederhana memiliki beberapa objek yang bekerja bersama untuk menyajikan apa yang dilihat _end-user_ sebagai aplikasi yang koheren.

4. ***Apa itu Maven? Mengapa kita perlu menggunakan Maven?***

    Maven adalah alat manajemen proyek yang menangani pembangunan proyek, dependensi, distribusi, perilisan, dan lain-lain menggunakan Java. Di sini, pembuatan perangkat lunak mengacu pada proses dimana _source code_ dikonversi menjadi bentuk yang berdiri sendiri dan dapat dijalankan oleh komputer. Maven menggunakan file XML untuk menggambarkan proyek yang dibangun.

    Kita perlu menggunakan Maven karena hal berikut.
    
    - Maven dapat mengelola '_a complete project life-cycle_', misalnya: _Code compilation > Unit testing > Build generation (jar and war files)_
    - Mudah mengelola dependensi eksternal untuk proyek berbasis Java dan menjaga proyek Java tetap ringan
    - Manajemen proyek multi-level, yaitu berbagi fungsionalitas satu proyek dengan beberapa proyek lainnya menggunakan manajemen dependensi

5. ***Apa alternatif dari Maven?***

    Selain Maven, kita dapat menggunakan alternatif lain seperti Gradle. Gradle adalah sistem otomasi _build_ yang sepenuhnya _open source_ dan menggunakan konsep yang kita lihat di Apache Maven dan Apache Ant. Ini menggunakan bahasa _domain-specific_ berdasarkan bahasa pemrograman Groovy, membedakannya dari Apache Maven, yang menggunakan XML untuk konfigurasi proyeknya. Ini juga menentukan urutan tugas yang dijalankan dengan menggunakan grafik asiklik terarah.
    Singkatnya, perbedaan utama antara Maven dan Gradle adalah bahwa Maven adalah alat manajemen proyek dan pemahaman perangkat lunak yang mengelola pembuatan, laporan, dan dokumen proyek, sementara Gradle adalah alat otomatisasi _open source build_ yang berfokus pada fleksibilitas dan kinerja.

### What I did not understand
- [x] Mengapa saya harus belajar APAP?

        Menurut saya, karena APAP sangat penting bagi mahasiswa yang ingin merancang sebuah sistem informasi, dimana pada mata kuliah ini kita dituntut untuk dapat mengerti bagaimana arsitektur perangkat lunak yang baik seharusnya dan bagaimana cara melakukan praktik pemrogramannya.
        
- [ ] Mengapa saya harus menggunakan Spring?

---

## Tutorial 2
### What I have learned today
1. ***Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:***
    http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022

    ***Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.***
    
    Yang terjadi adalah error karena template _view_ "add-restoran" pada _controller_ sebagai file untuk dirender belum ada atau belum dibuat.

2. ***Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:***
    http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
    
    ***Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.***
    
    Error terjadi karena parameter yang dibutuhkan tidak lengkap, ada kekurangan pada bagian nomorTelepon yang tidak ada, sementara _required_ untuk parameter tersebut adalah _true_ alias harus diisi.

3.  ***Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?***
    
    Karena Papa APAP tidak mengetahui atribut lain selain nama restoran, seperti idRestoran, alamat, dan nomorTelepon, maka Papa APAP perlu mengakses link http://localhost:8080/restoran/viewall terlebih dahulu untuk mencari informasi atribut tersebut. Setelah itu baru Papa APAP dapat mengakses link view dengan memasukkan atribut yang sudah diketahui: http://localhost:8080/restoran/view?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022

4. ***Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.***

    http://localhost:8080/restoran/add?idRestoran=3&nama=FilosoMi&alamat=Kukusan%20Kelurahan&nomorTelepon=19450

    ![alt text](https://i.ibb.co/p4nGkcK/addresto.jpg)
    ![alt text](https://i.ibb.co/qWbszqb/viewallresto.jpg)

### What I did not understand
- [ ] Bagaimana cara menggunakan Spring Annotation saat mapping error request?