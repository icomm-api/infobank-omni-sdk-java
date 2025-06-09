package net.infobank.client.data.request.rcs;

import net.infobank.client.data.request.rcs.button.CalendarButton;
import net.infobank.client.data.request.rcs.button.ComTextButton;
import net.infobank.client.data.request.rcs.button.ComVideoButton;
import net.infobank.client.data.request.rcs.button.CopyButton;
import net.infobank.client.data.request.rcs.button.DialButton;
import net.infobank.client.data.request.rcs.button.MapLocationButton;
import net.infobank.client.data.request.rcs.button.MapQueryButton;
import net.infobank.client.data.request.rcs.button.MapSendButton;
import net.infobank.client.data.request.rcs.button.UrlButton;

public class Button {

    public static UrlButton.Builder UrlButtonBuilder(){
        return new UrlButton.Builder();
    }

    public static CalendarButton.Builder CarlendarButtonBuilder(){
        return new CalendarButton.Builder();
    }

    public static ComTextButton.Builder ComTextButtonBuilder(){
        return new ComTextButton.Builder();
    }

    public static ComVideoButton.Builder ComVideoButtonBuilder(){
        return new ComVideoButton.Builder();
    }

    public static CopyButton.Builder CopyButtonBuilder(){
        return new CopyButton.Builder();
    }

    public static DialButton.Builder DialButtonBuilder(){
        return new DialButton.Builder();
    }

    public static MapLocationButton.Builder MapLocationButtonBuilder(){
        return new MapLocationButton.Builder();
    }

    public static MapQueryButton.Builder MapQueryButtonBuilder(){
        return new MapQueryButton.Builder();
    }

    public static MapSendButton.Builder MapSendButtonBuilder(){
        return new MapSendButton.Builder();
    }
}
