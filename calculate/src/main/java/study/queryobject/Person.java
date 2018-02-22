package study.queryobject;

import lombok.Data;

/**
 * Personドメインオブジェクト.
 */
@Data
public class Person extends DomainObject {
	private String firstName;
//	private String lastName;

	public Person(long id, String firstName, String lastName, int numberOfDependents) {
		super(id);
		this.firstName = firstName;
//		this.lastName = lastName;
	}

}
