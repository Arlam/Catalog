package my.catalog.dao.impl;

import my.catalog.dao.IFileDAO;
import my.catalog.entities.FileEntity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO extends HibernateGenericDAO<FileEntity> implements
		IFileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public FileDAO() {
		super(FileEntity.class);
	}

	@Override
	public FileEntity findByPath(String absolutePath) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FileEntity.class);
		criteria.add(Restrictions.eq("path", absolutePath));
		FileEntity entity = (FileEntity) criteria.uniqueResult();
		return entity;
	}

}
