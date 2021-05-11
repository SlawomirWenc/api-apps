package com.example.apiapps.jobSearchApp.gui;

import com.example.apiapps.ApiParser;
import com.example.apiapps.jobSearchApp.model.Job;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.io.IOException;


@Route("jobs")
public class JobsGui extends VerticalLayout {

    public JobsGui() throws IOException {
        Icon IconBackToMain = new Icon(VaadinIcon.ANGLE_LEFT);
        IconBackToMain.getStyle().set("cursor", "pointer");
        IconBackToMain.addClickListener(event -> UI.getCurrent().navigate(""));

        Label labelTitle = new Label("GitHub Jobs");
        labelTitle.getStyle().set("font-size","50px");

        Grid<Job> grid = new Grid<>(Job.class);

        VerticalLayout layoutMain = new VerticalLayout();
        layoutMain.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout layoutSearch = new HorizontalLayout();
        TextField textFieldSearch = new TextField();
        textFieldSearch.setLabel("Search");

        TextField textFieldLocation = new TextField();
        textFieldLocation.setLabel("Location");

        Button buttonSearch = new Button("Search", buttonClickEvent -> {
            try {
                fillGrid(grid, textFieldSearch.getValue(), textFieldLocation.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        layoutSearch.add(textFieldSearch, textFieldLocation);
        layoutMain.add(labelTitle, layoutSearch, buttonSearch);

        add(IconBackToMain);
        add(layoutMain);
        add(grid);

        fillGrid(grid,"", "");
    }

    public void fillGrid(Grid<Job> grid, String search, String location) throws IOException {

        Job[] jobs = ApiParser.getJobFromApi(search, location);
        grid.setItems(jobs);
        grid.setColumns("title", "company", "location");
        grid.addComponentColumn(item -> new Button("Go to page", clickEvent -> UI.getCurrent().getPage().open(item.getUrl())))
                .setHeader("Url");
    }
}