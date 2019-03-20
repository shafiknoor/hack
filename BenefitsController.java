package com.infy.hackathon.benefits.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.infy.hackathon.benefits.EmergencyRoom;
import com.infy.hackathon.benefits.EmergencyRoom_;
import com.infy.hackathon.benefits.InNetwork;
import com.infy.hackathon.benefits.OutOfNetwork;
import com.infy.hackathon.benefits.PlanBenefits;
import com.infy.hackathon.benefits.repository.BenefitsRepository;

@RestController
@CrossOrigin(origins="*")
public class BenefitsController {

    @Autowired
    BenefitsRepository benefitsRepository;

    @RequestMapping(value="/v1/benefits" , method=RequestMethod.GET)
    public PlanBenefits getTodoById(@RequestParam("id") String id) throws JSONException {
    	
    	
    	PlanBenefits planBenefit = null ;
    	Optional<PlanBenefits> planBenefits = benefitsRepository.findById(id);
//                .map(todo -> ResponseEntity.ok().body(todo))
//                .orElse(ResponseEntity.notFound().build());
    	if (planBenefits.isPresent()){
    		planBenefit = planBenefits.get();
    	}
    	
    	transformPlanBenefits(planBenefit,"emergencyRoom","coinsurance");
    	return planBenefit;
    }
    PlanBenefits transformPlanBenefits(PlanBenefits planBenefits,String benefitKey, String benefitValue) throws JSONException
    {
    	InNetwork inNetwork  = planBenefits.getNetWorkType().getInNetwork();
    	InNetwork newInNetwork  = new InNetwork();
    	OutOfNetwork outNetwork  = planBenefits.getNetWorkType().getOutOfNetwork();
    	OutOfNetwork newOutNetwork  = new OutOfNetwork();
    	EmergencyRoom emergencyRoom =planBenefits.getNetWorkType().getInNetwork().getEmergencyRoom();
    	EmergencyRoom_ outemergencyRoom=planBenefits.getNetWorkType().getOutOfNetwork().getEmergencyRoom();
    	EmergencyRoom newemergencyRoom= new EmergencyRoom();
    	EmergencyRoom_ newoutemergencyRoom= new EmergencyRoom_();
    	
    	Gson gson = new Gson();
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			String jsonString = mapper.writeValueAsString(inNetwork);
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
			Set<String> keys = jsonObject.keySet();
			System.out.println(keys);
			for(String key : keys)
			{
				if(key.equalsIgnoreCase(benefitKey))
				{
//					jsonObject.remove(key);
//					break;
					JsonObject jsonObject1=  (JsonObject) jsonObject.get(key);
//					String jsonString1 = mapper.writeValueAsString(jsonObject1);
					JsonObject json = new JsonObject();
					    json.add(benefitKey, jsonObject1);
					newInNetwork = gson.fromJson(json, InNetwork.class);
				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	planBenefits.getNetWorkType().setInNetwork(newInNetwork);
    	
    	
    	try {
			String jsonString = mapper.writeValueAsString(outNetwork);
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
			Set<String> keys = jsonObject.keySet();
			System.out.println(keys);
			for(String key : keys)
			{
				if(key.equalsIgnoreCase(benefitKey))
				{
//					jsonObject.remove(key);
//					break;
					JsonObject jsonObject1=  (JsonObject) jsonObject.get(key);
//					String jsonString1 = mapper.writeValueAsString(jsonObject1);
					JsonObject json = new JsonObject();
					    json.add(benefitKey, jsonObject1);
					    newOutNetwork = gson.fromJson(json, OutOfNetwork.class);
				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	planBenefits.getNetWorkType().setOutOfNetwork(newOutNetwork);
    	
    	// Balaji added 
    	try {
			String jsonString = mapper.writeValueAsString(emergencyRoom);
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
			Set<String> keys = jsonObject.keySet();
			for(String key : keys)
			{
				if(key.equalsIgnoreCase(benefitValue))
				{
					JsonPrimitive prim = (JsonPrimitive) jsonObject.get(key);
					JsonObject json = new JsonObject();
					json.add(benefitValue, prim);
					newemergencyRoom = gson.fromJson(json, EmergencyRoom.class);
				}
			}
			planBenefits.getNetWorkType().getInNetwork().setEmergencyRoom(newemergencyRoom);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	try {
			String jsonString = mapper.writeValueAsString(outemergencyRoom);
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
			Set<String> keys = jsonObject.keySet();
			for(String key : keys)
			{
				if(key.equalsIgnoreCase(benefitValue))
				{
					JsonPrimitive prim1 = (JsonPrimitive) jsonObject.get(key);
					JsonObject json = new JsonObject();
					json.add(benefitValue, prim1);
					newoutemergencyRoom = gson.fromJson(json, EmergencyRoom_.class);
				}
			}
			planBenefits.getNetWorkType().getOutOfNetwork().setEmergencyRoom(newoutemergencyRoom);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	return planBenefits;
    	
    }

    
}