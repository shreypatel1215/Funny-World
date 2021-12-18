package com.example.memeshare

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URI
import java.net.URL
import java.util.Calendar.getInstance

class MainActivity : AppCompatActivity() {
    var current:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeame()
    }
    private fun loadMeame(){
        val queue = Volley.newRequestQueue(this) //Volley is an HTTP library that makes networking for Android apps easier
        val url = "https://meme-api.herokuapp.com/gimme"
        pop.visibility = View.VISIBLE
// Request a string response from the provided URL.
        val jasonobjrequest= JsonObjectRequest(Request.Method.GET, url,null,
            { response ->
                current=response.getString("url")
                Glide.with(this).load(current).listener(object :RequestListener<Drawable>{ //Glide is an Image Loader Library for Android
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                       pop.visibility=View.GONE
                        return false
                    }
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        pop.visibility=View.GONE
                        return false
                    }
                }).into(memeImageView)
                // Display the first 500 characters of the response string.

            },
            Response.ErrorListener {
                Toast.makeText(this,"somthing is wrong",Toast.LENGTH_LONG).show()
            }
     )

// Add the request to the RequestQueue.
        queue.add(jasonobjrequest)
//        val textView = findViewById<TextView>(R.id.text)
//// ...'
//        pop.visibility=View.VISIBLE
//
//// Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//         url ="https://meme-api.herokuapp.com/gimme"
//        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
//            { response ->
//                  url=response.getString("url")
//                Glide.with(this).load(url).listener(object :RequestListener<Drawable>{
//                    override fun onLoadFailed(
//                        e: GlideException?,
//                        model: Any?,
//                        target: Target<Drawable>?,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        pop.visibility=View.GONE
//                        return false
//                    }
//
//                    override fun onResourceReady(
//                        resource: Drawable?,
//                        model: Any?,
//                        target: Target<Drawable>?,
//                        dataSource: DataSource?,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        pop.visibility=View.GONE
//                        return false
//                    }
//                }).into(memeImageView)
//
//             },
//            { error ->
//            }
//        )
//
//// Access the RequestQueue through your singleton class.
//    queue.add(jsonObjectRequest)



}



    fun sharebutton(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "ohh! do you know this is meame! just smash on it    $current")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "shared meme")
        startActivity(shareIntent)

    }
    fun nextbutton(view: View) {
        loadMeame()
    }




}




