package com.example.sextaaulaandroidmapas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory


object BitmapHelper {
    // Cria um vetor personalizado para acionar o mapa
    fun vectorToBitmap(
        context: Context,
        @DrawableRes id: Int,
        @ColorInt color:Int
    ) : BitmapDescriptor {
        // Vetor diferente do que foi passado por parametro
        val vectorDrawable = ResourcesCompat.getDrawable(context.resources, id, null)
            ?: return BitmapDescriptorFactory.defaultMarker()
        // Cria o bitmap para ser adicionado no mapa
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        // Cria o canvas passando o bitmap
        val canvas = Canvas(bitmap)
        // Limites do vetor
        vectorDrawable.setBounds(0,0,canvas.width, canvas.height)
        // Cria o vetor
        DrawableCompat.setTint(vectorDrawable, color)
        // Retorna o vetor a ser exibido
        vectorDrawable.draw(canvas)

        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

}