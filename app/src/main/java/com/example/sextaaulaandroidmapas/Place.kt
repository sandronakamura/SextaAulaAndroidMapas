package com.example.sextaaulaandroidmapas

import android.media.Rating
import com.google.android.gms.maps.model.LatLng
import java.net.Inet4Address

// Classe de localizacão
data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)
