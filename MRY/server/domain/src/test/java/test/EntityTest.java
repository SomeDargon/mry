package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mry.entity.common.image.Image;

public class EntityTest {
	public static void main(String[] args) {
		configLogback();
		// testLazyLoad();
		testLazyLoad();

	}

	private static void configLogback() {
		configLogback("org.hibernate", ch.qos.logback.classic.Level.WARN);
		configLogback("java.sql", ch.qos.logback.classic.Level.WARN);

		configLogback("net.sf.ehcache", ch.qos.logback.classic.Level.WARN);
		configLogback("n.s.e.config", ch.qos.logback.classic.Level.WARN);
	}

	private static void configLogback(String packageName,
			ch.qos.logback.classic.Level level) {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory
				.getLogger(packageName);
		if (!(logger instanceof ch.qos.logback.classic.Logger)) {
			return;
		}
		ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) logger;
		logbackLogger.setLevel(level);
	}

	private static void testLazyLoad() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistence.mry");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		StringBuilder builder = new StringBuilder(
				"SELECT m FROM Image m ");


		Query query = em.createQuery(builder.toString());

		List<Image> images =query.getResultList();

		System.out.println(images.size());

		for(Image image : images){
			if(image.getNormalUrl()!=null){
				image.setNormalUrl(image.getNormalUrl().replaceAll("localhost:8080", "116.62.201.135:8080"));
			}
			if(image.getOriginalUrl()!=null ){
				image.setOriginalUrl(image.getOriginalUrl().replaceAll("localhost:8080", "116.62.201.135:8080"));
			}
			em.merge(image);
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	private static void test() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistence.mry");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
