package java17assignment;

final record LecturerRecord(String name, Integer age, Faculty faculty, Department department) {
    public LecturerRecord {
        if(name.isBlank() || age < 0) {
            String errorMessage = """
                    Illegal Argument Passed:
                       "name": %s,
                       "age": "%s
                    """.formatted(name, age);

            throw new IllegalArgumentException(errorMessage);
        }
    }

    boolean hasPhd() {
        String prefix = name.toUpperCase().substring(0, 3);
        String suffix = name.toUpperCase().substring(name.length() - 3);

        return
                switch (prefix) {
                    case "DR." -> true;
                    default ->
                        switch (suffix) {
                            case "PHD" -> true;
                            default -> false;
                        };
                };
    }

    void whichFaculty() {
        switch (faculty) {
            case EngineeringFaculty engineeringFaculty -> {
                System.out.println("Faculty of: " + engineeringFaculty);
                engineeringFaculty.engineering();
            }

            case HumanitiesFaculty humanitiesFaculty -> {
                System.out.println("Faculty of: " + humanitiesFaculty);
                humanitiesFaculty.humanities();
            }

            case BusinessFaculty businessFaculty -> {
                System.out.println("Faculty of: " + businessFaculty);
                businessFaculty.business();
            }

            default -> throw new IllegalArgumentException("Invalid Faculty: " + faculty);
        }
    }

    void whichDept() {
        switch (department) {
            case ComputerEngineeringDept computerEngineeringDept -> {
                System.out.println("Department of " + computerEngineeringDept);
                computerEngineeringDept.compEng();
            }

            case SoftwareEngineeringDept softwareEngineeringDept -> {
                System.out.println("Department of " + softwareEngineeringDept);
                softwareEngineeringDept.swEng();
            }

            case SocialCareDept socialCareDept -> {
                System.out.println("Department of " + socialCareDept);
                socialCareDept.socialCare();
            }

            case AccountingDept accountingDept -> {
                System.out.println("Department of " + accountingDept);
                accountingDept.accounting();
            }

            default -> throw new IllegalArgumentException("Invalid Department: " + department);
        }
    }
}
