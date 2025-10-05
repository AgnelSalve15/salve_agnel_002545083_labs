package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;

public class FacultyDirectory {

    ArrayList<FacultyProfile> facultylist;

    public FacultyDirectory() {
        facultylist = new ArrayList();
    }

    public FacultyProfile newFacultyProfile(Person p) {
        FacultyProfile fp = new FacultyProfile(p);
        facultylist.add(fp);
        return fp;
    }

    public FacultyProfile findFaculty(String id) {
        for (FacultyProfile fp : facultylist) {
            if (fp.isMatch(id)) {
                return fp;
            }
        }
        return null;
    }
}