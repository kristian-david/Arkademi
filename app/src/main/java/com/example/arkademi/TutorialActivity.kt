package com.example.arkademi

import android.R
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.graphics.Color
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.media.MediaPlayer.OnVideoSizeChangedListener
import android.os.Build
import android.os.Bundle
import android.view.Surface
import android.view.TextureView
import android.view.TextureView.SurfaceTextureListener
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.arkademi.databinding.ActivityTutorialBinding
import java.io.IOException


class TutorialActivity : AppCompatActivity(), SurfaceTextureListener, OnVideoSizeChangedListener {

    private lateinit var textureView: TextureView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var fileDescriptor: AssetFileDescriptor

    lateinit var binding: ActivityTutorialBinding
    var tutorialProgress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "KotlinApp"
        textureView = binding.textureView
        textureView.surfaceTextureListener = this
        mediaPlayer = MediaPlayer()
        try {
            fileDescriptor = assets.openFd("background_video.mp4")
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        binding.nextButton.setOnClickListener{ proceed()}
        binding.textureView.visibility = View.GONE

        supportActionBar?.hide()

    }

    private fun proceed() {
        val loadingBar = arrayOf(binding.circleBar1,binding.circleBar2,binding.circleBar3)
        tutorialProgress = tutorialProgress.plus(1)
        setLoadingBar(loadingBar)
        if (tutorialProgress == 1){
            binding.nextButton.setBackgroundColor(Color.argb(10,0,114,53))
            loadingBar[1].setColorFilter(Color.rgb(250,250,250))
            proceedSecondScreen()
        } else if (tutorialProgress == 2){
            loadingBar[2].setColorFilter(Color.rgb(250,250,250))
            proceedThirdScreen()
        } else if (tutorialProgress == 3){
            val intent = Intent(this@TutorialActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setLoadingBar(loadingBar: Array<ImageView>){
        for (i in 0..2) {
            loadingBar[i].setColorFilter(Color.rgb(117,117,117));
        }
    }

    private fun proceedSecondScreen(){
        binding.iconImage.visibility = View.GONE
        binding.subtitleText1.visibility = View.GONE
        binding.subtitleText2.visibility = View.VISIBLE
        binding.textureView.visibility = View.VISIBLE
        binding.backgroundOverlay.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        //starting the animation
        binding.textureView.startAnimation(animation)
        binding.backgroundOverlay.startAnimation(animation)
    }

    private fun proceedThirdScreen(){
        binding.subtitleText2.visibility = View.GONE
        binding.subtitleText3.visibility = View.VISIBLE

    }

    override fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture, width: Int, height: Int) {
        val surface = Surface(surfaceTexture)
        try {
            mediaPlayer.setSurface(surface)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mediaPlayer.setDataSource(fileDescriptor)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener { mediaPlayer.start() }
                mediaPlayer.isLooping = true
            }
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
    }
    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {}
    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        return false
    }
    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {}
    override fun onVideoSizeChanged(mp: MediaPlayer, width: Int, height: Int) {}
}