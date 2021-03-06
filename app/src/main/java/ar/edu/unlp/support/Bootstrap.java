package ar.edu.unlp.support;

import android.app.Application;

import ar.edu.unlp.support.config.Configuration;
import ar.edu.unlp.support.config.ProdConfiguration;
import ar.edu.unlp.support.di.AppComponent;
import ar.edu.unlp.support.di.AppModule;
import ar.edu.unlp.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this.getApplicationContext(), getConfiguration());
        component = DaggerAppComponent.builder().appModule(appModule).build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public void setComponent(AppComponent component) {
        this.component = component;
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
