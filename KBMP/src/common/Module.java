package common;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @description This class contains all the information about a module
 * @author Joey
 *
 */
public class Module {
	public enum WorkloadTypes {LECTURE, TUTORIAL, LABORATORY, CONTINUOUS_ASSESSMENT, PREPARATORY_WORK};

	private String code = "";
	private String name = "";
	private int credits = -1;
	private String department = "";
	private String description = "";
	private Hashtable<Module.WorkloadTypes, Integer> workload = new Hashtable<>();
	private ArrayList<String> prerequisites = new ArrayList<>();
	private ArrayList<String> corequisites = new ArrayList<>();
	private ArrayList<String> preclusions = new ArrayList<>();
	private ArrayList<Lesson> timetable = new ArrayList<>();
	private Exam exam = new Exam();
	private ArrayList<String> types = new ArrayList<>();

	public static class Builder {
		private String code = "";
		private String name = "";
		private int credits = -1;
		private String department = "";
		private String description = "";
		private Hashtable<Module.WorkloadTypes, Integer> workload = new Hashtable<>();
		private ArrayList<String> prerequisites = new ArrayList<>();
		private ArrayList<String> corequisites = new ArrayList<>();
		private ArrayList<String> preclusions = new ArrayList<>();
		private ArrayList<Lesson> timetable = new ArrayList<>();
		private Exam exam = new Exam();
		private ArrayList<String> types = new ArrayList<>();

		public Module build(){
			return new Module(this);
		}

		public Builder setCode(String code){
			this.code = code;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setCredits(int credits) {
			this.credits = credits;
			return this;
		}

		public Builder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setWorkload(Hashtable<Module.WorkloadTypes, Integer> workload) {
			this.workload = workload;
			return this;
		}

		public Builder setPrerequisites(ArrayList<String> prerequisites) {
			this.prerequisites = prerequisites;
			return this;
		}

		public Builder setCorequisites(ArrayList<String> corequisites) {
			this.corequisites = corequisites;
			return this;
		}

		public Builder setPreclusions(ArrayList<String> preclusions) {
			this.preclusions = preclusions;
			return this;
		}

		public Builder setTimetable(ArrayList<Lesson> timetable) {
			this.timetable = timetable;
			return this;
		}

		public Builder setExam(Exam exam) {
			this.exam = exam;
			return this;
		}

		public Builder setTypes(ArrayList<String> types) {
			this.types = types;
			return this;
		}
	}

	public static Builder builder(){
		return new Builder();
	}

	private Module(Builder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.credits = builder.credits;
		this.department = builder.department;
		this.description = builder.description;
		this.workload = builder.workload;
		this.prerequisites = builder.prerequisites;
		this.corequisites = builder.corequisites;
		this.preclusions = builder.preclusions;
		this.timetable = builder.timetable;
		this.exam = builder.exam;
		this.types = builder.types;
	}

	public Module(String code, String name){
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getDescription() {
		return description;
	}

	public int getCredits() {
		return credits;
	}

	public Hashtable<Module.WorkloadTypes, Integer> getWorkload() {
		return workload;
	}

	public Exam getExam() {
		return exam;
	}

	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}

	public ArrayList<String> getCorequisites() {
		return corequisites;
	}

	public ArrayList<Lesson> getTimetable() {
		return timetable;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public String toString() {
		return "[" + this.code + ", " + this.name + "]";
	}
}
