public class PersonBuilder {
    private String name;
    private int age;
    private String gender;
    private String location;
    private String bio;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public PersonBuilder setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public Person createPerson() {
        return new Person(name, age, gender, location, bio);
    }
}