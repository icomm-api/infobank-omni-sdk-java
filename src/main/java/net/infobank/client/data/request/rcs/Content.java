package net.infobank.client.data.request.rcs;

import net.infobank.client.data.request.rcs.content.Carousel;
import net.infobank.client.data.request.rcs.content.Standalone;
import net.infobank.client.data.request.rcs.content.Template;

public class Content {

    public static Standalone.Builder StandaloneBuilder(){
        return new Standalone.Builder();
    }

    public static Carousel.Builder CarouselBuilder(){
        return new Carousel.Builder();
    }

    public static Template.Builder TemplateBuilder(){
        return new Template.Builder();
    }

}
