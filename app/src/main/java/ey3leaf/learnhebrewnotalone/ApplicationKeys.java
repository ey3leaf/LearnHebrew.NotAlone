package ey3leaf.learnhebrewnotalone;

import android.app.Application;

import com.parse.Parse;

public class ApplicationKeys extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this,"asgKkVx7iEbK5j7MQ1tBKwc26JAqmVeZcn8yXRWa","gA2fIFr5TZsUHjbudwBrg26tk302BSBSpa497PKt");
    }
}
