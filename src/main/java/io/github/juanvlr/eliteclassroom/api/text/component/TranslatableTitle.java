package io.github.juanvlr.eliteclassroom.api.text.component;

import net.kyori.adventure.title.Title;

public class TranslatableTitle {

    private final TranslatableComponent title;
    private final TranslatableComponent subTitle;
    private final Title.Times times;

    public TranslatableTitle(TranslatableComponent title, TranslatableComponent subTitle, Title.Times times) {
        this.title = title;
        this.subTitle = subTitle;
        this.times = times;
    }

    public static TranslatableTitle from(
            TranslatableComponent title,
                                         TranslatableComponent subTitle,
                                         Title.Times times
    ) {
        return new TranslatableTitle(title, subTitle, times);
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
