package serenitylabs.tutorials.trains.features.steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.search.JourneyDetails;

public class abcdeeee implements Task {
    private final String abcde;

    public abcdeeee(String abcde) {
        this.abcde = abcde;
    }

    @Override
    @Step("Got to here")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(JourneyDetails.ONEWAY_BUTTON)
        );
    }
}
