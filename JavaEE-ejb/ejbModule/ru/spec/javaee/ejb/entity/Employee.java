package ru.spec.javaee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the `old-LN_Employee` database table.
 * 
 */
@Entity
@Table(name="`old-LN_Employee`")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean del;

	@Column(nullable=false, length=1024)
	private String name;

	//bi-directional many-to-one association to Office
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="office", nullable=false)
	private Office office;

	//bi-directional many-to-many association to Title
	@ManyToMany
	@JoinTable(
		name="`old-LN_titile_employee`"
		, joinColumns={
			@JoinColumn(name="employee", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="title", nullable=false)
			}
		)
	private List<Title> titles;

	public Employee() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getDel() {
		return this.del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

}