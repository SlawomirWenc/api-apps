package com.example.apiapps;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainGui extends VerticalLayout{

    public MainGui() {

        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        Label labelTitle = new Label("My api apps");
        labelTitle.getStyle().set("font-size","50px");

        Button buttonJokes = new Button("Jokes app", event -> UI.getCurrent().navigate("jokes"));
        Button buttonJobs = new Button("GitHub Jobs app", event -> UI.getCurrent().navigate("jobs"));
        Button buttonUrlShorter = new Button("Url shorter app", event -> UI.getCurrent().navigate("urlShorter"));

        layout.add(labelTitle);
        layout.add(buttonJokes);
        layout.add(buttonJobs);
        layout.add(buttonUrlShorter);

        add(layout);
    }
}
