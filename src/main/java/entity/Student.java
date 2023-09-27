package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Student implements Serializable{
	@Id
	private Long dni;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String surname;
	@Column(nullable=false)
	private char genre;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private Long studentId;
	@Column(nullable=false)
	private String city;
	@OneToMany(mappedBy="career")
	private List<StudentCareer>careers;
	
	
	public Student() {
		super();
		this.careers=new ArrayList<StudentCareer>();
	}
	
	public Student(Long dni, String name, String surname, char genre, int age, Long studentId, String city) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.age = age;
		this.studentId = studentId;
		this.city = city;
		this.careers=new ArrayList<StudentCareer>();
	}
	public ArrayList<StudentCareer> getCareers() {
		return new ArrayList<StudentCareer>(this.careers);
	}
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public char getGenre() {
		return genre;
	}
	public void setGenre(char genre) {
		this.genre = genre;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}

