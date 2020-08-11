package api.application.utils;

import java.io.Serializable;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIDGenerator implements IdentifierGenerator{
	private String prefix = "USER";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Query query = session.createQuery("SELECT count(*) FROM User");
		return prefix + String.format("%04d", Integer.parseInt(query.getSingleResult().toString()) + 1);
	}
}
