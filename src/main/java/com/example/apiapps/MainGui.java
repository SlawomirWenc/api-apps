package com.example.apiapps;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport(value = "./css/style.css")
public class MainGui extends VerticalLayout{

    public MainGui() {

        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        Label labelTitle = new Label("My api apps");
        labelTitle.addClassName("title");

        Button buttonJokes = new Button("Jokes app", event -> UI.getCurrent().navigate("jokes"));

        layout.add(labelTitle);
        layout.add(buttonJokes);

        add(layout);
    }
}
