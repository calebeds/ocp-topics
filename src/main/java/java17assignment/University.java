package java17assignment;

class University {
    public static void main(String[] args) {
//        LecturerRecord joe = new LecturerRecord("", 22, new BusinessFaculty(), new SocialCareDept());
//        LecturerRecord joe = new LecturerRecord("Joe", -3, new BusinessFaculty(), new SocialCareDept());
        LecturerRecord joe = new LecturerRecord("Joe", 30, new BusinessFaculty(), new SocialCareDept());

        joe.whichDept();
        joe.whichFaculty();
    }
}
