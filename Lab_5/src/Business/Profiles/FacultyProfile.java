package Business.Profiles;

import Business.Person.Person;

public class FacultyProfile extends Profile {

    public FacultyProfile(Person p) {
        super(p);
    }

    @Override
    public String getRole() {
        return "Faculty";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
}   