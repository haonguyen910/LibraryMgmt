package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Borrow {
	private int id;
	private Date created;
	private Date due_date;
	private int id_employee;
	private int id_customer;
	private double deposit;
	private boolean status;
	private List<BorrowDetail> borrowDetailList = new ArrayList<BorrowDetail>();
	private String employeeName;
	private String customerName;

//	ToString
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", created=" + created + ", due_date=" + due_date + ", id_employee=" + id_employee
				+ ", id_customer=" + id_customer + ", deposit=" + deposit + ", status=" + status + ", borrowDetailList="
				+ borrowDetailList + ", employeeName=" + employeeName + ", customerName=" + customerName + "]";
	}

//	Constructor
	public Borrow() {
		super();
	}

<<<<<<< Updated upstream
	public Borrow(int id, Date created, Date due_date, int id_employee, int id_customer, double deposit, boolean status,
			List<BorrowDetail> borrowDetailList, String employeeName, String customerName) {
=======
	public Borrow(int id, Date created, Date due_date, int id_employee, int id_customer, double deposit,
			List<BorrowDetail> borrowDetailList, String employeeName, String customerName, String callNumber, boolean status) {
>>>>>>> Stashed changes
		super();
		this.id = id;
		this.created = created;
		this.due_date = due_date;
		this.id_employee = id_employee;
		this.id_customer = id_customer;
		this.deposit = deposit;
		this.status = status;
		this.borrowDetailList = borrowDetailList;
		this.employeeName = employeeName;
		this.customerName = customerName;
	}

//Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<BorrowDetail> getBorrowDetailList() {
		return borrowDetailList;
	}

	public void setBorrowDetailList(List<BorrowDetail> borrowDetailList) {
		this.borrowDetailList = borrowDetailList;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
