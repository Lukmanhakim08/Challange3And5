package com.example.challange3and5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_identitas.*

class EmpatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_identitas, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_inputident.setOnClickListener {
            //chek apakah imputan sudh di isi atau tidak
            if (edt_usia.text.isNotEmpty() && edt_alamat.text.isNotEmpty() && edt_pekerjaan.text.isNotEmpty()){
                if (edt_usia.text.toString().all { Character.isDigit(it) }){
                    val namasaya = arguments?.getString("NAMA")
                    val usia = edt_usia.text.toString().toInt()
                    val alamat = edt_alamat.text.toString()
                    val pekerjaan = edt_pekerjaan.text.toString()
                    val ambildata = DataUser(namasaya, usia, alamat, pekerjaan)
                    val kirimdata = bundleOf("DATAUSER" to ambildata)
                    Navigation.findNavController(view).navigate(R.id.back_screentiga, kirimdata)
                }else{
                    Toast.makeText(btn_inputident.context, "Imputan usia harus berupa angka", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(btn_inputident.context, "Semua Imputan harus berupa angka", Toast.LENGTH_SHORT).show()
            }
        }
    }
}