package iteso.mx.materialdesign

import android.app.Application
import com.parse.Parse

class MaterialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("v1kx8QckHwFoOhVF6JqOIkY77Y3ancPhksQnt4k6")
                .clientKey("fVER38fcRHHMHtrS10xq8BnTAsQdrDKvoXSR3maP")
                .server("https://parseapi.back4app.com/")
                .build()
        )
    }
}
