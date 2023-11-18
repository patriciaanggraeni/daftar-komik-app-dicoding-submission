package com.example.aplikasi_sederhana.sedeer

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.models.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object ComicSeeder {

    fun seed(context: Context) = listOf(
        Comic(
            title = "Chainsaw Man",
            image = getBitmap(context, R.drawable.chainsaw_man),
            genre = listOf(
                "Action", "Comedy", "Horror",
                "Mature", "Mistery", "Psychological",
                "Shounen", "Supernatunal", "Tragedy"
            ),
            description = R.string.chainsaw_man_description,
            like = false,
            rating = 8.5f
        ),
        Comic(
            title = "Solo Leveling",
            image = getBitmap(context, R.drawable.solo_leveling),
            genre = listOf("Action", "Adventure", "Fantasy", "Shounen"),
            description = R.string.solo_leveling_description,
            like = false,
            rating = 8.8f
        ),
        Comic(
            title = "Shingeki No Kyoujin",
            image = getBitmap(context, R.drawable.shingeki_no_kyoujin),
            genre = listOf("Action", "Drama", "Fantasy", "Horror", "Mature", "Shounen", "Supernatural", "Tragedy"),
            description = R.string.shingeki_no_kyoujin_description,
            like = false,
            rating = 8.6f
        ),
        Comic(
            title = "The Beginning After the End",
            image = getBitmap(context, R.drawable.the_beginning_after_the_end),
            genre = listOf("Action", "Adventure", "Fantasy", "Isekai", "School Life", "Shounen", "Tragedy"),
            description = R.string.the_beiginning_after_the_end_description,
            like = false,
            rating = 7.7f
        ),
        Comic(
            title = "Sakamoto Days",
            image = getBitmap(context, R.drawable.sakamoto_days),
            genre = listOf("Action", "Comedy", "Shounen", "Supernatural"),
            description = R.string.sakamoto_days_description,
            like = false,
            rating = 7.6f
        ),
        Comic(
            title = "8Kaijuu",
            image = getBitmap(context, R.drawable.ha_kaijuu),
            genre = listOf( "Action","Comedy", "Horror", "Sci-fi", "Shounen"),
            description = R.string.ha_kaijuu_description,
            like = false,
            rating = 8.0f
        ),
        Comic(
            title = "Yuru Camp",
            image = getBitmap(context, R.drawable.yuru_camp),
            genre = listOf("Adventure", "Comedy", "Seinen", "Slice of Life"),
            description = R.string.yuru_camp_description,
            like = false,
            rating = 8.4f
        ),
        Comic(
            title = "Tokyo Ghoul",
            image = getBitmap(context, R.drawable.tokyo_ghoul),
            genre = listOf("Action", "Horror", "Mature", "Psychological", "Seinen", "Supernatural", "Tragedy"),
            description = R.string.tokyo_ghoul_description,
            like = false,
            rating = 8.4f
        ),
        Comic(
            title = "Akame ga KILL!",
            image = getBitmap(context, R.drawable.akame_ga_kill),
            genre = listOf("Action", "Drama", "Fantasy", "Romance", "Shounen", "Supernatural", "Tragedi"),
            description = R.string.akame_ga_kill_description,
            like = false,
            rating = 9.51f
        ),
        Comic(
            title = "Kubo-san wa Boku wo Yurusanai",
            image = getBitmap(context, R.drawable.kubo_san),
            genre = listOf("Comedy", "Romance", "School Life", "Seinen"),
            description = R.string.kubo_san_description,
            like = false,
            rating = 7.9f
        )
    )

    private fun getBitmap(context: Context, image: Int): Bitmap {
        return BitmapFactory.decodeResource(context.resources, image)
    }

}