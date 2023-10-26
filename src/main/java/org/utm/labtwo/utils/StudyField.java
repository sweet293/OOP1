package org.utm.labtwo.utils;

import org.utm.labtwo.enums.EnumField;

public class StudyField {

    public static boolean checkStudyField(String studyField) {
        try {
            EnumField.valueOf(studyField);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid study field");
            return false;
        }
    }

}
