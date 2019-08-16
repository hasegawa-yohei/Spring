package jp_co.good_works.lesson.springmvc.form;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class UserInfoForm {
@NotEmpty
private String name;

@NotNull
@Min(value = 10) 
private Integer age;

private String gender;

private String email;

private String birthplaces;

private List<String> favoriteLangs;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getBirthplaces() {
	return birthplaces;
}

public void setBirthplaces(String birthplaces) {
	this.birthplaces = birthplaces;
}

public List<String> getFavoriteLangs() {
	return favoriteLangs;
}

public void setFavoriteLangs(List<String> favoriteLangs) {
	this.favoriteLangs = favoriteLangs;
}

}
