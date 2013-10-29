package edu.rit.notification.entity2;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "CLASSSCHEDULE")
public class ClassSchedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8197844023061066344L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CLASSNUMBER")
	private String classNumber;
	
	@OneToOne
    @JoinColumn(
      name="COURSENUMBER")
	private Course course;
	
	@Column(name = "DAYS")
	private String days;
	
	//@Temporal(TemporalType.TIME)
	@Column(name = "STARTTIME")
	private Time startTime;
	
	//@Temporal(TemporalType.TIME)
	@Column(name = "ENDTIME")
	private Time endTime;
	
	@Column(name = "CLASSFORMAT")
	private String classFormat;
	
	@Column(name = "INSTRUCTOR")
	private String instructor;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name="ENROLLMENT",
			joinColumns=
			{@JoinColumn(name="CLASSNUMBER")},
			inverseJoinColumns=
			{@JoinColumn(name="UID")}
			)
	private List<Student> enrolledStudents;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourseNumber(Course course) {
		this.course = course;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
		
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public String getClassFormat() {
		return classFormat;
	}
	public void setClassFormat(String classFormat) {
		this.classFormat = classFormat;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	
	
}
