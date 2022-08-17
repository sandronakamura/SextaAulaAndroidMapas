package com.example.sextaaulaandroidmapas


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.sextaaulaandroidmapas.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap


import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity() {
    // Cria um array de objetos que contem localizações
    private val places = arrayListOf(
        // Adicionando novas localizações
        Place("FIAP Campus Vila Olimpia", LatLng(-23.5955843, -46.6851937), "Rua Olímpiadas, 186 - São Paulo - SP", 4.8f),
        Place("Fiap Campus Paulista", LatLng(-23.5643721, -46.652857), "Av. Paulista, 1106 - São Paulo - SP", 5.0f),
        Place("Fiap Campus Vila Mariana", LatLng(-23.5746685, -46.6232043), "Av. Lins de Vasconcelos, 1264 - São Paulo - SP", 4.8f)
    )


    // Criando variável binding que recebe a ActivityMainBinding
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout e salva na variável binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Aciona o binding.root quando inicializar
        setContentView(binding.root)

        // Instancia o fragment como SupportMapFragment e salva na variável mapFragment
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        // Executa o bloco de código assincronamente
        mapFragment.getMapAsync{
            // Aciona a função para adicionar os pinos no mapa
            googleMap -> addMarkers(googleMap)
        }


    }

    // Função para adicionar os pinos no mapa
    private fun addMarkers(googleMap: GoogleMap){
        // Percorre o array de lugares
        places.forEach { place ->
            // Adiciona o marcador no mapa
            googleMap.addMarker(
                // Adicionando as opções do marcador, como nome, endereço, latitude e o Icone vetorizado
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
                    .icon(BitmapHelper.vectorToBitmap
                        (this, R.drawable.ic_baseline_home_work_24,
                        ContextCompat.getColor(this, R.color.purple_700)
                    ))
            )

        }
    }

}

