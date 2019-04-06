package org.ivangrod.rssclean.steps;

import com.google.common.io.Resources;
import com.rometools.rome.io.SyndFeedInput;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.FeedListener;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.helpers.World;
import org.ivangrod.rssclean.infrastructure.repositories.MongoDBPostDocumentRepository;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CollectFeedSteps extends AbstractStepsConfiguration {

    @Autowired
    private UseCase<CollectingFeedParams> collectFeed;

    @Autowired
    private PostCollection postCollection;

    @Autowired
    private MongoDBPostDocumentRepository mongoDBPostRepository;

    @Autowired
    private FeedListener feedListener;

    private SyndFeedInput feedInput = mock(SyndFeedInput.class);

    @Autowired
    private World world;

    @Given("^an URI related with an external RSS feed$")
    public void anURIRelatedWithAnExternalRSSFeed() throws Throwable {
        world.setFeed(new MockFeed("xml/netflix-techblog.xml", "Netflix"));
        setUp();
    }

    @When("^the collecting process is fired up$")
    public void theCollectingProcessIsFfiredUp() {
        List<Post> postsCollected = (List<Post>) collectFeed.execute(new CollectingFeedParams(world.getFeed()
                .getSource(), world.getFeed()
                .getUri()
                .toString()));
        world.setPostsCollected(postsCollected);
    }

    @Then("^the created posts are stored$")
    public void theCreatedPostsAreStored() {
        assertEquals(world.getPostsCollected()
                .size(), postCollection.readAll()
                .size());
    }

    private void setUp() throws Throwable {
        clean();
    }

    private void clean() {
        mongoDBPostRepository.deleteAll();
    }

    class MockFeed extends Feed {

        public MockFeed(String fileName, String source) {
            super(Resources.getResource(fileName), source);
        }
    }
}
