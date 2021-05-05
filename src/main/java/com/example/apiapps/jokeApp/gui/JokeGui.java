package com.example.apiapps.jokeApp.gui;

import com.example.apiapps.ApiParser;
import com.example.apiapps.jokeApp.model.Joke;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Route("jokes")
@CssImport(value = "./css/style.css")
public class JokeGui extends VerticalLayout {

    public JokeGui() throws IOException {

        List<String> images = new ArrayList<>();
        initImagesTable(images);

        Joke joke = ApiParser.getJokeFromApi();
        Image image = new Image(getRandomImage(images), "hehe");

        VerticalLayout layoutMain = new VerticalLayout();
        layoutMain.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout layoutSetup = new VerticalLayout();
        layoutSetup.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout layoutPunchline = new VerticalLayout();
        layoutPunchline.setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        Icon IconBackToMain = new Icon(VaadinIcon.ANGLE_LEFT);
        IconBackToMain.getStyle().set("cursor", "pointer");
        IconBackToMain.addClickListener(event -> UI.getCurrent().navigate(""));

        Label labelTitle = new Label("Jokes");
        labelTitle.addClassName("title");

        Label labelInfo = new Label("(refresh page for more jokes)");
        labelInfo.addClassName("refreshInfo");

        Label textSetup = new Label(joke.getSetup());
        Label textPunchline = new Label(joke.getPunchline());

        Button buttonShowPunchline = new Button("Show", buttonClickEvent -> layoutMain.add(layoutPunchline));

        layoutSetup.add(textSetup, buttonShowPunchline);
        layoutPunchline.add(textPunchline, image, labelInfo);
        layoutMain.add(labelTitle, layoutSetup);
        add(IconBackToMain);
        add(layoutMain);
    }

    private void initImagesTable(List<String> images) {
        images.add("https://miastons.pl/wp-content/uploads/2020/02/GIF-laughing-funny-LOL-haha-hehe-hilarious-fun-happy-laugh-Kevin-Malone-Brian-Baumgartner-The-Office-GIF.gif");
        images.add("https://i.pinimg.com/originals/9e/7f/35/9e7f359c4b03a20c36e4a840e1a4b778.gif");
        images.add("https://i.pinimg.com/originals/a2/79/42/a2794207f35d5112497a629e5a5182bd.gif");
        images.add("https://i.pinimg.com/originals/c3/47/1f/c3471f38954d43bb49b76461d3969955.gif");
        images.add("https://thumbs.gfycat.com/FearlessWetEwe-size_restricted.gif");
        images.add("https://thumbs.gfycat.com/AgonizingImpressionableIberianlynx-size_restricted.gif");
        images.add("https://media.tenor.com/images/a7655f17075051edbd188c53cf725fac/tenor.gif");
        images.add("https://media.tenor.com/images/f7354b8c66dcf774a0cd75d1806e0d56/tenor.gif");
        images.add("https://i.pinimg.com/originals/f4/1c/47/f41c47022eb3a3e5dda89ffbbae00d86.gif");
        images.add("https://thumbs.gfycat.com/PlaintiveSeriousAntelopegroundsquirrel-size_restricted.gif");
    }

    public String getRandomImage(List<String > images){
        Random rand = new Random();
        int i = rand.nextInt(images.size());
        return images.get(i);
    }

}
