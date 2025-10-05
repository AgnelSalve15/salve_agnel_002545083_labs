package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;

public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business("Information Systems");

        PersonDirectory persondirectory = business.getPersonDirectory();
        
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");
        Person person009 = persondirectory.newPerson("Fidelity");

        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        StudentProfile studentprofile1 = studentdirectory.newStudentProfile(person005);
        
        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person007);
        FacultyProfile facultyprofile1 = facultydirectory.newFacultyProfile(person008);

        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(employeeprofile0, "admin", "admin");
        UserAccount ua2 = uadirectory.newUserAccount(studentprofile0, "adam", "adam");
        UserAccount ua3 = uadirectory.newUserAccount(studentprofile1, "jim", "jim");
        UserAccount ua4 = uadirectory.newUserAccount(facultyprofile0, "laura", "laura");
        UserAccount ua5 = uadirectory.newUserAccount(facultyprofile1, "jack", "jack");

        return business;
    }
}