package com.example.reflect;

import com.example.base.bean.Person;
import com.example.base.bean.Person.Gender;

import java.beans.*;
import java.util.stream.Stream;

/**
 * Author by Sun, Date on 2020/1/15.
 * PS: Not easy to write code, please indicate.
 * BeanInfo 接口描述一个java beans的详细信息,包括其每个字段的描述
 * 其中每个字段的描述,每个字段的对应的读写方法等.
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String name = propertyDescriptor.getName();
            if ("genderOfEnum".equals(name)) {
                propertyDescriptor.setPropertyEditorClass(StringToEnum.class);
                //TODO Sun 2020/1/15 地去读取,并转换类型代办
                PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(getPerson());
                System.out.println("propertyEditor = " + propertyEditor);
            }
        });
    }

    public static Person getPerson() {
        Person person = new Person();
        person.setGenderOfEnum(Gender.MAN);
        person.setName("老孙");
        person.setGender("男");
        return person;
    }

    static class StringToEnum extends PropertyEditorSupport {

        public StringToEnum(Object source) {
            super(source);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Person.Gender.valueOf(text));
        }

    }

}
