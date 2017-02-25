package ru.spec.javaee.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.spec.java3.ejb.api.HHBean;
import ru.spec.javaee.ejb.entity.Employee;
import ru.spec.javaee.ejb.entity.Office;
import ru.spec.javaee.ejb.util.Serial;

/**
 * Session Bean implementation class HHBeanImpl
 */
@Stateless(mappedName="hh")
@LocalBean
public class HHBeanImpl implements HHBean {

	@Inject
	Logger log;
	
	@Inject
	@Serial
//	@PersistenceContext
	EntityManager em;
	
	@Override
	public long createEmployee(String name){
		log.info(name);
		
		Employee e = new Employee();
		
		e.setName(name);
		e.setOffice(em.createNamedQuery("Office.findAll",Office.class).getResultList().get(0));
		
		em.persist(e);
		em.flush();
		
		return e.getId();
	}

	@Override
	public String getNameBy(long id){
		List<Employee> list = em.createQuery("SELECT e FROM Employee e "
				+ "WHERE e.id=:employee_id ", Employee.class)
			.setParameter("employee_id", id)
			.getResultList();
		if(list==null || list.size()==0)
			return null;
		return list.get(0).getName();
	}
	

}
