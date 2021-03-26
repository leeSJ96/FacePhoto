package com.example.face

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.google.firebase.ml.vision.face.FirebaseVisionFace
import com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark
import java.net.IDN

class FaceGraphic(overlay: GraphicOverlay?, var firebaseVisionFace: FirebaseVisionFace?, var lensBitmap: Bitmap?) : GraphicOverlay.Graphic(overlay) {

    val  idPoint = Paint().apply {
        color = Color.WHITE
    }
    override fun draw(canvas: Canvas?) {
       var face = firebaseVisionFace?: return

        drawBitmapOverLandmarkPosition(canvas, face, null, FirebaseVisionFaceLandmark.RIGHT_EYE)
        drawBitmapOverLandmarkPosition(canvas, face, null, FirebaseVisionFaceLandmark.LEFT_EYE)
    }
    fun drawBitmapOverLandmarkPosition(canvas: Canvas?,face: FirebaseVisionFace,overlayBitmap: Bitmap?,landmarkID: Int){
        val landmark = face.getLandmark(landmarkID)
        val point = landmark?.position
        if (point != null){
            canvas?.drawCircle(translateX(point.x),translateY(point.y),5f,idPoint)
        }
    }

}