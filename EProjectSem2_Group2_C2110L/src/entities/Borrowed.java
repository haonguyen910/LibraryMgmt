package entities;

import java.util.Date;

public class Borrowed {
	private int id;
	private int id_borrow;
	private Date created_borrow;
	private Date due_date_borrow;
	private int overdue_day;
	private double deposit_borrow;
	private double fines;
	private double total;
	private Date created;
	private int employeeId;
	private int customerId;

//ToString
	@Override
	public String toString() {
		return "Borrowed [id=" + id + ", id_borrow=" + id_borrow + ", created_borrow=" + created_borrow
				+ ", due_date_borrow=" + due_date_borrow + ", overdue_day=" + overdue_day + ", deposit_borrow="
				+ deposit_borrow + ", fines=" + fines + ", total=" + total + ", created=" + created + ", employeeId="
				+ employeeId + ", customerId=" + customerId + "]";
	}

//Constructor

	public Borrowed() {
		super();
	}

	public Borrowed(int id, int id_borrow, Date created_borrow, Date due_date_borrow, int overdue_day,
			double deposit_borrow, double fines, double total, Date created, int employeeId, int customerId) {
		super();
		this.id = id;
		this.id_borrow = id_borrow;
		this.created_borrow = created_borrow;
		this.due_date_borrow = due_date_borrow;
		this.overdue_day = overdue_day;
		this.deposit_borrow = deposit_borrow;
		this.fines = fines;
		this.total = total;
		this.created = created;
		this.employeeId = employeeId;
		this.customerId = customerId;
	}

//Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_borrow() {
		return id_borrow;
	}

	public void setId_borrow(int id_borrow) {
		this.id_borrow = id_borrow;
	}

	public Date getCreated_borrow() {
		return created_borrow;
	}

	public void setCreated_borrow(Date created_borrow) {
		this.created_borrow = created_borrow;
	}

	public Date getDue_date_borrow() {
		return due_date_borrow;
	}

	public void setDue_date_borrow(Date due_date_borrow) {
		this.due_date_borrow = due_date_borrow;
	}

	public int getOverdue_day() {
		return overdue_day;
	}

	public void setOverdue_day(int overdue_day) {
		this.overdue_day = overdue_day;
	}

	public double getDeposit_borrow() {
		return deposit_borrow;
	}

	public void setDeposit_borrow(double deposit_borrow) {
		this.deposit_borrow = deposit_borrow;
	}

	public double getFines() {
		return fines;
	}

	public void setFines(double fines) {
		this.fines = fines;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
