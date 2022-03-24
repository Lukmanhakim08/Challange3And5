package com.example.challange3and5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_input_nama.*

class DuaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_nama, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_screentiga.setOnClickListener {
            if (edt_nama.text.isNotEmpty()){
                val nama = edt_nama.text.toString()
                val data = bundleOf("NAMA" to nama)
                Navigation.findNavController(view).navigate(R.id.get_screentiga, data)
            }else{
                Toast.makeText(btn_screentiga.context, "Imputan nama harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}