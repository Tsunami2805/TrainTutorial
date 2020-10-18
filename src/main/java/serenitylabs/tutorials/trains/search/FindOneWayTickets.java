package serenitylabs.tutorials.trains.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.journeys.JourneyList;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FindOneWayTickets implements Task {
    private final String origin;
    private final String destination;
    private final DepartureDay departureDay;

    public FindOneWayTickets(String origin, String destination, DepartureDay departureDay) {
        this.origin = origin;
        this.destination = destination;
        this.departureDay = departureDay;
    }

    @Override
    @Step("{0} looks for a one-way ticket from #origin to #destination #departureDay")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(JourneyDetails.ONEWAY_BUTTON),
                SelectItinerary.from(origin).to(destination),
                EnterDate.of(departureDay).into(JourneyDetails.LEAVING_DATE),
                Click.on(JourneyDetails.BUY_TICKETS_BUTTON),
                WaitUntil.the(JourneyList.CHEAPEST_PRICE_TITLE, isVisible()).forNoMoreThan(300).seconds()
        );
    }
}
