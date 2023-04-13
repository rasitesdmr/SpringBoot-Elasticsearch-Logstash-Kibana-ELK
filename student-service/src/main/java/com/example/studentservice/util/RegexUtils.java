package com.example.studentservice.util;


import com.example.studentservice.exception.BadRequestException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
@Slf4j
public class RegexUtils {

    public String schoolNumberRegex(String schoolNo) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(schoolNo);
        if (matcher.find()) {
            return schoolNo;
        } else {
            log.error("Okul numarası 10 haneli olmalı . Harf içermemeli . Özel Karakter içermemeli ...");
            throw new BadRequestException(" Okul numarası 10 haneli olmalı . Harf içermemeli .  Özel Karakter içermemeli ...");
        }
    }

    public String schoolTcNo(String tcNo) {
        String regex = "^(?!0)\\d{11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tcNo);
        if (matcher.find()) {
            return tcNo;
        } else {
            log.error("TC numarası 11 haneli olmalı. Sıfır ile başlamamalı. Harf içermemeli. Özel Karakter içermemeli.");
            throw new BadRequestException("TC numarası 11 haneli olmalı. Sıfır ile başlamamalı. Harf içermemeli. Özel Karakter içermemeli.");
        }
    }
}