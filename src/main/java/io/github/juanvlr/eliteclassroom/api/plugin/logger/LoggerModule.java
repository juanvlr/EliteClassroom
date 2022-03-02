package io.github.juanvlr.eliteclassroom.api.plugin.logger;

import com.google.inject.AbstractModule;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class LoggerModule extends AbstractModule {

    private final Logger logger;

    public LoggerModule(Logger logger) {
        this.logger = logger;
    }

    @Override
    protected void configure() {
        bindListener(Matchers.any(), new Log4JTypeListener());
    }

    private class Log4JTypeListener implements TypeListener {

        public <T> void hear(TypeLiteral<T> type, TypeEncounter<T> encounter) {
            Class<?> clazz = type.getRawType();

            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getType() == Logger.class && field.isAnnotationPresent(InjectPluginLogger.class)) {
                        encounter.register(new Log4JMembersInjector<>(field));
                    }
                }

                clazz = clazz.getSuperclass();
            }
        }
    }

    private class Log4JMembersInjector<T> implements MembersInjector<T> {

        private final Field field;

        public Log4JMembersInjector(Field field) {
            this.field = field;
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
