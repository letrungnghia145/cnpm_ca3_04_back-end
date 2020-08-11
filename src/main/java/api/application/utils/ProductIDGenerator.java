package api.application.utils;

import java.io.Serializable;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIDGenerator implements IdentifierGenerator {
	private String prefix = "PROD";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Query query = session.createQuery("SELECT count(*) FROM Product");
		return prefix + String.format("%04d", Integer.parseInt(query.getSingleResult().toString()) + 1);
	}
}