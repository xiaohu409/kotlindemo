package com.github.kotlindemo.activity

import android.view.View
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.github.kotlindemo.R
import com.github.kotlindemo.base.BaseActivity
import com.github.kotlindemo.databinding.ActivityCameraXBinding
import com.google.common.util.concurrent.ListenableFuture

class CameraXActivity : BaseActivity() {

    private lateinit var binding: ActivityCameraXBinding;
    private lateinit var cameraProviderFuture : ListenableFuture<ProcessCameraProvider>

    override fun getLayoutId(): Int {
        return R.layout.activity_camera_x;
    }

    override fun getView(): View {
        binding = ActivityCameraXBinding.inflate(layoutInflater);
        return binding.root;
    }

    override fun initUI() {
    }

    override fun bindData() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get()
            bindPreview(cameraProvider)
        }, ContextCompat.getMainExecutor(this));
    }

    private fun bindPreview(cameraProvider : ProcessCameraProvider) {
        var preview : Preview = Preview.Builder()
            .build();

        var cameraSelector : CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build();

        preview.setSurfaceProvider(binding.previewView.surfaceProvider);

        var camera = cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview);
    }
}