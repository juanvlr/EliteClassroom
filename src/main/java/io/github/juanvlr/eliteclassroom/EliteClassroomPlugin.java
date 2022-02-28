package io.github.juanvlr.eliteclassroom;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.github.juanvlr.eliteclassroom.api.APIModule;
import io.github.juanvlr.eliteclassroom.api.plugin.PluginModule;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBootstrap;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class EliteClassroomPlugin extends JavaPlugin {

    private static final Stage PLUGIN_STAGE = Stage.DEVELOPMENT;

    @Override
    public void onEnable() {
        Injector injector = Guice.createInjector(PLUGIN_STAGE,
                new PluginModule(this),
                new APIModule(),
                new CoreModule()
        );

        injector.getInstance(PluginBootstrap.class).boostrap();

        getLogger().info("Plugin enabled successfully");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled successfully");
    }
}
