package com.example.projek;
public class Soal {
    public String pertanyaan[] = {
            "Kita harus hemat dalam menggunakan air. Antonim dari kata hemat adalah...",
            "Film ini sangat cocok untuk ditonton anak muda. Sinonim kata muda adalah...",
            "Di era yang serba canggih ini, banyak sekali dijumpai barang palsu. Antonim dari kata palsu adalah...",
            "Antonim dari kata semu adalah...",
            "Berikut yang merupakan pasangan kata berantonim adalah...",
            "Kio dan Oki merupakan saudara kembar yang identik. Lawan kata identik adalah...",
            "Berikut yang merupakan pasangan kata bersinonim adalah...",
            "Kelly dilarikan ke rumah sakit karena dehidrasi. Lawan kata dari dehidrasi adalah...",
            "Saat ini Rio sedang memasuki semester gasal. Persamaan kata dari gasal adalah...",
            "Antonim dari kata statis adalah...",
    };

    private String pilihanJawaban[][] = {
            {"Cermat","Hati-hati","Boros","Irit"},
            {"Remaja","Tua","Kolot","Jompo"},
            {"Gadungan","Tiruan","Baru","Asli"},
            {"Nyata","Palsu","Editan","Maya"},
            {"Masuk><Keluar","Pandai><Pintar","Dingin><Sejuk","Kekal><Abadi"},
            {"Sama","Beda","Kembar","Mirip"},
            {"Pulang><Pergi","Fakta><Nyata","Lama><Sebentar","Panas><Dingin"},
            {"Evaporasi","Irigasi","Peningkatan air","Penyusutan air"},
            {"Genap","Ganjil","Baru","Masuk"},
            {"Hampa","Kosong","Benar","Dinamis"},
    };

    private String jawabanBenar[] = {
            "Boros",
            "Remaja",
            "Asli",
            "Nyata",
            "Masuk><Keluar",
            "Beda",
            "Fakta><Nyata",
            "Peningkatan air",
            "Ganjil",
            "Dinamis",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    public String getPilihanJawaban4(int x){
        String jawaban4 = pilihanJawaban[x][3];
        return jawaban4;
    }
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
