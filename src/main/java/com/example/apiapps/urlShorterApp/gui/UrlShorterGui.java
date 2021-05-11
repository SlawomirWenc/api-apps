package com.example.apiapps.urlShorterApp.gui;

import com.example.apiapps.ApiParser;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("urlShorter")
public class UrlShorterGui extends VerticalLayout {

    public UrlShorterGui() {
        VerticalLayout layoutMain = new VerticalLayout();
        layoutMain.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Label labelTitle = new Label("Url Shorter");
        labelTitle.getStyle().set("font-size","50px");

        Icon IconBackToMain = new Icon(VaadinIcon.ANGLE_LEFT);
        IconBackToMain.getStyle().set("cursor", "pointer");
        IconBackToMain.addClickListener(event -> UI.getCurrent().navigate(""));

        TextArea textArea  = new TextArea();
        textArea.setPlaceholder("Paste URL here");
        textArea.getStyle().set("maxHeight", "100px");

        Button buttonDoMagic = new Button("DO MAGIC !!!", buttonClickEvent -> {
            String shorterLink = ApiParser.getLink(textArea.getValue());
            TextField textFieldShorterUrl = new TextField("", shorterLink, "");
            layoutMain.add(textFieldShorterUrl);
        });

        layoutMain.add(labelTitle, textArea, buttonDoMagic);
        add(IconBackToMain, layoutMain);
    }
}
