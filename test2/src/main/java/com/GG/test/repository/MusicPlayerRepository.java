package com.GG.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.GG.test.model.Music;

@Repository
@Transactional
public class MusicPlayerRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public void save(Music music) {
		getSession().save(music);
	}
	public List<Music> getMusic(){
		DetachedCriteria dc = DetachedCriteria.forClass(Music.class);
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<Music> music =criteria.list();
		return music;
	}	
}
