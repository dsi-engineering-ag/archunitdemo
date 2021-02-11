package ch.dsi.archunitdemo.service;

import ch.dsi.archunitdemo.domain.Bar;
import ch.dsi.archunitdemo.domain.Foo;
import org.springframework.stereotype.Service;

@Service
public class FooBarService {

    public Bar calculateBar(Foo foo) {
        return new Bar(foo.toString());
    }
}
