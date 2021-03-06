package serenitylabs.tutorials.trains.features.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matcher;
import serenitylabs.tutorials.trains.journeys.TheAvailableJourneys;
import serenitylabs.tutorials.trains.navigation.Navigate;
import serenitylabs.tutorials.trains.search.DepartureDay;
import serenitylabs.tutorials.trains.search.FindTickets;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.trains.navigation.Section.BuyTickets;

public class BuyTicketsStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has decided to check available tickets$")
    public void decided_to_travel_by_train(String personaName) throws Throwable {
        theActorCalled(personaName).attemptsTo(
                Navigate.to(BuyTickets)
        );
    }

    //    @When("^s?he looks at a trip from (.*) to (.*) leaving (.*)$")
//    public void looks_at_a_trip(String origin,
//                                String destination,
//                                DepartureDay departureDay) throws Throwable {
//
//        theActorInTheSpotlight().attemptsTo(
//                FindTickets
//                        .forAOneWayTrip()
//                        .from(origin)
//                        .to(destination)
//                        .leaving(departureDay)
//        );
//    }
    @When("^s?he looks at a trip from (.*) to (.*) leaving (.*) on (.*)$")
    public void looks_at_a_trip(String origin,
                                String destination,
                                DepartureDay departureDay,
                                String flyclass) throws Throwable {

        theActorInTheSpotlight().attemptsTo(
                FindTickets
                        .forAOneWayTrip()
                        .from(origin)
                        .to(destination)
                        .on(flyclass)
                        .leaving(departureDay)
        );
    }

    @Then("^s?he should be shown the cheapest (.*) ticket price from (.*) to (.*)")
    public void she_should_be_shown_the_cheapest_ticket_price(String ticketType,
                                                              String expectedOrigin,
                                                              String expectedDestination) throws Throwable {
        theActorInTheSpotlight().should(
                seeThat("Cheapest price", TheAvailableJourneys.lowestPrice(), isPresent()),
                seeThat("Ticket type", TheAvailableJourneys.ticketType(), equalToIgnoringCase(ticketType)),
                seeThat("Origin station", TheAvailableJourneys.origin(), containsString(expectedOrigin)),
                seeThat("Destination station", TheAvailableJourneys.destination(), containsString(expectedDestination))
        );
    }

    private Matcher<String> isPresent() {
        return not(isEmptyString());
    }

    @When("she does everything")
    public void sheDoesEverything() {
        theActorInTheSpotlight().attemptsTo(
                GivenThatHe
                        .leaving("abcde")


        );
    }
}
