package org.ivangrod.rssclean.steps;

import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.ItemCollection;
import org.ivangrod.rssclean.helpers.NetflixFeedProvider;
import org.ivangrod.rssclean.helpers.World;
import org.ivangrod.rssclean.infrastructure.repositories.MongoDBItemDocumentRepository;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CollectFeedSteps extends AbstractStepsConfiguration {

    @Autowired
    private UseCase<CollectingFeedParams> collectFeed;

    @Autowired
    private ItemCollection itemCollection;

    @Autowired
    private MongoDBItemDocumentRepository mongoDBItemRepository;

    @Autowired
    private FeedListener feedListener;

    private SyndFeedInput feedInput = mock(SyndFeedInput.class);

    @Autowired
    private World world;

    @Given("^an URI related with an external RSS feed$")
    public void anURIRelatedWithAnExternalRSSFeed() throws Throwable {
        world.setSource(new Feed(new URL("https://medium.com/feed/netflix-techblog"), "Netflix"));
        setUp();
    }

    @When("^the collecting process is fired up$")
    public void theCollectingProcessIsFfiredUp() {
        List<Item> itemsCollected = (List<Item>) collectFeed.execute(new CollectingFeedParams(world.getSource()
                .getSource(), world.getSource()
                .getUri()
                .toString()));
        world.setItemsCollected(itemsCollected);
    }

    @Then("^the created items are stored$")
    public void theCreatedItemsAreStored() {
        assertEquals(world.getItemsCollected()
                .size(), itemCollection.readAll()
                .size());
    }

    private void setUp() throws Throwable {
        clean();
        ReflectionTestUtils.setField(feedListener, "input", feedInput);
        given(feedInput.build(any(XmlReader.class)))
                .willReturn(NetflixFeedProvider.getFeed(world.getSource()
                        .getUri()
                        .toString()));
    }

    private void clean() {
        mongoDBItemRepository.deleteAll();
    }
}
