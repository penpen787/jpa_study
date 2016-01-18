package chap7.joinstrategy.test;

import javax.persistence.EntityManager;

import chap7.joinstrategy.dto.Album;
import chap7.joinstrategy.dto.Movie;
import common.TransactionBaseTest;

public class JoinStrategyTest extends TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		Album album = new Album();
		album.setArtist("Whitney Houston");
		album.setName("Greatest Love Of All");
		album.setPrice(10000);
		
		em.persist(album);
		
		Movie movie = new Movie();
		movie.setActor("Whitney Houston");
		movie.setDirector("UNKNOWN");
		movie.setPrice(5000);
		movie.setName("Bodyguard");
		
		em.persist(movie);
		
	}

}
