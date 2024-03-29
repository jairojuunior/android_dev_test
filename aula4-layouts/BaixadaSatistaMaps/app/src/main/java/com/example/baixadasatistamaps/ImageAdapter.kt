package com.example.baixadasatistamaps

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

/**
 * Custom adapter to display image thumbnails
 */
class ImageAdapter : BaseAdapter() {
    // references to images (as resources)

    /*val city_names = App.context.getResources().obtainTypedArray(R.array.string_array_images_baixada)
    private var thumbnails = IntArray(city_names.length())*/


    private val thumbnails = arrayOf(
        R.drawable.bertioga, R.drawable.cubatao, R.drawable.guaruja,
        R.drawable.itanhaem, R.drawable.mongagua, R.drawable.peruibe,
        R.drawable.praia_grande, R.drawable.santos, R.drawable.sao_vicente)

    override fun getCount(): Int {
        return thumbnails.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /*for (i in thumbnails.indices){
            thumbnails[i] = city_names.getResourceId(i, 0)
        }*/

        val imageView: ImageView

        if (convertView == null) {
            imageView = ImageView(App.context)
            imageView.layoutParams = ViewGroup.LayoutParams(
                App.context.resources.getDimensionPixelSize(R.dimen.image_view_grid_width),
                App.context.resources.getDimensionPixelSize(R.dimen.image_view_grid_width))
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else
            imageView = convertView as ImageView

        imageView.setImageResource(thumbnails[position])

        return imageView
    }
}
