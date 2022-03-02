package io.github.juanvlr.eliteclassroom.api.text.component;

import net.kyori.adventure.title.Title;

public class TranslatableTitleComponent {

    private final TranslatableComponent title;
    private final TranslatableComponent subTitle;
    private final Title.Times times;

    public TranslatableTitleComponent(TranslatableComponent title, TranslatableComponent subTitle, Title.Times times) {
        this.title = title;
        this.subTitle = subTitle;
        this.times = times;
    }

    public static TranslatableTitleComponent from(
            TranslatableComponent title,
                                         TranslatableComponent subTitle,
                                         Title.Times times
    ) {
        return new TranslatableTitleComponent(title, subTitle, times);
    }

    public TranslatableComponent getTitle() {
        return this.title;
    }

    public TranslatableComponent getSubTitle() {
        return this.subTitle;
    }

    public Title.Times getTimes() {
        return this.times;
    }
}
