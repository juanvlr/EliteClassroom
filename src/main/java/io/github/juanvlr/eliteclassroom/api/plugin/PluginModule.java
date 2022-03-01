package io.github.juanvlr.eliteclassroom.api.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.MembersInjector;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBoostrapImpl;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBootstrap;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class PluginModule extends AbstractModule {

    private final Plugin plugin;

    public PluginModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bindListener(Matchers.any(), new Log4JTypeListener());

        bind(PluginBootstrap.class).to(PluginBoostrapImpl.class);
    }

    @Provides
    public Plugin providePlugin() {
        return this.plugin;
    }

    @Provides
    @PluginDataFolder
    public File providePluginDataFolder(Plugin plugin) {
        return plugin.getDataFolder();
    }

    @Provides
    public PluginManager providePluginManager() {
        return Bukkit.getPluginManager();
    }

    @Provides
    public BukkitAudiences provideAudiences(Plugin plugin) {
        return BukkitAudiences.create(plugin);
    }

    private class Log4JTypeListener implements TypeListener {

        public <T> void hear(TypeLiteral<T> type, TypeEncounter<T> encounter) {
            Class<?> clazz = type.getRawType();

            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getType() == Logger.class && field.isAnnotationPresent(InjectLogger.class)) {
                        encounter.register(new Log4JMembersInjector<>(field));
                    }
                }

                clazz = clazz.getSuperclass();
            }
        }
    }

    private class Log4JMembersInjector<T> implements MembersInjector<T> {

        private final Field field;
        private final Logger logger;

        public Log4JMembersInjector(Field field) {
            this.field = field;
            this.logger = PluginModule.this.plugin.getLogger();

            field.setAccessible(true);
        }

        public void injectMembers(T instance) {
            try {
                field.set(instance, logger);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
