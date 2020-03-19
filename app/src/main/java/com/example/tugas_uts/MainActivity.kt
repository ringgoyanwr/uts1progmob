package com.example.tugas_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

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
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.foto.toString())
        startActivity(showDetailActivityIntent)
}
    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("FAKULTAS ILMU KOMPUTER","Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi: \n" +
                "1. Teknik Informatika \n" +
                "2. Sistem Informasi\n",R.drawable.logo))
        partList.add(FakultasData("FAKULTAS TEKNIK","Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi: \n" +
                "1. Teknik Kimia \n" +
                "2. Teknik Industri\n" +
                "3. Teknik Sipil\n" +
                "4. Teknik Lingkungan\n" +
                "5. Teknologi Pangan\n",R.drawable.logo))
        partList.add(
            FakultasData("FAKULTAS EKONOMI BISNIS","Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi: \n" +
                    "1. Ekonomi Pembangunan \n" +
                    "2. Akutansi\n" +
                    "3. Manajemen\n",R.drawable.logo))
        partList.add(
            FakultasData("FAKULTAS PERTANIAN","Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi: \n" +
                    "1. Agroteknologi \n" +
                    "2. Agribisnis\n",R.drawable.logo))
        partList.add(FakultasData("RINGGO MURTADHO YANWAR","Nama \t: RINGGO MURTADHO YANWAR\n" +
                    "TTL\t: Nganjuk, 9 Juni 1999\n" +
                    "Alamat\t: Griya Permata Gedangan G1 No 7, Keboansikep, Gedangan, Sidoarjo\n" +
                    "No Hp\t: 081333333048\n" +
                    "Email\t: ringgoyanwr@gmail.com\n",R.drawable.fotoq))

        return partList
    }
}

