package com.nyble.models.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nyble.topics.consumer.ConsumerValue;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Consumer {

    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson localGson;
    private static final Type consumerType = new TypeToken<Consumer>(){}.getType();
    static{
        localGson = gsonBuilder.registerTypeAdapter(consumerType, new ConsumerAdapter()).create();
    }

    public static Gson getConsumerGson(){
        return localGson;
    }

    public static Consumer fromJson(String jsonRep){
        return localGson.fromJson(jsonRep, Consumer.class);
    }

    private Map<String, CAttribute> attributes = new HashMap<>();

    public void setProperty(String consumerProp, CAttribute attribute) {
        attributes.put(consumerProp, attribute);
    }

    public String getValue(String attributeName){
        CAttribute attr = attributes.get(attributeName);
        return attr!=null ? attr.getValue() : null;
    }

    public String getTimestamp(String attributeName){
        CAttribute attr = attributes.get(attributeName);
        return attr!=null ? attr.getLut() : null;
    }

    public void setFlag(ConsumerFlag flag){
        String now = new Date().getTime()+"";
        CAttribute flagsAttribute = attributes.get("flags");
        if(flagsAttribute == null){
            flagsAttribute = new CAttribute("0", now);
            attributes.put("flags", flagsAttribute);
        }else{
            flagsAttribute.setLut(now);
            if(flagsAttribute.getValue().isEmpty()){
                flagsAttribute.setValue("0");
            }
        }

        int newVal = Integer.parseInt(flagsAttribute.getValue());
        newVal |= (1<<flag.getBitPosition());
        flagsAttribute.setValue(newVal+"");
    }

    public void unsetFlag(ConsumerFlag flag){
        String now = new Date().getTime()+"";
        CAttribute flagsAttribute = attributes.get("flags");
        if(flagsAttribute == null){
            flagsAttribute = new CAttribute("0", now);
            attributes.put("flags", flagsAttribute);
        }else{
            flagsAttribute.setLut(now);
            if(flagsAttribute.getValue().isEmpty()){
                flagsAttribute.setValue("0");
            }
        }

        int newVal = Integer.parseInt(flagsAttribute.getValue());
        newVal &= ~(1<<flag.getBitPosition());
        flagsAttribute.setValue(newVal+"");
    }

    public boolean isFlagSet(ConsumerFlag flag){
        CAttribute flagsAttribute = attributes.get("flags");
        if(flagsAttribute == null){
            return false;
        }
        int flagNumeric = (flagsAttribute.getValue()!=null && !flagsAttribute.getValue().isEmpty()) ?
                Integer.parseInt(flagsAttribute.getValue()) : 0;
        return (flagNumeric & (1<<flag.getBitPosition())) != 0;
    }

//    private String firstName;
//    private String lastName;
//    private String fullName;
//    private String phone;
//    private String email;
//    private String location;
//    private String birthDate;
//    private String systemId;
//    private String consumerId;
//    private String entityId;
//    private String affinity_125; //Sobranie
//    private String affinity_127; //Winston
//    private String affinity_117; //Camel
//    private String affinity_138; //LOGIC
//
//    private Map<String, String> extraInfo = new HashMap<>();
//
//    public Map<String, String> getFullConsumer(){
//        Map<String, String> map = new HashMap<>(extraInfo);
//        map.put("firstName", firstName);map.put("lastName", lastName);map.put("fullName", fullName);
//        map.put("phone", phone);map.put("email", email);map.put("location", location);
//        map.put("birthDate", birthDate);map.put("systemId", systemId);map.put("consumerId", consumerId);
//        map.put("entityId", entityId);map.put("affinity_125", affinity_125);map.put("affinity_127", affinity_127);
//        map.put("affinity_117", affinity_117);map.put("affinity_138", affinity_138);
//        return map;
//    }
//
//    public String getFullConsumerJson(){
//        Map<String, String> map = new HashMap<>(extraInfo);
//        map.put("firstName", firstName);map.put("lastName", lastName);map.put("fullName", fullName);
//        map.put("phone", phone);map.put("email", email);map.put("location", location);
//        map.put("birthDate", birthDate);map.put("systemId", systemId);map.put("consumerId", consumerId);
//        map.put("entityId", entityId);map.put("affinity_125", affinity_125);map.put("affinity_127", affinity_127);
//        map.put("affinity_117", affinity_117);map.put("affinity_138", affinity_138);
//        return new Gson().toJson(map);
//    }
//
//    public String getSmallConsumerJson(){
//        Map<String, String> map = new HashMap<>();
//        map.put("firstName", firstName);map.put("lastName", lastName);map.put("fullName", fullName);
//        map.put("phone", phone);map.put("email", email);map.put("location", location);
//        map.put("birthDate", birthDate);map.put("systemId", systemId);map.put("consumerId", consumerId);
//        map.put("entityId", entityId);map.put("affinity_125", affinity_125);map.put("affinity_127", affinity_127);
//        map.put("affinity_117", affinity_117);map.put("affinity_138", affinity_138);
//        return new Gson().toJson(map);
//    }
//
//
//    public void setProperty(String consumerProp, String value) {
//
//        if(consumerProp.equalsIgnoreCase("firstName")){
//            firstName = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("lastName")){
//            lastName = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("fullName")){
//            fullName = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("phone")){
//            phone = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("email")){
//            email = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("entityId")){
//            entityId = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("location")){
//            location = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("birthDate")){
//            birthDate = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("affinity_117")){
//            affinity_117 = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("affinity_125")){
//            affinity_125 = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("affinity_127")){
//            affinity_127 = value;
//            return;
//        }
//
//        if(consumerProp.equalsIgnoreCase("affinity_138")){
//            affinity_138 = value;
//            return;
//        }
//
//        extraInfo.put(consumerProp, value);
//    }
//
//    public String getAffinity_125() {
//        return affinity_125;
//    }
//
//    public void setAffinity_125(String affinity_125) {
//        this.affinity_125 = affinity_125;
//    }
//
//    public String getAffinity_127() {
//        return affinity_127;
//    }
//
//    public void setAffinity_127(String affinity_127) {
//        this.affinity_127 = affinity_127;
//    }
//
//    public String getAffinity_117() {
//        return affinity_117;
//    }
//
//    public void setAffinity_117(String affinity_117) {
//        this.affinity_117 = affinity_117;
//    }
//
//    public String getAffinity_138() {
//        return affinity_138;
//    }
//
//    public void setAffinity_138(String affinity_138) {
//        this.affinity_138 = affinity_138;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSystemId() {
//        return systemId;
//    }
//
//    public void setSystemId(String sourceSystem) {
//        this.systemId = sourceSystem;
//    }
//
//    public String getConsumerId() {
//        return consumerId;
//    }
//
//    public void setConsumerId(String consumerId) {
//        this.consumerId = consumerId;
//    }
//
//    public String getEntityId() {
//        return entityId;
//    }
//
//    public void setEntityId(String entityId) {
//        this.entityId = entityId;
//    }
}