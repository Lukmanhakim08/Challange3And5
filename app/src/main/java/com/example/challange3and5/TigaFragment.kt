package com.example.challange3and5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_tampil.*

class TigaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tampil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.containsKey("DATAUSER") == true){
            val datauser = arguments?.getParcelable<DataUser>("DATAUSER")
            val nama = datauser?.nama
            val usia = datauser?.usia
            val alamat = datauser?.alamat
            val pekerjaan = datauser?.pekerjaan
            val ket = if (usia?.rem(2) == 0){
                "Bernilai Genap"
            }else{
                "Bernilai Ganjil"
            }
            text_nama.text = "Nama Saya : $nama\n" +
                    "Usia : $usia, $ket\n" +
                    "Alamat : $alamat\n" +
                    "Pekerjaan : $pekerjaan"
        }else{
            val nama = arguments?.getString("NAMA")
            text_nama.setText("Nama Saya : $nama")
        }

        btn_screenempat.setOnClickListener {
            val nama = if (arguments?.containsKey("DATAUSER") == true){
                arguments?.getParcelable<DataUser>("NAMA")
            }else{
                arguments?.getString("NAMA")
            }
            val kirimnama = bundleOf("NAMA" to nama )
            Navigation.findNavController(view).navigate(R.id.get_screenempat, kirimnama)
        }
    }
}