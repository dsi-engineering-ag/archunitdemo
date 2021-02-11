package ch.dsi.archunitdemo.domain;

import java.util.Date;

public class Bar {
    private final String content;
    private final Date generated;

    public Bar(String content) {
        this.content = content;
        this.generated = new Date();
    }
}
