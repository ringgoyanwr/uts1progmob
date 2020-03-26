package com.example.tugas_uts

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.web_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakultasData()
        rc.layoutManager = LinearLayoutManager( this )
        rc.setHasFixedSize(true)
        rc.adapter = fakultasadapter(testData, { fakultasItem : FakultasData -> fakultasItemClicked (fakultasItem) })
    }
    private fun fakultasItemClicked(fakultasItem: FakultasData){
        val showDetailActivityIntent = Intent( this,FakultasDetailActivity::class.java )
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, fakultasItem.fakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, fakultasItem.detail.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.fotofakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_PROCESS_TEXT, fakultasItem.edit_url.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, fakultasItem.link_email.toString())
            startActivity(showDetailActivityIntent)
}
    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("FAKULTAS ILMU KOMPUTER","Sejarah Fakultas Ilmu Komputer\n" +
                "\n" +
                "Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Sekarang FIK telah memiliki 2 Jurusan/program studi yaitu Tahun 2003 Jurusan Teknik Informatika dan tahun 2007 Jurusan Sistem Informasi. Pada awalnya prodi Teknik Informatika dan Sitsem Informasi bergabung dengan Fakultas Teknik Industri sekarang berganti nama menjadi Fakultas Taknik.\n" +
                "\n" +
                "Dalam proses perkembangan dalam pengelolaanTri Dharma, FIK telah melakukan berbagai upaya untuk meningkatkan kualitas lulusan, seperti peningkatan kualitas dan kuantitas sarana prasarana, peningkatan kualitas sumber daya manusia (dosen dan tenaga kependidikan), perbaikan kurikulum, memperbanyak dan memanfaatkan kerjasama dengan pemerintah maupun swasta.\n" +
                "\n" +
                "Visi\n" +
                "\n" +
                "Visi Fakultas Ilmu Komputer UPN \"Veteran\" Jawa Timur untuk tahun 2016-2019 yakni:  \n" +
                "“Menjadi Fakultas Ilmu Komputer Unggul Berkarakter Bela Negara”.\n" +
                "Makna UNGGUL berarti berdaya saing tinggi. Dimensi keunggulan yang sedang dikembangkan Fakultas adalah unggul di bidang penelitian, sesuai dengan yang tercantum pada Rencana Strategis Penelitian dan Pengabdian Masyarakat periode tahun 2015-2019, dimana penelitian dimaksudkan untuk menerapkan dan mengembangkan teknologi informasi, khususnya yang bermanfaat bagi kehidupan berbangsa dan bernegara, serta menghasilkan solusi teknologi informasi terhadap permasalahan di bidang industri maupun masyarakat.\n" +
                " \n" +
                "Pengertian BELA NEGARA mengandung nilai-nilai cinta tanah air, sadar sebagai warga negara dalam berbangsa dan bernegara, rela berkorban, yakin bahwa Pancasila sebagai dasar negara dan mempunyai kemampuan awal bela negara yang wajib dianut oleh seluruh civitas akademika dan ditanamkan ke peserta didik dalam proses pembelajarannya.\n" +
                "\n" +
                "Misi\n" +
                "\n" +
                "Misi Fakultas Ilmu Komputer untuk tahun 2016-2019 adalah sebagai berikut:\n" +
                "1. Menyelenggarakan pendidikan untuk menghasilkan lulusan yang menguasai teknologi informasi, berdaya saing tinggi, dan berkarakter bela negara\n" +
                "2. Mengembangkan penelitian dalam bidang teknologi informasi dan menerapkannya untuk meningkatkan kecerdasan dan kesejahteraan masyarakat\n" +
                "3. Menyelenggarakan pengabdian kepada masyarakat dalam bidang teknologi informasi yang berbasis riset dan kearifan lokal\n" +
                "4. Menyelenggarakan tata kelola yang baik dan bersih dalam rangka mencapai akuntabilitas pengelolaan anggaran\n" +
                "5. Mengembangkan kualitas sumber daya manusia unggul dalam sikap dan tata nilai, unjuk kerja, penguasaan pengetahuan, dan manajerial\n" +
                "6. Meningkatkan sistem pengelolaan sarana dan prasarana terpadu\n" +
                "7. Meningkatkan kerjasama dengan stakeholder di bidang Pendidikan, Penelitian, dan Pengabdian kepada Masyarakat\n" +
                "\n" +
                "Program Studi \n" +
                "\n" +
                "•\tSistem Informasi\n" +
                "•\tTeknik Informatika \n" +
                "\n", R.drawable.fasilkom,"fik.upnjatim.ac.id","fik@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS TEKNIK","Sejarah Hukum\n" +
                    "  Sejarah Fakultas Teknik\n" +
                    "    Fakultas Teknologi  (FT) merupakan salah satu dari 7 (enam) Fakultas di UPN \"Veteran\" Jawa Timur. Pada awal berdirinya tahun 1968 bernama Fakultas Teknik Kimia, dengan berkembangnya ilmu pengetahuan, teknologi dan Industri pada tahun 1990 namanya berubah menjadi Fakultas Teknologi Industri dengan 2 (dua) Jurusan Teknik Kimia dan Teknik Industri. Dalam perjalanannya untuk merespon perkembangan ilmu pengetahuan dan teknologi informasi serta tuntutan kebutuhan masyarakat/industri maka pada tahun 1993 dibuka jurusan Teknologi Pangan, tahun 2003 Jurusan Teknik Informatika dan tahun 2007 Jurusan Sistem Informasi, sehingga sekarang FTI telah memiliki 5 (lima) Jurusan/program studi.\n" +
                    "    Pada awalnya tahun 1968 Fakultas Teknik Kimia sebagai perguruan tinggi swasta dengan status terdaftar, dalam perjalannya tahun 1970 Fakultas Teknik Kimia yang dibawah naungan UPN \"Veteran\" Jawa Timur pada waktu itu namaya PTPNV bergabung dengan UPNV Yogyakarta dan UPNV Jakarta pengelolaanya dibawah Departemen Pertahanan dan Keamanan negeri kedinasan, maka status semua jurusan menjadi negeri kedinasan. Pada tahun 1995 dengan keluarnya peraturan pemerintah tentang pengelolaan perguruan tinggi, maka UPNV kembali menjadi perguruan tinggi swasta dengan status semua jurusan disamakan.Tanggal 6 Oktober 2014  UPN \"Veteran\" Jawa Timuryang semula berada dibawah Yayasan Kesejahteraan Pendidikan  dan Perumahan dengan status Perguruan Tinggi swata di kembalikan menjadi Perguruan Tinggi Negeri dengan Peraturan Presiden no.122 tahun 2014 terdiri dari 7 Fakultas dengan 19 program studi strata 1(S1)dan3 program studi strata 2 (S2) di bawah pembinaan Kementerian Riset dan Teknologi dan Pendidikan Tinggi  .Pada tanggal 23 Agustus 2016 berdasarkan Peraturan Menteri Ristek dan Dikti No.38 Tahun 2015 fakultas Teknologi Indsutri (FTI) berubah menjadi Fakultas Teknik (FT) dimana Fakultas Teknik Terdiri dari 5 prgram studi yaitu Teknik Kimia, Teknik Industri, Teknologi Pangan , Teknik Lingkungan dan Teknik Sipil. Program studi strata 2 (S2) dengan Program Studi Ilmu Lingkungan.Rabu (23 Oktober 2019), pukul 10.30 WIB,Presiden  Joko Widodo alias Jokowi dan Wakil Presiden  Ma'ruf Amin resmi melantik susunan Kabinet Indonesia Maju yang nantinya akan membantu kerja Jokowi – Ma’ruf dalam memajukan Indonesia untuk periode 2019-2024 dimana Menristek dan Dikti bergabung  kembali dengan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "Dalam proses perkembangan dalam pengelolaanTri Dharma, Fakultas Teknik  telah melakukan berbagai upaya untuk meningkatkan kualitas lulusan, seperti peningkatan kualitas dan kuantitas sarana prasarana, peningkatan kualitas sumber daya manusia (dosen dan tenaga kependidikan), perbaikan kurikulum, memperbanyak dan memanfaatkan kerjasama dengan pemerintah maupun swasta.\n" +
                    "Visi Misi dan Tujuan\n" +
                    "VISI FH:\n" +
                    "\n" +
                    "“ MENJADI FAKULTAS UNGGUL BERKARAKTER BELA NEGARA DALAM MENGHASILKAN LULUSAN DALAM BIDANG HUKUM SECARA TEORITIK DAN PRAKTIS”\n" +
                    "\n" +
                    "MISI FH:\n" +
                    "\n" +
                    "1. Menyelenggarakan dan mengembangkan pendidikan hukum secara teoritis dan praktis\n" +
                    "2. Menyelenggarakan budaya riset yang berdaya guna untuk memecahkan persoalan hukum masyarakat\n" +
                    "3. Menyelenggarakan tata kelola yang bersih menuju pengelolaan anggaran yang akuntabel guna mendukung sarana dan prasarana yang memadai dan peningkatan kualitas sumber daya manusia\n" +
                    "4. Menjalin kerjasama dengan lembaga-lembaga yang terkait dengan pengembangan Fakultas Hukum\n" +
                    " \n" +
                    "Program Studi \n" +
                    "•\tTeknik Kimia\n" +
                    "•\tTeknik Industri\n" +
                    "•\tTeknik Pangan\n" +
                    "•\tTeknik Sipil\n" +
                    "•\tTeknik Lingkungan\n",R.drawable.ft,"ft.upnjatim.ac.id/","ft@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS EKONOMI BISNIS","Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi: \n" +
                    "1. Ekonomi Pembangunan \n" +
                    "2. Akutansi\n" +
                    "3. Manajemen\n",R.drawable.logo,"febis.upnjatim.ac.id","feb@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS PERTANIAN","Sejarah Fakultas Pertanian\n" +
                    "Fakultas Pertanian Universitas Pembangunan Nasional “Veteran” Jawa Timur merupakan salah satu lembaga pendidikan tinggi bidang pertanian di Indonesia yang berdiri sejak 17 Mei 1968.  Selama kurun waktu 45 tahun, UPN “Veteran” Jawa Timur telah mengalami berbagai perubahan status, yaitu;\n" +
                    "1.\tPeriode 17 Mei 1968 merupakan tonggak berdirinya Fakultas Pertanian Perguruan Tinggi Pembangunan Nasional (PTPN) “Veteran” Cabang Jawa Timur yang ditandai dengan diterbitkannya Surat Keputusan Kementerian Transmigrasi, Veteran dan Demobilisasi No. 062/Kpts/ Mentransved/68 dan SK Rektor PTPN “Veteran” Yogyakarta.  No. 11/Rek/kpts/ PTPN/68 tanggal 5 September 1968.\n" +
                    "2.\tPeriode tahun 1976-1982, PTPN “Veteran” Cabang Jawa Timur berada dibawah naungan langsung Dephankam/ Pangab setelah selama periode tahun 1966 s/d tahun 1976 berada dibawah naungan Kementerian Transmigrasi, Veteran dan Demobilisasi dengan status PTPN “Veteran” Cabang Jawa Timur sebagai Perguruan Tinggi Kedinasan. Selanjutnya periode 1983-1994 status pembinaan langsung dibawah binaan Ditjen Persmanvet Dephankam RI, dan pada tahun 1994 sampai sekarang dibawah binaan Yayasan Kejuangan Panglima Besar Sudirman (YKPBS).\n" +
                    "3.\tTahun 1977 terjadi perubahan nama PTPN “Veteran” Cabang Jawa Timur menjadi Universitas Pembangunan Nasional “Veteran” Cabang Jawa Timur sebagai Perguruan Tinggi Fakultas Pertanian UPN “Veteran” Jawa Timur.\n" +
                    "4.\tSetelah selama peride tahun 1966 – 1993 berada dibawah koordinasi dengan UPN “Veteran” Yogyakarta, maka pada tahun 1993/1994 telah berdiri sendiri ; dan sejak tanggal  29 Nopember 1994 Fakultas Pertanian memperoleh status swasta disamakan sebagai konsekuensi dari status PTS UPN “Veteran” Jawa Timur berdasarkan Surat Keputusan Bersama Mendikbud-Menhankam Nomor : 0307/O/1994 – Kep/10/XI/1994.\n" +
                    "5.\tPeriode  Nopember 1994 sampai 10 Agustus 1998, Fakultas Pertanian UPN “Veteran” Jawa Timur mem-persiapkan status akreditasi perguruan tinggi; dan berdasarkan Surat keputusan Badan Akreditasi Nasional Perguruan Tinggi No. 001/BAN-PT/Ak-1/VIII/1998 tanggal 11 Agustus 1998 telah memperoleh status terakreditasi penuh untuk semua Jurusan/ Program Studi.\n" +
                    "6.\tSemenjak tahun 1998 sampai dengan saat ini status semua program studi di Fakultas Pertanian (4 Progdi yang ada) berdasarkan penilaian dari badan Akreditasi Nasional Perguruan Tinggi semuanya telah terakreditasi dengan Nilai B.\n" +
                    "7.\tBerdasarkan Sk Dirjen Dikti Nomor : 163/DIKTI/Kep/2007 Tanggal : 29 November 2007 , tentang penataan Program Studi Fakultas Pertanian, maka  Fakultas Pertanian yang semula menjadi 4 (empat) Jurusan yaitu Hama Penyakit Tanaman, Ilmu Tanah, Agronomi, dan Sosial Ekonomi Pertanian, menjadi 2 (dua) Program Studi yaitu Progdi Agroteknologi dan Agribisnis. Kedua Program Studi tersebut berdasarkan penilaian BAN-PT mulai tahun 2010 terakreditasi A.\n" +
                    "8.\tBerdasarkan KEPPRES No : 62/2014 Tanggal 6 Oktober 2014 UPN \"Veteran\" Jawa Timur resmi menjadi Perguruan Tinggi Negeri termasuk Fakultas Pertanian.\n" +
                    "\n" +
                    "       Fakultas Pertanian saat ini  memiliki 2 program studi jenjang S-1, yaitu Agroteknologi dan Agribisnis dan 1 (satu) program studi jenjang S-2 , Magister Agribisnis (MAgr.). Tahun 2015 sudah diusulkan ke Kementerian Ristek dan Pendidikan Tinggi untuk program master (S2) Agroteknologi dan program doktor (S3) Ilmu Pertanian. Berkat kerja keras dalam menjaga kualitas SDM, proses manajemen dan lulusannya,  semua program studi di bawah Fakultas Pertanian  mendapatkan akreditasi A dari BANPT-DIKTI.\n" +
                    "Visi Misi dan Tujuan\n" +
                    "VISI\n" +
                    "“TERWUJUDNYA FAKULTAS YANG UNGGUL DALAM PEMBANGUNAN IPTEKS PERTANIAN DAN KEWIRAUSAHAAN, BERJEJARING GLOBAL SERTA BERKARAKTER BELANEGARA PADA TAHUN 2019”\n" +
                    "MISI\n" +
                    "1.\tMenyelenggarakan pendidikan berkualitas dengan pemanfaatan hasil penelitian dan berkarakter bela negara\n" +
                    "2.\tMenyelenggarakan penelitian strategis dan berkesinambungan untuk mengembangkan IPTEKS pertanian\n" +
                    "3.\tMenyelenggarakan pengabdian kepada masyarakat melalui penerapan teknologi tepat guna berbasis kearifan lokal\n" +
                    "4.\tMenyelenggarakan tata kelola Fakultas yang baik dan bersih\n" +
                    "5.\tMengembangkan kualitas sumber daya manusia berkarakter bela negara\n" +
                    "6.\tMeningkatkan sistem pengelolaan sarana dan prasarana terpadu di tingkat Fakultas\n" +
                    "7.\tMeningkatkan kerjasama institusional dalam dan luar negeri melalui keunggulan Litdimas\n" +
                    "TUJUAN\n" +
                    "1.\tMenghasilkan lulusan yang kompeten, kompetitif, berjiwa wirausaha, dan bela negara.\n" +
                    "2.\tMenghasilkan IPTEKS pertanian yang bermutu guna meningkatkan kesejahteraan masyarakat.\n" +
                    "3.\tBerperan aktif dalam pemberdayaan masyarakat.\n" +
                    "4.\tMeningkatkan kinerja Tri Dharma Perguruan Tinggi (TDPT) Fakultas Pertanian.\n" +
                    "Program Studi \n" +
                    "•\tAgroteknologi\n" +
                    "•\tAgribisnis\n" +
                    "\n",R.drawable.faperta,"faperta.upnjatim.ac.id/","faperta@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS ILMU SOSIAL & POLITIK","Sejarah Fakultas Ilmu Sosial dan Ilmu Politik\n" +
                    "Keberadaan Fakultas Ilmu Sosial dan Ilmu Politik diawali dengan berdirinya Fakultas Ilmu Administrasi Negara dan Administrasi Niaga. Satu tahun kemudian Fakultas Ilmu Administrasi membuka satu jurusan baru yaitu jurusan Ilmu Komunikasi pada tahun ajaran 1994/1995. Dalam perkembangan selanjutnya terbit Surat Keputusan Rektor UPN “Veteran” Jawa Timur Nomor : Skep/101/IX/2005 tanggal 6 Mei 2005 tentang Pergantian nama Fakultas Ilmu Administrasi UPN”Veteran” Jawa Timur menjadi Fakultas Ilmu Sosial dan Ilmu Politik.\n" +
                    "Selanjutnya status UPN “Veteran” Jawa Timur yang semula berstatus sebagai Perguruan Tinggi kedinasan berubah menjadi Perguruan Tinggi Swasta dibawah Kopertis Wilayah VII sesuai dengan Surat Keputusan Bersama antara Menhankam dengan Mendikbud nomor :\n" +
                    "0307/0/1994\n" +
                    "KEP/10/XI/1994\n" +
                    "Tanggal 29 Nopember 1995 tentang Peningkatan Pengabdian UPN “Veteran” melalui Pelaksanaan Keterkaitan dan Keterpaduan. \n" +
                    "Sejak tahun 2009 Fakultas Ilmu Sosial dan Ilmu Politik memiliki empat Program Studi yaitu :\n" +
                    " 1.       Ilmu Administrasi Negara\n" +
                    " 2.       Ilmu Administrasi Bisnis\n" +
                    " 3.       Ilmu Komunikasi\n" +
                    " 4.       Hubungan Internasional\n" +
                    " \n" +
                    " Selanjutnya UPN “Veteran” Jawa timur berdasarkan Peraturan Presiden Republik Indonesia Nomor 122 Tahun 2014 tentang Pendirian Universitas Pembangunan Nasional “Veteran” Jawa Timur sebagai Perguruan Tinggi Negeri.\n" +
                    "Visi Misi dan Tujuan\n" +
                    "VISI FISIP:\n" +
                    "\n" +
                    "“MENJADI FAKULTAS ILMU SOSIAL DAN ILMU POLITIK UNGGUL BERKARAKTER BELA NEGARA”\n" +
                    "\n" +
                    "MISI FISIP:\n" +
                    "\n" +
                    "1. Menyelenggarakan dan mengembangkan pendidikan bidang ilmu sosial dan ilmu politik yang berkarakter bela negara;\n" +
                    "2. Meningkatkan budaya riset dalam pengembangan ilmu sosial dan ilmu politik yang berdayaguna untuk peningkatkan kesejahteraan masyarakat;\n" +
                    "3. Menyelenggarakan pengabdian kepada masyarakat berbasis riset dan kearifan lokal;\n" +
                    "4. Menyelenggarakan tata kelola yang bersih dalam rangka mencapai akuntabilitas pengelolaaan anggaran di fakultas ilmu sosial dan ilmu politik;\n" +
                    "5. Mengembangkan kualitas sumber daya manusia unggul dalam sikap dan tata nilai, unjuk kerja, penguasaan pengetahuan, dan manajerial yang relevan dengan bidang ilmu sosial dan ilmu politik;\n" +
                    "6. Meningkatkan sistem pengelolaan sarana dan prasarana terpadu di fakultas ilmu sosial dan ilmu politik;\n" +
                    "7. Meningkatkan kerjasama institusional dengan stakeholders baik dalam dan luar negeri.\n" +
                    "TUJUAN\n" +
                    "1.\tMenghasilkan lulusan yang kompeten, kompetitif, berjiwa wirausaha, dan bela negara.\n" +
                    "2.\tMenghasilkan IPTEKS pertanian yang bermutu guna meningkatkan kesejahteraan masyarakat.\n" +
                    "3.\tBerperan aktif dalam pemberdayaan masyarakat.\n" +
                    "4.\tMeningkatkan kinerja Tri Dharma Perguruan Tinggi (TDPT) .\n" +
                    "Program Studi \n" +
                    "•\tIlmu Administrasi Negara\n" +
                    "•\tIlmu Administrasi Bisnis\n" +
                    "•\tIlmu Komunikasi\n" +
                    "•\tHubungan Internasional\n",R.drawable.logo, "http://fisip.upnjatim.ac.id/","fisip@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS ARSITEKTUR & DESAIN","Sejarah Arsitektur & Desain\n" +
                    "Perubahan Organisasi dan Tata Kerja UPN “Veteran” Jawa Timur sejak perubahan status UPNVJ menjadi PTNB sesuai Peraturan Presiden Republik Indonesia Nomor 122 Tahun 2014 tentang Pendirian Universitas Pembangunan Nasional “Veteran” Jawa Timur. Perubahan itu berdampak pada perubahan OTK diantaranya adalah dihapusnya Fakultas Teknik Sipil dan Perencanaan menjadi Fakultas Arsitektur dan Desain (FAD) sebagai fakultas baru sejak Agustus 2016 melalui Keputusan Rektor UPN “Veteran” Jatim Nomor: 153/UN63/KP/2016. Fakultas Arsitektur dan Desain terbentuk dari pemisahan 4 (empat) prodi Fakultas Teknik Sipil dan Perencanaaan, dimana Prodi Teknik Lingkungan dan Prodi Teknik Sipil bergabung dengan Fakultas Teknik, sedangkan Prodi Arsitektur dan Prodi Desain Komunikasi Visual menjadi fakultas tersendiri yakni Fakultas Arsitektur dan Desain. Sejak saat itu pula, FAD sebagai fakultas baru di jajaran UPN “Veteran” Jawa Timur mempunyai tugas dan wewenang untuk melestarikan, mengembangkan, menyebarluaskan, dan menggali ilmu pengetahuan, teknologi, dan seni, serta berfungsi mengembangkan kualitas sumberdaya manusia, baik di kalangan tenaga pendidik, tenaga kependidikan dan mahasiswa.\n" +
                    "Visi Misi dan Tujuan\n" +
                    "VISI\n" +
                    "\n" +
                    "Menjadi Fakultas Arsitektur dan Desain Unggul Berkarakter Bela Negara\n" +
                    "\n" +
                    "MISI\n" +
                    "\n" +
                    "1. Menyelenggarakan dan mengembangkan pendidikan rekayasa dan desain berkarakter bela negara;\n" +
                    "2. Meningkatkan budaya riset rekayasa dan desain dalam pengembangan IPTEK yang berdayaguna untuk kesejahteraan masyarakat;\n" +
                    "3. Menyelenggarakan pengabdian kepada masyarakat berbasis riset dan kearifan lokal bidang rekayasa dan desain;\n" +
                    "4. Menyelenggarakan tata kelola FAD yang baik dan bersih dalam rangka mencapai akuntabilitas pengelolaan anggaran;\n" +
                    "5. Mengembangkan kualitas sumber daya manusia unggul FAD dalam sikap dan tata nilai, unjuk kerja, penguasaan pengetahuan, dan manajerial;\n" +
                    "6. Meningkatkan sistem pengelolaan sarana dan prasarana FAD terpadu;\n" +
                    "7. Meningkatkan kerjasama institusional FAD dengan stakeholders baik dalam dan luar negeri.\n" +
                    "\n" +
                    "TUJUAN\n" +
                    "\n" +
                    "1. Menghasilkan lulusan yang kompeten bidang rekayasa dan desain berkarakter bela negara dan mampu bersaing di era global;\n" +
                    "2. Menghasilkan penelitian bermutu dan inovasi riset rekayasa dan desain yang berdaya guna untuk kesejahteraan masyarakat;\n" +
                    "3. Mewujudkan kegiatan pengabdian yang dibutuhkan masyarakat dengan berbasis riset dan kearifan lokal bidang rekayasa dan desain;\n" +
                    "4. Mengembangkan tata kelola FAD yang baik dan bersih untuk mencapai akuntabilitas pengelolaan anggaran;\n" +
                    "5.  Menghasilkan sumber daya manusia unggul FAD yang kompeten dan berdaya saing tinggi;\n" +
                    "6.  Meningkatkan sarana prasarana FAD yang memadai dengan pengelolaan yang efektif dan efisien;\n" +
                    "7. Mengembangkan kerjasama institusional FAD dengan stakeholder baik dalam dan luar negeri yang intensif dan menguntungkan kedua belah pihak\n" +
                    "Program Studi \n" +
                    "•\tTeknik Arsitektur\n" +
                    "•\tDesain Komunikasi Visual\n" +
                    "\n",R.drawable.fad, "fad.upnjatim.ac.id/","fad@upnjatim.ac.id"))
        partList.add(
            FakultasData("FAKULTAS HUKUM","Sejarah Hukum\n" +
                    "  Pendirian Fakultas Hukum di lingkungan UPN “Veteran“ Jawa Timur pada awalnya merupakan prakarsa Rektor UPN “Veteran“ Jawa Timur yang saat itu dijabat oleh Brigjen. (Purn.) Suparyo Sri Indrantoro, M.Pkn. Gagasan ini ditindaklanjuti penyiapan SDM dengan menyekolahkan sdr Sutrisno, SH kejenjang Stata dua (S2) dengan harapan dikemudian hari memiliki dosen yang kompeten dan berkualitas untuk bisa mengelola program studi Ilmu Hukum.\n" +
                    " \n" +
                    "Pada tahun 2001, Tim Survey yang beranggotakan Haryo Sulistiyantoro, SH., P. Handoko, S.Sos., SH., Ir. Jusuf  Mahdi., Sutrisno, SH., dan Subani, SH., M.Si., menemukan fakta yang menunjukkan trend positif minat masyarakat terhadap Pendidikan Tinggi Hukum. Tindak lanjut dari perolehan hasil survey tersebut, kemudian oleh tim dirumuskan dan diajukan dalam sebuah proposal induk pendirian Fakultas Baru, tetapi pada saat itu belum bisa disetujui oleh Pimpinan UPN “Veteran“ Jatim beserta BPH UPN “Veteran“ Jatim karena SDM yang dimiliki pada saat itu dianggap belum mencukupi.\n" +
                    "Pada tanggal ± 10 April 2006 Bpk Rektor Mayjen. (Purn.) Drs. H. Warsito. SH., MM memalui Pembantu Rektor I memerintahkan kepada Sdr Sutrisno, SH, M.Hum ditemani Sdr Hariyo Sulistiyantoro, SH, untuk memaparkan rencana pendirian Progdi Ilmu Hukum pada 12 April 2006 dihadapan senat Universitas UPN “Veteran“ Jatim, Alhamdulillah Senat Universitas menyetujui rencana pendirian Fakultas Hukum di UPN “Veteran” Jawa Timur. Selanjutnya secara legal formal diterbitkan Surat Perintah Rektor Nomor: SPRINT/296/VIII/2006 tentang Pembentukan Struktur Organisasi dan Jabatan di Fakultas Hukum UPN “Veteran“ Jatim. Puncaknya pada tanggal 4 September 2006 dalam Rapat Senat Terbuka yang diikuti oleh seluruh Pimpinan Universitas, Pimpinan Fakultas, mahasiswa baru dan seluruh orang tua mahasiswa baru, Ketua BP UPN “Veteran“ YKBPS melakukan pemukulan gong tanda peresmian berdirinya Fakultas Hukum UPN “Veteran“ Jatim sekaligus secara simbolis melakukan penyematan pin kepada perwakilan mahasiswa angkatan pertama Fakultas Hukum yang berjumlah 96 orang.\n" +
                    "Peran vital infrastruktur gedung perkuliahan dan beberapa fasilitas pendukung bagi sebuah institusi pendidikan tinggi segera ditindaklanjuti Pimpinan UPN “Veteran” Jatim dengan menerbitkan Skep No.39/XI/2006/YKBPS oleh Yayasan Kejuangan Panglima Besar Sudirman di bawah pembinaan Kementrian Pertahanan RI disetujui rencana pembangunan gedung Fakultas Hukum yang terdiri dari 3 lantai lengkap dengan fasilitasnya. Pembangunan gedung Fakultas Hukum terletak di jalan lingkar selatan kampus UPN “Veteran” Jatim yang menghadap ke selatan dengan target penyelesaian sebelum tahun ajaran baru 2007/2008. Dengan demikian, pada saat tahun ajaran baru gedung baru Fakultas Hukum sudah bisa digunakan oleh mahasiswa.\n" +
                    "Komitmen menciptakan lulusan Fakultas Hukum yang berkualitas diwujudkan Rektor UPN “Veteran” Jatim dengan pembentukan Pusbankum (Pusat Studi Pengembangan dan Advokat Hukum) UPN Veteran Jatim. Pusbankum ini dibentuk sebagai bagian dari laboratorium mahasiswa Fakultas Hukum untuk melakukan pelayanan hukum bagi Civitas Akademika UPN dan Masyarakat yang membutuhkan bantuan hukum dan konsultasi. Pusbankum dalam implementasinya melibatkan peran serta aktif mahasiswa Fakultas Hukum dengan bimbingan dosen Fakultas Hukum. Disinilah peranan mahasiswa untuk melakukan pendampingan dan konsultasi hukum kepada masyarakat untuk mengasah dan mempertajam nilai kepakaran mahasiswa dalam pelaksanaan Tri Dharma Perguruan Tinggi. Selain fasilitas utama ruang perkuliahan, pembangunan gedung Fakultas Hukum dilengkapi dengan fasilitas pendukung lainnya, yakni ruang laboratorium pengadilan semu yang terdiri dari peradilan perdata dan pidana, peradilan agama, peradilan TUN dan sebagainya yang disesuaikan dengan kebutuhan. Selain itu, Fakultas Hukum dilengkapi ruang pelayanan mahasiswa, ruang baca, ruang penjaminan mutu, BEM dan BLM Fakultas Hukum.\n" +
                    "Pimpinan Fakultas Hukum untuk pertama kalinya Dekan dirangkap oleh Rektor UPN “Veteran” Jatim Mayjen. (Purn.) Drs. H. Warsito. SH., MM., Kaprogdi Sutrisno, SH, M.Hum, dan selanjutnya Plt. Dekan dijabat Drs. Ec. Khusnul Hadi, SH. MS., yang dibantu Pembantu Dekan Haryo Sulistiyantoro, SH., Kaprogdi Ilmu Hukum Sutrisno, SH. M.Hum., Pada tahun 2008 sampai dengan tahun 2016 Fakultas Hukum dipimpin oleh Hariyo Sulistyantoro, SH.,MM sebagai dekan. Tahun 2016 sampai dengan saat ini Fakultas Hukum dipimpin oleh Dr. H. Sutrisno, SH.,M.Hum\n" +
                    "Visi Misi dan Tujuan\n" +
                    "VISI FH:\n" +
                    "\n" +
                    "“ MENJADI FAKULTAS UNGGUL BERKARAKTER BELA NEGARA DALAM MENGHASILKAN LULUSAN DALAM BIDANG HUKUM SECARA TEORITIK DAN PRAKTIS”\n" +
                    "\n" +
                    "MISI FH:\n" +
                    "\n" +
                    "1. Menyelenggarakan dan mengembangkan pendidikan hukum secara teoritis dan praktis\n" +
                    "2. Menyelenggarakan budaya riset yang berdaya guna untuk memecahkan persoalan hukum masyarakat\n" +
                    "3. Menyelenggarakan tata kelola yang bersih menuju pengelolaan anggaran yang akuntabel guna mendukung sarana dan prasarana yang memadai dan peningkatan kualitas sumber daya manusia\n" +
                    "4. Menjalin kerjasama dengan lembaga-lembaga yang terkait dengan pengembangan Fakultas Hukum\n" +
                    " \n" +
                    "Program Studi \n" +
                    "•\tKEHUKUMAN\n",R.drawable.fh, "https://www.youtube.com/watch?v=Ag9paBWHU2I","fH@upnjatim.ac.id"))
        partList.add(FakultasData("RINGGO MURTADHO YANWAR","Nama \t: RINGGO MURTADHO YANWAR\n" +
                "TTL\t: Nganjuk, 9 Juni 1999\n" +
                "Alamat\t: Griya Permata Gedangan G1 No 7, Keboansikep, Gedangan, Sidoarjo\n" +
                "No Hp\t: 081333333048\n" +
                "Email\t: ringgoyanwr@gmail.com\n",R.drawable.fotoq, "fhukum.upnjatim.ac.id/","iniringgo@gmail.com"))

        return partList
    }


    }


