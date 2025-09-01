package java17assignment;

sealed class Department permits ComputerEngineeringDept, SoftwareEngineeringDept, SocialCareDept, AccountingDept {
}

final class ComputerEngineeringDept extends Department {
    void compEng() {
        System.out.println("Custom computer Engineering");
    }

    @Override
    public String toString() {
        return "Computer Engineering";
    }
}
final class SoftwareEngineeringDept extends Department {
    void swEng() {
        System.out.println("Custom software engineering");
    }

    @Override
    public String toString() {
        return "Software Engineering";
    }
}
final class SocialCareDept extends Department {
    void socialCare() {
        System.out.println("Custom Social Care");
    }

    @Override
    public String toString() {
        return "Social Care";
    }
}
final class AccountingDept extends Department {
    void accounting() {
        System.out.println("Custom Accounting");
    }

    @Override
    public String toString() {
        return "Accounting";
    }
}