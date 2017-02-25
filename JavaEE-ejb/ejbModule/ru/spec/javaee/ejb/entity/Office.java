package ru.spec.javaee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the `old-LN_Office` database table.
 * 
 */
@Entity
@Table(name="`old-LN_Office`")
@NamedQueries({
	@NamedQuery(name="Office.findAll", query="SELECT o FROM Office o"),
	@NamedQuery(name="Office.findAll1", query="SELECT o FROM Office o")
})
public class Office implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private boolean del;

	@Column(length=1024, name="`desc`")
	private String desc;

	@Column(nullable=false, length=1024)
	private String name;

	@Column(nullable=false)
	private Timestamp ts;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="office")
	private List<Employee> employees;

	public Office() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getDel() {
		return this.del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setOffice(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setOffice(null);

		return employee;
	}

}