# Tutorial APAP

## Authors

* **ringgi.cahyo** - *1706025005* - *C*

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

---
## Tutorial 3
### What I have learned today
1. ***Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari method tersebut?***
    
    Kegunaan dari method tersebut adalah untuk mencari daftar menu berdasarkan IdRestoran yang telah diberikan. Dapat dilihat bahwa method tersebut perlu mengembalikan sebuah List yang berisi MenuModel. Method akan mencari restoran yan sesuai IdRestoran-nya, lalu mengembalikan menu list yang dimiliki oleh restoran tersebut.

2. ***Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan addRestoranSubmit?***

    Method addRestoranFormPage digunakan untuk mengembalikan halaman pengisian data restoran baru, sedangkan method addRestoranSubmit digunakan untuk meng-*handle* saat pengguna ingin men-*submit* data tersebut. Pada HTML form-add-restoran, method akan mengambil data yang telah dimasukkan, yang kemudian akan dimasukkan ke dalam database oleh method `addRestoranSubmit`.

3. ***Jelaskan apa kegunaan dari JPA Repository?***

    JPA Repository digunakan untuk memasukkan objek-objek Java ke dalam sebuah *relational database*. Terdapat dua bagian dalam JPA, yaitu sebuah mapping subsystem untuk melakukan mapping antara class-class ke relational table dan juga sebuah API EntityManager untuk mengakses objek-objek, mendefinisikan dan mengeksekusikan *query*, dan masih banyak lagi. Dengan JPA Repository, akan lebih mudah bagi kita untuk mengelola objek-objek Java yang perlu kita masukkan ke dalam database beserta dengan ketentuan-ketentuannya.

4. ***Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan MenuModel dibuat?***

    Pada RestoranModel dan MenuModel, terdapat @OneToMany dan @ManyToOne yang menunjukkan relasi model-model tersebut. @OneToMany yang ada di RestoranModel menunjukkan bahwa satu restoran dapat memiliki banyak menu, dan @ManyToOne yang ada di MenuModel menunjukkan bahwa banyak menu dapat dimiliki satu restoran. Dengan mendefinisikan relasi untuk kedua model ini, database akan lebih mudah dalam mengelola objek-objek yang ada.

5. ***Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER***

    FetchType.LAZY digunakan saat kita hanya ingin melakukan fetch saat kita membutuhkan datanya. Biasanya, FetchType ini digunakan untuk relasi one-to-many atau many-to-many. Sebaliknya, FetchType.EAGER digunakan saat kita ingin data yang akan di-*fetch* sudah ada saat kita membutuhkannya, jadi ia melakukan fetch seawal mungkin. Biasanya, FetchType ini digunakan untuk relasi many-to-one atau one-to-one.

    CascadeType.ALL digunakan agar segala perubahan yang terjadi pada suatu entitas akan terjadi juga pada entitas yang memiliki relasi ini dengannya. Perubahan dapat terjadi karena DELETE, UPDATE, dan sebagainya. Sebagai contoh, ketika kita menghapus suatu restoran, maka semua menu yang terkait dengan restoran tersebut juga dapat dihapus.

### What I did not understand
- [ ] -

---
## Tutorial 4
### What I have learned today
1. ***Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 2.***

    Saya mempelajari banyak hal saat saya mengerjakan latihan nomor 2. Terutama, saya jadi mengetahui bahwa menggunakan *template* Thymeleaf dapat mengimplementasi konsep *dynamic view* pada *website* sehingga akan kode akan lebih mudah di-*maintain* dan menjadi lebih efisien. Tahapannya yaitu:

        - Menambahkan th:text="${pagetitle}" dan menghapus tulisan 'Navbar' pada fragment.html di bagian tag link <a>
        - Menambahkan <nav th:replace="fragments/fragment :: navbar"></nav> pada tiap template html
        - Menambahkan model.addAttribute("pagetitle", "Form Add Menu"); dan yang lainnya pada controller

2. ***Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 3.***
    
    Saya mempelejari scope dari th:object dalam form, penggunaan naming pada params request, dan cara untuk membuat dynamic field. Sebagai menggunakan sumber ini untuk mengerjakan soal nomor 3. Pertama saya mengubah view add form menu yang tadinya menampilkan menu lalu saya ubah menjadi menampilkan listMenu dari restoran sehingga nantinya listMenu tersebut dapat dimanipulasi. Lalu saya membuat looping dan binding pada masing-masing field yang ada dengan cara mengakses listMenu berdasarkan index nya. Setelah itu saya membuat tombol add row, delete row, dan submit dengan link action yang sama, namun mempunyai name yang berbeda, yang nantinya akan menjadi params request di controller. Terakhir, saya mengimplementasi controller sesuai dengan fungsi masing-masing tombol.

3. ***Jelaskan perbedaan th:include dan th:replace.***

    Menurut dokumentasi *thymeleaf.org*, jika kita memiliki situasi seperti berikut:
        
        <div th:include="..."> the content goes here </div>
    
    fragment akan ditempatkan di dalam `<div>` tag.

    Saat kita menggunakan *replace*:

        <div th:replace="..."> the content goes here </div>
    
    maka `<div>` akan digantikan dengan konten yang ada.

    Thymeleaf dapat meng-*include* beberapa bagian dari halaman lain sebagai *fragment* menggunakan *th:include* (akan meng-*include* konten dari fragment ke *host tag*) atau *th:replace* (akan menggantikan *host tag* dengan fragment tersebut).
    
4. ***Jelaskan bagaimana penggunaan th:object beserta tujuannya.***

    Penggunaan *th:object* di dalam implementasi Thymeleaf digunakan untuk menentukan objek mana yang terikat dengan data-data formulir yang dikirimkan. Jadi, hal ini berguna untuk mendeklarasikan objek model yang akan digunakan untuk mengumpulkan data formulir. Misalnya, kita memiliki potongan kode seperti berikut:

        <form th:action="@{/menu/add}" th:object="${menu}" method="POST">
    
    Artinya, pada tag *form* tersebut kita menyisipkan `..th:object="${menu}"..` sebagai tanda bahwa formulir tersebut menggunakan objek **menu** sebagai model untuk pengumpulan data formulirnya.

### What I did not understand
- [ ] -

---
## Tutorial 5
### What I have learned today
1. ***Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and then.***
    
    Bagian given berupa inisiasi dummyStore, men-set attribut-attribut dari dummy tersebut, dan mengatur kembalian database ketika menggunakan service. Bagian when berupa pemanggilan mockMvc.perform(get("/store/view?idStore=1")) yang akan berinteraksi dengan controller langsung dan mengembalikan halaman berdasarkan controller. Bagian and then berupa pemanggilan method .andExpect(...) yang berfungsi untuk melakukan pengecekan interaksi yang diharapkan.
    
2. ***Jelaskan perbedaan line coverage dan logic coverage.***
    
     Line coverage hanya meng-cover kode dengan menghitung jumlah line saja berdasarkan kode yang yang diuji saat testing. Sedangkan logic coverage meng-handle logic code yang berupa branching (seperti if else), sehingga nantinya logic coverage dapat membantu penambahan line coverage secara keseluruhan.
     
3. ***Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin terjadi?***

    Unit test terlebih dahulu baru melakukan implementasi code dari apa yang sudah di test. Hal tersebut dilakukan agar meminimalisir error, serta berfungsi untuk membuat gambaran dan batasan code yang akan diimplementasikan. Jika urutannya dibalik, maka resiko untuk terjadi error meningkat, dan (mungkin) baru diketahui pada saat fase testing, dimana hal tersebut sangat tidak efisien dan memakan waktu.
    
4. [Bonus] ***Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari perhitungan code coverage?***

    Karena main class method merupakan class yang tidak dihitung coverage nya, sehingga akan mengganggu skor akhir dari penghitungan coverage. Hal-hal yang dapat menyebabkan di exlude antara lain file built-in , file yang mempunyai code coverage rendah dan akan menimbukan kerusakan coverage secara keseluruhan dan serta file configurasi yang tidak terdapat pada proses utama didalamnya.
    

### What I did not understand
- [ ] -

---
## Tutorial 6
### What I have learned today
1. ***Apa itu postman? Apa kegunaan dari postman?***
    
    Postman merupakan aplikasi yang memiliki *environment* untuk pengembangan API. Dengan Postman, kita bisa mendesain, *mock*, *debug*, tes, mendokumentasikan, memonitor, dan menerbitkan API kita di satu tempat. Postman berfungsi sebagai REST Client dimana dapat digunakan untuk uji REST API.
        
2. ***Apa kegunaan dari annotation @JsonIgnoreProperties?***
    
    @JsonIgnoreProperties mengabaikan properti logis yang ditentukan dalam serialisasi dan deserialisasi JSON. Itu dijelaskan di tingkat kelas.
    Contohnya ketika kita memberikan *true* untuk elemen **ignoreUnknown**, maka dalam deserialization jika data JSON memiliki bidang yang tidak ada properti logis maka bidang JSON akan diabaikan dan tidak ada kesalahan akan dilemparkan.
     
3. ***Apa itu ResponseEntity dan apa kegunaannya?***

    ResponseEntity mewakili respons HTTP, termasuk tajuk, isi, dan status. Sementara @ResponseBody menempatkan *return value* ke *body* dari *response*, ResponseEntity juga memungkinkan kita untuk menambahkan header dan kode status.

### What I did not understand
- [ ] -

---
## Tutorial 7
### What I have learned today
1. ***Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
      yang telah anda buat) konsep tersebut diimplementasi?***
    
    Otentikasi adalah verifikasi apakah seseorang itu adalah orang yang berhak. Biasanya melibatkan username dan password, tapi dapat menyertakan metode lain yang menunjukan identitas, seperti kartu pintar, sidik jari, dll. Otorisasi adalah pencarian apakah orang yang sudah diidentifikasi (diotentikasi), diijinkan untuk memanipulasi sumber daya tertentu. Ini biasanya ditentukan dengan mencari apakah orang itu merupakan bagian dari aturan khusus yang memiliki akses ke sumber daya.
        
2. ***Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!***
    
    Fungsi BCrypt adalah algoritma hash password default untuk OpenBSD dan sistem lainnya termasuk beberapa distribusi Linux seperti SUSE Linux. Awalan "$ 2a $" atau "$ 2b $" (atau "$ 2y $") dalam string hash dalam file kata kunci bayangan menunjukkan bahwa string hash adalah hash bcrypt dalam format kriptografi modular. Sisa dari string hash mencakup parameter biaya, salt 128 bit (basis-64 yang dikodekan sebagai 22 karakter), dan 184 bit dari nilai hash yang dihasilkan (basis-64 dikodekan sebagai 31 karakter).
    
    Cara kerjanya yaitu saat kita membuat user baru dengan mengisi username dan password, maka ketika kita klik simpan, password akan dienkripsi menggunakan fungsi BCrypt sehingga password yang terlihat pada database adalah password yang sudah dienkripsi.
    
3. ***Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?***

    UUID itu singkatan dari Universally Unique Identifier yang dijadikan sebagai standar identifier sama Open Software Foundation (OSF) sebagai bagian dari Distributed Computing Environment (DCE). UUID merupakan kode identifikasi unik yang diberikan oleh sistem. Maksud dari UUID adalah untuk memungkinkan sistem terdistribusi untuk secara unik mengidentifikasi informasi tanpa koordinasi pusat signifikan.
    
    Mirip seperti BCrypt, bedanya kali ini adalah ID, bukan password. Saat kita membuat user baru, sistem akan otomatis melakukan pemberian kode unik yang akan terlihat pada database dengan tipe UUID, contohnya UUID=62fa5eac-3df4-448d-a576-916dd5b432f2.

4. ***Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
      padahal kita sudah memiliki class UserRoleServiceImpl.java?***
      
    Untuk menggunakan user service kita sendiri atau custom service, kita perlu mengimplementasikan interface UserDetailsService.
    Kita akan membuat kelas yang disebut UserDetailsServiceImpl yang mengganti metode loadUserByUsername() dari interface.
    
    Dalam metode ini, kita mengambil user object menggunakan DAO, dan jika ada, bungkus menjadi objek user, yang mengimplementasikan UserDetailsService, dan mengembalikannya.

### What I did not understand
- [ ] -

---
## Tutorial 8
### What I have learned today
1. ***Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.***
- Nomor 1

    Pada nomor 1, saya menambahkan atribut **hidden** pada tag `<input/>` ketika kondisi *checkbox* berupa *unchecked* atau di *source code* yaitu **!checked**.
    ![alt text](https://i.ibb.co/TvN5T1f/1573642191467.jpg)
    ![alt text](https://i.ibb.co/JF09WzC/1573645706876.jpg)

- Nomor 2

    Pada nomor 2, saya membuat fungsi yang hampir serupa dengan **handleItemClick**, tetapi saya menghapus baris kondisi **else** setelah **if** agar saat *item* pada bagian kiri (*Our Menu*) diklik, tidak akan terjadi *splice* atau penghapusan *item* yang telah menjadi favorit saya.
    ![alt text](https://i.ibb.co/0JSjN8y/1573642347441.jpg)
    ![alt text](https://i.ibb.co/g4f38Np/message-Image-1573645734948.jpg)

- Nomor 3 dan 4

    Pada nomor 3, pertama saya membuat *constructor* kemudian menambahkan sebuah *state* yaitu **showFav** dengan *default* kondisi berupa **false**. Lalu melakukan *binding* dengan `this.showFavChange = this.showFavChange.bind(this);`. Tidak lupa setelah itu membuat sebuah fungsi untuk mengganti kondisi *state* dari **showFav** dengan nama **showFavChange()**. Kemudian saya membuat sebuah variabel *const* **showFavorite** yang berisi list elemen dari kolom *My Favorite* dengan kondisi *state* pada **showFav** berupa *true* ataupun *false*. Kemudian, saat melakukan *rendering*, saya melemparkan variable **showFavorite** yang telah saya buat tadi pada posisi yang seharusnya dengan cara `{showFavorite}`.
    
    Pada nomor 4, saya membuat file baru berupa sebuah *component* yang saya beri nama **Empty State** dengan isi seperti pada gambar. Kemudian saya membuat sebuah variabel *let* dengan nama **emptyState** untuk menyimpan komponen tersebut. Lalu saya memberikan kondisi di saat tidak ada item favorit, maka komponen **emptyState** akan dilemparkan dengan cara `{emptyState}`.

    ![alt text](https://i.ibb.co/JxL3K2N/1573642625389.jpg)
    ![alt text](https://i.ibb.co/thvMvfS/1573642663853.jpg)
    ![alt text](https://i.ibb.co/txTCSj5/1573643242304.jpg)
    ![alt text](https://i.ibb.co/dkyYjpg/1573645832786.jpg)
    ![alt text](https://i.ibb.co/DYnGmqW/1573645851793.jpg)

 
### What I did not understand
- [ ] -

## Tutorial 9
### What I have learned today
1. ***Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?***

    Saya menambahkan beberapa baris kode pada event **submitAddRestoranHandler** untuk melakukan *setState* dengan kode seperti berikut:
        
        this.setState({ 
            nama: "", 
            alamat: "", 
            nomorTelepon: "", 
            rating: "" 
        });
    
    Saya menggunakan langkah tersebut karena dengan mengganti *state* yang ada pada form tambah restoran menjadi *string* kosong, maka akan menjadikan *value* dari setiap *form field* tersebut seperti belum diisi sama sekali.

2. ***Jelaskan fungsi dari async dan await!***

    *Keyword* **async** menyatakan fungsi *asynchronous*, yang berarti berfungsi untuk secara otomatis mengembalikan sebuah *return value* berupa objek dengan bentuk/tipe **Promise**, atau ditolak dengan *uncaught errors* dan dapat menggunakan *keyword* **await**.

    *Keyword* **await** berfungsi untuk memberi tahu program untuk keluar secara sementara dari fungsi **async** dan melanjutkan programnya ketika tugas yang diberikan telah selesai.

3. ***Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada pertanyaan ini.***

    ![alt text](https://i.ibb.co/09Bysdx/1.jpg)
    ![alt text](https://i.ibb.co/nCF8kX0/2.jpg)
    ![alt text](https://i.ibb.co/bKwwd7k/3.jpg)
    ![alt text](https://i.ibb.co/Z6Qf01s/4.jpg)
    ![alt text](https://i.ibb.co/HFqZ1yT/5.jpg)
    ![alt text](https://i.ibb.co/wR3s9fh/6.jpg)
    ![alt text](https://i.ibb.co/zGH7qpB/7.jpg)

4. ***Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.***

    **componentDidMount:**
    - Fungsi: Menandakan tahap akhir dari *mounting lifecycle* yang dipanggil setelah HTML yang dirender telah selesai melakukan *loading*.
    - Best time to call method: Dipanggil saat HTML telah selesai melakukan *rendering*. Selain itu, fungsi ini dapat digunakan saat React ingin terhubung (mengambil data) dengan aplikasi eksternal  seperti API dari website lain, atau *framework* JavaScript. Setelah itu kita dapat menggunakan *method* **setState()** untuk memperbarui data yang didapat dan melakukan *rendering* dengan data yang baru.
    - Use case: Mengambil data (API) dari website lain untuk kemudian dirender.

    **shouldComponentUpdate:**
    - Fungsi: Memberi tahu React jika output dari komponen tidak terpengaruh oleh perubahan saat ini di dalam *state* dan *props*. Dengan kata lain, memberi tahu bahwa apakah komponen harus diperbarui atau tidak, dengan *return value* berupa *boolean* *true or false* dan dengan menerima parameter *nextProps* dan *nextState*.
    - Best time to call method: Saat terdapat komponen yang diperbarui setelah berjalannya *method* **componentWillReceiveProps**, tetapi sebelum proses *rendering* dimulai.
    - Use case: Ingin mengubah komponen dan melakukan *rendering* kembali pada setiap *state* yang berubah.

    **componentDidUpdate:**
    - Fungsi: Untuk berinteraksi dengan sesuatu di luar *environment* React, seperti browser atau API.
    - Best time to call method: Saat suatu *instance* di dalam suatu komponen melakukan *update* dan ketika HTML yang dirender telah selesai melakukan *loading*.
    - Use case: Melakukan *update* pada komponen

    **componentWillReceiveProps:**
    - Fungsi: Memberi tahu React bahwa akan ada perubahan pada komponen yang memiliki *props*.
    - Best time to call method: Saat suatu *instance* di dalam suatu komponen melakukan *update* dan sebelum proses *rendering* dimulai. *Method* ini hanya akan dipanggil saat komponen akan menerima *props*.
    - Use case: Melakukan reset state.

    **componentWillUnmount:**
    - Fungsi: Melakukan pembersihan yang diperlukan dalam *method* ini, seperti timer yang tidak valid, membatalkan permintaan jaringan, atau membersihkan langganan apa pun yang dibuat di **componentDidMount**.
    - Best time to call method: Ketika ada komponen yang ingin dihapus dari DOM, misalnya ketika DOM dirender ulang tanpa komponen atau pengguna berganti website atau menutup browsernya.
    - Use case: Menghapus interval waktu fungsi berjalan.

### What I did not understand
- [ ] -

