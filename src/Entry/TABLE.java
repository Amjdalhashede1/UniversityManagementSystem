/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Entry;

public enum TABLE {
    DEPARTMENTS, STUDENTS, PHOTOES,PHONES, DOCTORS, MANAGERS, MARKS;

    public enum MANAGER {
        MANAGER_NAME;
    }

    public enum DEPARTMENT {
        MANAGER_ID, DEPT_ID, DEPT_NAME, AMOUNTFEES, EDUCATIONLEVEL, YEARCOUNT;
    }

    public enum STUDENT {
        REGESTY_NUMBER, SECURITY_NUMBER, STD_ID, STD_NAME, STD_GENDER, DATE_JOIN, SCHOOLYEAR, SEMESTER, LEVELS, BATCHNUMBER, BATCHNAME;
    }
    
     public enum PHOTOE {
        PHOTO_ID, PHOTO_TYPE, RESOURSE, PHOTO;
    }
      public enum PHONE {
        PHONE_TYPE, PHONE_NUMBER;
    }
    public enum DOCTOR {
        DOCTOR_ID, DOCTOR_NAME, QUALIFICATION, DOCTOR_GENDER, LITIGATION, SALARY;
    }

    public enum MARK {
        MARK_ID, STUDY_ID, STD_ID, ATTENDANCETHEORITY, SHARINGTHEORITY, MIDDLETHEORITY, FINALTHEORITY, ATTENDANCEPRACTIS, SHARINGPRACTIS, FINALPRACTIS, THESUM
    }

   

    public enum STUDYPLANING {
        STUDYPLANING, DEPT_ID, DEPT_NAME, MANAGER_ID, SEMESTER, COURSE_CODE, DOCTOR_THEORITY_NAME,
        DOCTOR_PRACTICAL_NAME
    }

    public enum SUBJECT {
        COURSE_CODE, COURSE_NAME, HOURTHEORITY, HOUREXERSIZE, HOURPRACTICAL;
    }

    public enum VIEW {
        Department_DATA_TABLE, MANAGER_NOT_IN_DEPARTMENT, DEPARTMENT_NOT_HAVE_CHILD, DEPARTMENT_DATA, STUDENT_DATA_TABLE, STUDENT_DATA;
    }

    public enum SEARCH {
        TABLE, GET, VALUE, BY;
    }

    public enum GENDER {
        MALE("ذكر"), FAMEL("انثى");
        private final String value;

        GENDER(String value) {
            this.value = value;
        }

       public String getValue() {
            return value;
        }
    }
    public enum PHONETYPE{
        PERSONAL_PHONE("شخصي"),GURDIAN("ولي الأمر");
        String type="";

        private PHONETYPE(String type) {
            this.type=type;
        }
        
        public Object getPhoneType(){
            return type;
        }
    }
    public enum RESOURSE {
        DOCTOR, STUDENT;
    }

    public enum DOCEMENT_TYPE {
        PERSONAL, CV, PERSONAL_CARD;
    }

}
